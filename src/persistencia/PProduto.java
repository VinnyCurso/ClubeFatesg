/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

/**
 *
 * @author vinicius caetano
 */
public class PProduto {

    public PProduto() {
    }

    public void incluir(EProduto produto) throws SQLException {

        String sql = "insert into produto (nome, precoVenda) values(?,?)";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prepared = cnn.prepareStatement(sql);

        prepared.setString(1, produto.getNome());
        prepared.setDouble(2, produto.getPrecoVenda());

        prepared.execute();

        String sql2 = "SELECT currval('produto_codigo_seq') as codigo";

        Statement st = cnn.createStatement();

        ResultSet result = st.executeQuery(sql2);

        if (result.next()) {
            produto.setCodigo(result.getInt("codigo"));

        }

        result.close();
        cnn.close();
    }

    public void alterar(EProduto parametro) throws SQLException {

        Connection conection = util.Conexao.getConexao();

        String sql = "uptade produto set nome=? precoVenda=? where codigo=?";

        PreparedStatement prepared = conection.prepareStatement(sql);

        prepared.setString(1, parametro.getNome());
        prepared.setDouble(2, parametro.getPrecoVenda());

        prepared.execute();
        conection.close();

    }

    public void excluir(int parametro) throws SQLException {

        Connection conection = util.Conexao.getConexao();

        String sql = "delete from produto where codigo=?";

        PreparedStatement prepared = conection.prepareStatement(sql);

        prepared.setInt(1, parametro);

        prepared.execute();
        conection.close();
    }

    public EProduto consultar(int paramentro) throws SQLException {

        Connection conection = util.Conexao.getConexao();

        String sql = "select codigo,nome,precoVenda from codigo=?";

        PreparedStatement prepared = conection.prepareStatement(sql);
        prepared.setInt(1, paramentro);

        ResultSet resul = prepared.executeQuery();

        EProduto retorno = new EProduto();

        if (resul.next()) {
            retorno.setCodigo(resul.getInt("codigo"));
            retorno.setNome(resul.getString("nome"));
            retorno.setPrecoVenda(resul.getDouble("precoVenda"));

        }
        resul.close();
        conection.close();

        return retorno;
    }

    public List<EProduto> listar(EProduto produto) throws SQLException {

        List<EProduto> lista = new ArrayList<>();

        Connection conection = util.Conexao.getConexao();

        String sql = "select * from produto where 1=1";

        if (produto.getNome() != null) {
            if (!produto.getNome().isEmpty()) {
                sql += "and nome like ?";
            }
        }

        if (produto.getPrecoVenda() != null) {
            if (!produto.getPrecoVenda().isInfinite()) {
                sql += " and precoVenda like ? ";
            }
        }

        sql = " order by nome";

        PreparedStatement prepared = conection.prepareStatement(sql);

        if (produto.getNome() != null) {
            if (!produto.getNome().isEmpty()) {
                prepared.setString(1, "%" + produto.getNome() + "%");
            }
        }

        if (produto.getPrecoVenda() != null) {
            if (!produto.getPrecoVenda().isInfinite()) {
//                prepared.setDouble(2, "%" + produto.getPrecoVenda() + "%");
            }

        }

        ResultSet resul = prepared.executeQuery();

        while (resul.next()) {
            EProduto retorno = new EProduto();
            retorno.setCodigo(resul.getInt("codigo"));
            retorno.setNome(resul.getString("nome"));
            retorno.setPrecoVenda(resul.getDouble("precoVenda"));
        }

        resul.close();
        conection.close();

        return lista;
    }

}
