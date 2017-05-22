/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EItemPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class PItemPedido {

    public PItemPedido() {
    }

    public void incluir(EItemPedido item, Connection conection) throws SQLException {
        
        try {
            
            String sql = "INSERT INTO itempedido SET"
                    + " precoepoca = ?, quantidade = ?, "
                    + " codigo_produto = ?, codigo_pedido = ? "
                    + " VALUES(?,?,?,?)";
            
            PreparedStatement ps = conection.prepareStatement(sql);

            ps.setDouble(1, item.getPrecoEpoca());
            ps.setInt(2, item.getQuantidade());
            ps.setInt(3, (int) item.getProduto().getCodigo());
            ps.setInt(4, item.getPedido().getCodigo());

             ps.execute();
             
              String sql1 = "SELECT curval('itempedido_cod_seq')as, codigo";
              
              Statement stm = conection.createStatement();

              
               ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                item.setCodigo(rs.getInt("codigo"));
            }
  
            rs.close();
            conection.commit();

        } catch (Exception e) {

            conection.rollback();
        }

        conection.close();
    }

    public void alterar(EItemPedido item, Connection conection) throws SQLException {
        
        try {
            
              String sql = "UPADET itempedido SET "
                    + " precoepoca = ?, quantidade = ?, "
                    + " codigo_produto = ?, codigo_pedido = ?"
                    + " WHERE codigo = ?";
              
               PreparedStatement ps = conection.prepareStatement(sql);

            ps.setDouble(1, item.getPrecoEpoca());
            ps.setInt(2, item.getQuantidade());
            ps.setInt(3, (int) item.getProduto().getCodigo());
            ps.setInt(4, item.getPedido().getCodigo());
            ps.setInt(5, (int) item.getCodigo());
            
             ps.execute();
             
               conection.commit();
            
        } catch (Exception e) {
             conection.rollback();
        }
        
    }

    public EItemPedido consultar(int codigo) throws SQLException {
          
        String sql = "SELECT codigo, precoepoca, quantidade, codigo_produto, codigo_pedido"
                + "FROM itempedido"
                + "WHERE codigo = ?";
        
         Connection cnn = util.Conexao.getConexao();
         
          PreparedStatement ps = cnn.prepareStatement(sql);
         
           ps.setInt(1, codigo);
           
           ps.execute();
           
           ResultSet rs = ps.executeQuery();
        
        EItemPedido pedido = new EItemPedido();
        if (rs.next()) {
            pedido.setCodigo(rs.getInt("codigo"));
            pedido.setPrecoEpoca(rs.getDouble("precoepoca"));
            pedido.setQuantidade(rs.getInt("quantidade"));
            pedido.setProduto(new PProduto().consultar(rs.getInt("codigo")));
            pedido.setPedido(new PPedido().consultar(rs.getInt("codigo")));
        }
        
         rs.close();
           
             cnn.close();
         
        return pedido;
    }

    public void excluir(int codigo) throws SQLException {
        

        String sql = "DELETE FROM itempedido"
                + " WHERE codigo = ? ";
        
     
        Connection cnn = util.Conexao.getConexao();
        
      
        PreparedStatement ps = cnn.prepareStatement(sql);
        
        ps.setInt(1, codigo);
        
      
        ps.execute();

        cnn.close();
    
    }

    public List<EItemPedido> listar(EItemPedido pedido) throws SQLException {
   
   
                    //criar instruções sql para execultar no banco
        String sql = "SELECT * FROM itempedido"
                + " WHERE codigo = ?";
        
        //cria a conexão com o banco
        Connection cnn = util.Conexao.getConexao();
        //execulta a conexão
        PreparedStatement ps = cnn.prepareStatement(sql);
        
        ps.setInt(1, (int) pedido.getCodigo());
        
        //busca informações no banco e preenche o objeto
        ResultSet rs = ps.executeQuery();
        
        List<EItemPedido> lista = new ArrayList<>();
       
        while(rs.next()){
            
            EItemPedido ip = new EItemPedido();
            ip.setCodigo(rs.getInt("codigo"));
            ip.setPrecoEpoca(rs.getDouble("precoepoca"));
            ip.setQuantidade(rs.getInt("quantidade"));
            lista.add(ip);
        }
        //fecha o resultset
        rs.close();
        //fecha a conexão
        cnn.close();
        return lista;
       
    }

    void excluirPorPedido(int codigo, Connection conection) throws SQLException {
         
        try {
            //cria instrução sql 
            String sql = "DELETE FROM itempedido "
                    + " WHERE codigo = ? ";

            //execulta a conexão
            PreparedStatement ps = conection.prepareStatement(sql);

            ps.setDouble(1, codigo);            
            //execulta o objeto
            ps.execute();

            PItemPedido pitem = new PItemPedido();
            pitem.excluirPorPedido(codigo,conection);
            
            conection.commit();
        } catch (Exception e) {
            conection.rollback();
        }
        conection.close();
    }
        
    


}
