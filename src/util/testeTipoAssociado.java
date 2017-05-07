/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.ETipoAssociado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.PTipoAssociado;

/**
 *
 * @author vinicius caetano
 */
public class testeTipoAssociado {
    
    public static void main(String[] args) {
        
//        System.out.println("Testando a inclusao do tipo associado");
//
//        ETipoAssociado tipoAssociado = new ETipoAssociado();
//        tipoAssociado.setDescricao("Sócio Titular");
//        tipoAssociado.setValorMensalidade(100.0);
//
//        PTipoAssociado persistencia = new PTipoAssociado();
//        try {
//            persistencia.incluir(tipoAssociado);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        if (tipoAssociado.getCodigo() != 0) {
//            System.out.println("Inclusao efetuada com sucesso!");
//        } else {
//            System.out.println("Aconteceu algum boró");
//        }
        
        
//        System.out.println("Testando a alteração");
//        
//        ETipoAssociado tipo = new ETipoAssociado();
//        PTipoAssociado persistencia = new PTipoAssociado();
//        
//        tipo.setCodigo(2);
//        tipo.setDescricao("Sócio Dependente");
//        tipo.setValorMensalidade(75.00);
//        
//        try {
//            persistencia.alterar(tipo);
//        } catch (SQLException ex) {
//            Logger.getLogger(testeTipoAssociado.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        System.out.println("Tipo alterado com sucesso!");
        
        
//        System.out.println("Testando a exclusão");
//        PTipoAssociado persistencia = new PTipoAssociado();
//        try {
//            persistencia.excluir(3);
//        } catch (SQLException ex) {
//            Logger.getLogger(testeTipoAssociado.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Excluido com sucesso");
//        
//        System.out.println("Testando o consultar");
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.print("Digite o código: ");
//        int codigo = scanner.nextInt();
//        
//        PTipoAssociado persistencia = new PTipoAssociado();
//        ETipoAssociado tipo = new ETipoAssociado();
//        try {
//            tipo = persistencia.consultar(codigo);
//        } catch (SQLException ex) {
//            Logger.getLogger(testeTipoAssociado.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        if(tipo.getCodigo() != 0){
//            System.out.println("Código.............: " + tipo.getCodigo());
//            System.out.println("Descrição..........: " + tipo.getDescricao());
//            System.out.println("Valor Mensalidade..: " + tipo.getValorMensalidade());
//        }else{
//            System.out.println("Tipo Associado não encontrado!");
//        }
//        
        System.out.println("Testando o listar");
        
        PTipoAssociado persistencia = new PTipoAssociado();
        List<ETipoAssociado> lista = new ArrayList<>();
        try {
            lista = persistencia.listar();
        } catch (SQLException ex) {
            Logger.getLogger(testeTipoAssociado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (ETipoAssociado tipo : lista) {
            System.out.println("Código.............: " + tipo.getCodigo());
            System.out.println("Descrição..........: " + tipo.getDescricao());
            System.out.println("Valor Mensalidade..: " + tipo.getValorMensalidade());
            System.out.println();
        }    
            
            System.out.println("Listagem finalizada!");
//        
//        
    }
    
}
