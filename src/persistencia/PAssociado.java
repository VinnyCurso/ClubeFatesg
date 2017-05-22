/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EAssociado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class PAssociado {

    public PAssociado() {
    }

    public void incluir(EAssociado associado) throws SQLException {

        //Cria a string com o sql para ser executado
        String sql = "INSERT INTO associado ( nome,"
                + "endereco, "
                + "codigo_tipoassociado) VALUES (?, ?, ?)";

        //Cria o objeto de conexão com o banco
        Connection cnn = util.Conexao.getConexao();

        //Cria o objeto para executar os comandos "contra" o banco
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores recebidos como parametro para a string SQL
        prd.setString(1, associado.getNome());
        prd.setString(2, associado.getEndereco());
        prd.setInt(3, associado.getTipoAssociado().getCodigo());

        //Executa o SQL no banco de dados
        prd.execute();

        //Cria o sql para recuperar o codigo gerado
        String sql2 = "SELECT currval('associado_codigo_seq') as codigo";

        //Crio o statement a partir da conexao
        Statement st = cnn.createStatement();

        //Crio o resultset a partir do sql
        ResultSet rs = st.executeQuery(sql2);

        if (rs.next()) {
            associado.setCodigo(rs.getInt("codigo"));
        }

        rs.close();
        cnn.close();

    }

    public void alterar(EAssociado parametro) throws SQLException {

        //Cria o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();

        String sql = "UPDATE associado "
                + "SET nome = ?, "
                + "endereco = ?, "
                + "codigo_tipoassociado = ?  "
                + " WHERE codigo = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getEndereco());
        prd.setInt(3, parametro.getTipoAssociado().getCodigo());
        prd.setInt(4, parametro.getCodigo());

        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {

        //Cria o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();

        String sql = "DELETE FROM associado WHERE codigo = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);

        prd.execute();
        cnn.close();
    }

    public EAssociado consultar(int parametro) throws SQLException {

        Connection cnn = util.Conexao.getConexao();
        String sql = "SELECT codigo, nome, endereco, "
                + " codigo_tipoassociado "
                + "FROM associado WHERE codigo = ?";
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();
        EAssociado retorno = new EAssociado();
        if (rs.next()) {
            retorno.setCodigo(rs.getInt("codigo"));
            retorno.setNome(rs.getString("nome"));
            retorno.setEndereco(rs.getString("endereco"));

//            //Desse jeito
//            PTipoAssociado ptipo = new PTipoAssociado();
//            int intCodigoTipo = rs.getInt("codigo_tipoassociado");
//            ETipoAssociado tipo = ptipo.consultar(intCodigoTipo);
//            retorno.setTipoAssociado(tipo);

            //Ou desse modelo
            retorno.setTipoAssociado(
                    new PTipoAssociado().consultar(rs.getInt("codigo_tipoassociado")));

        }
        rs.close();
        cnn.close();

        return retorno;
    }

    public List<EAssociado> listar(EAssociado associado) throws SQLException {
        List<EAssociado> lista = new ArrayList<>();

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT * "
                + "FROM associado "
                + " WHERE 1=1";

        if (associado.getNome() != null) {
            if (!associado.getNome().isEmpty()) {
                sql += " AND nome like ? ";
            }
        }

        if (associado.getEndereco() != null) {
            if (!associado.getEndereco().isEmpty()) {
                sql += " AND endereco like ? ";
            }
        }

        sql += " ORDER BY nome";

        PreparedStatement prd = cnn.prepareStatement(sql);

        if (associado.getNome() != null) {
            if (!associado.getNome().isEmpty()) {
                prd.setString(1, "%" + associado.getNome() + "%");
            }
        }

        if (associado.getEndereco()!= null) {
            if (!associado.getEndereco().isEmpty()) {
                prd.setString(1, "%" + associado.getEndereco() + "%");
            }
        }
        ResultSet rs = prd.executeQuery();

        while (rs.next()) {
            EAssociado retorno = new EAssociado();
            retorno.setCodigo(rs.getInt("codigo"));
            retorno.setNome(rs.getString("nome"));
            retorno.setEndereco(rs.getString("endereco"));
            lista.add(retorno);
        }
        rs.close();
        cnn.close();

        return lista;
    }

}
