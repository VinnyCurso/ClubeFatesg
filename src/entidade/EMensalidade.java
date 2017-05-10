/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Date;

/**
 *
 * @author vinicius caetano
 */
public class EMensalidade {
    
    private String referencia;
    private Date dataVencimento;
    private float valorMensalidade;
    private Date dataPagamento;
    private float valorPagamento;

    public EMensalidade() {
    }

    public EMensalidade(String referencia, Date dataVencimento, float valorMensalidade, Date dataPagamento, float valorPagamento) {
        this.referencia = referencia;
        this.dataVencimento = dataVencimento;
        this.valorMensalidade = valorMensalidade;
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public float getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(float valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(float valorPagamento) {
        this.valorPagamento = valorPagamento;
    }
    
    
    
    
}
