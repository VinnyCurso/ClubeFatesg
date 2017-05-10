/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author vinicius caetano
 */
public class EContaFinanceira {
    
    private String banco;
    private String agencia;
    private String conta;

    public EContaFinanceira() {
    }

    public EContaFinanceira(String banco, String agencia, String conta) {
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
    
    
    
}
