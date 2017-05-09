/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EItemPedido;
import entidade.EPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class PPedido {

    public PPedido() {
    }

    public void incluir(EPedido pedido) throws SQLException {

        Connection conection = util.Conexao.getConexao();
        conection.setAutoCommit(false);

        try {
            String sql = "insert into pedido (datapedido, valortotal, codigo_associado) values (now(),?,?)";

            PreparedStatement prepared = conection.prepareStatement(sql);

            prepared.setDouble(1, pedido.getValorTotal());
            prepared.setInt(2, pedido.getAssociado().getCodigo());

            prepared.execute();

            String sql2 = "select currval ('pedido_codigo_seq') as codigo";

            Statement st = conection.createStatement();

            ResultSet resul = st.executeQuery(sql2);

            if (resul.next()) {
                pedido.setCodigo(resul.getInt("codigo"));

            }
            resul.close();

            PItemPedido pItem = new PItemPedido();

            for (EItemPedido item : pedido.getListaItem()) {
                pItem.incluir(item, conection);

            }
            conection.commit();
        } catch (Exception e) {
            conection.rollback();
        }
    }

    public void alterar(EPedido pedido) throws SQLException {

        Connection conection = util.Conexao.getConexao();
        conection.setAutoCommit(false);

        try {
            String sql = " update pedido set datapedido = now(),valortotal=? where codigo=?";

            PreparedStatement prepared = conection.prepareStatement(sql);

            prepared.setDouble(1, pedido.getValorTotal());
            prepared.setInt(2, pedido.getCodigo());
            prepared.execute();

            PItemPedido pItem = new PItemPedido();
            pItem.excluirPorPedido(pedido.getCodigo(), conection);

            for (EItemPedido item : pedido.getListaItem()) {

                item.getPedido().setCodigo(pedido.getCodigo());
                pItem.incluir(item, conection);
            }

        } catch (Exception e) {
            conection.rollback();
        }

    }

    public EPedido consultar(int paramentro) {
        return null;
    }

    public void excluir(EPedido pedido) throws SQLException {

        Connection conection = util.Conexao.getConexao();
        conection.setAutoCommit(false);

        try {
            String sql = " update pedido set datapedido = now(),valortotal=? where codigo=?";

            PreparedStatement prepared = conection.prepareStatement(sql);

            prepared.setInt(1, pedido.getCodigo());
            prepared.execute();

            PItemPedido pItem = new PItemPedido();
            pItem.excluirPorPedido(pedido.getCodigo(), conection);

            for (EItemPedido item : pedido.getListaItem()) {

                item.getPedido().setCodigo(pedido.getCodigo());
            }

        } catch (Exception e) {
            conection.rollback();
        }
    }

    public List<EPedido> listar(EPedido pedido) {
        return null;
    }
}
