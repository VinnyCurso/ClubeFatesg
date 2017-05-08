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

/**
 *
 * @author vinicius caetano
 */
public class PProduto {
    
    public PProduto(){}
    
    public void incluir (EProduto produto) throws SQLException{
        
        String sql = "insert into produto (nome, precoVenda) values(?,?)";
        
        Connection cnn = util.Conexao.getConexao();
        
        PreparedStatement prepared = cnn.prepareStatement(sql);
        
         prepared.setString(1, produto.getNome());
        prepared.setDouble(2,produto.getPrecoVenda());
        
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
}
