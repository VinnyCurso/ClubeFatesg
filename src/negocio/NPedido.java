/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EPedido;
import java.sql.SQLException;
import java.util.List;
import persistencia.PPedido;

/**
 *
 * @author vinicius caetano
 */
public class NPedido {
    
    PPedido pPedido;

    public NPedido() {
        pPedido = new PPedido();
    }

    public void salvar(EPedido pd) throws SQLException, Exception{
        if (validar(pd)){ 
            if (pd.getCodigo() == 0) {
                pPedido.incluir(pd);
            }else{
                pPedido.alterar(pd);
            }
        }
    }
    
    public void excluir(int codigo) throws SQLException{
        pPedido.excluir(codigo);
    }
    
    public EPedido consultar(int codigo) throws SQLException{
        return pPedido.consultar(codigo);
    }
    
    public List<EPedido> lista(EPedido pd) throws SQLException{
        return pPedido.listar(pd);
    }

    private boolean validar(EPedido pd) throws Exception {
        if (pd.getValorTotal() == 0) {
            throw new Exception("É necessário informar o valortotal");
        }
        if (pd.getDataPedido() == null) {
            throw  new Exception("Informe a data do pedido");
        }
       return true;
    }
    
}
