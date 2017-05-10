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
public class EMovimentacaoEstoque {
    
    private Date dataHoraMovimentacao;
    private float valorMovimentacao;
    private float quantidadeMovimentacao;

    public EMovimentacaoEstoque() {
    }

    public EMovimentacaoEstoque(Date dataHoraMovimentacao, float valorMovimentacao, float quantidadeMovimentacao) {
        this.dataHoraMovimentacao = dataHoraMovimentacao;
        this.valorMovimentacao = valorMovimentacao;
        this.quantidadeMovimentacao = quantidadeMovimentacao;
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

    public float getQuantidadeMovimentacao() {
        return quantidadeMovimentacao;
    }

    public void setQuantidadeMovimentacao(float quantidadeMovimentacao) {
        this.quantidadeMovimentacao = quantidadeMovimentacao;
    }
    
}
