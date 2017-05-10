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
public class EMovimentacaoConta {
    
    private Date dataHoraMovimentacao;
    private float valorMovimentacao;

    public EMovimentacaoConta() {
    }

    public EMovimentacaoConta(Date dataHoraMovimentacao, float valorMovimentacao) {
        this.dataHoraMovimentacao = dataHoraMovimentacao;
        this.valorMovimentacao = valorMovimentacao;
    }

    public Date getDataHoraMovimentacao() {
        return dataHoraMovimentacao;
    }

    public void setDataHoraMovimentacao(Date dataHoraMovimentacao) {
        this.dataHoraMovimentacao = dataHoraMovimentacao;
    }

    public float getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(float valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }
    
    
    
}
