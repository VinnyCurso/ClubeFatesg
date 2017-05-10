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
public class EContaClube {
    
    private float saldo;
    private float limiteCredito;

    public EContaClube() {
    }

    public EContaClube(float saldo, float limiteCredito) {
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    
    public void verificarQuitacao(){
        
    }
    
}
