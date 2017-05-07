/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.ETipoAssociado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

/**
 *
 * @author vinicius caetano
 */
public class PTipoAssociado {

    public void incluir(ETipoAssociado parametro) throws SQLException {

        //Cria a instrução SQL que será usada para inserir as 
        //informações no banco de dados
        String sql = "INSERT INTO tipoassociado(descricao, "
                + "valormensalidade) "
                + "values(?,?)";

        //Cria o objeto para conexão com o banco de dados
        Connection cnn = util.Conexao.getConexao();

        //Cria o objeto para a execução das instruções no banco de dados
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Substituo as variáveis criadas na instrução SQL
        //pelos valores recebidos como parâmetro
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValorMensalidade());

        //Executa o comando no banco de dados
        prd.execute();

        //Cria a instrução SQL para recuperar o valor da sequence
        String sql2 = "SELECT currval('tipoassociado_codigo_seq') as codigo";

        //Cria o objeto para recuperação de informações do banco
        Statement stm = cnn.createStatement();

        //Executa o comando SQL no banco de dados
        //retornando o resultado para o ResultSet
        ResultSet rst = stm.executeQuery(sql2);

        //Verifica se existe algo dentro do ResultSet
        if (rst.next()) {
            parametro.setCodigo(rst.getInt("codigo"));
        }

        //Fecha o resultset
        rst.close();

        //fecha a conexão
        cnn.close();

    }

    public void alterar(ETipoAssociado parametro) throws SQLException {

        String sql = "UPDATE tipoassociado SET descricao = ?, "
                + "valormensalidade = ? "
                + " WHERE codigo = ?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores do prepared (?) com base no parametro recebido
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValorMensalidade());
        prd.setInt(3, parametro.getCodigo());

        prd.execute();

        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {
        String sql = "DELETE FROM tipoassociado WHERE codigo = ?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        prd.execute();

        cnn.close();

    }

    public ETipoAssociado consultar(int codigo) throws SQLException {

        String sql = "SELECT * FROM tipoassociado WHERE codigo = ?";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);

        ResultSet rs = prd.executeQuery();

        ETipoAssociado objeto = new ETipoAssociado();
        if (rs.next()) {
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDescricao(rs.getString("descricao"));
            objeto.setValorMensalidade(rs.getDouble("valormensalidade"));
        }

        rs.close();
        cnn.close();
        return objeto;
    }

    public List<ETipoAssociado> listar() throws SQLException {

        String sql = "SELECT * FROM tipoassociado ORDER BY codigo";

        Connection cnn = Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        List<ETipoAssociado> lista = new ArrayList<ETipoAssociado>();
        while (rs.next()) {
            ETipoAssociado objeto = new ETipoAssociado();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDescricao(rs.getString("descricao"));
            objeto.setValorMensalidade(rs.getDouble("valormensalidade"));
            lista.add(objeto);
        }
        rs.close();
        cnn.close();
        return lista;
    }

}
