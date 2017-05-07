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
public class EItemPedido {
    
    private long codigo;
    private Double precoEpoca;
    private int quantidade;

    public EItemPedido() {
    }

    public EItemPedido(long codigo, Double precoEpoca, int quantidade) {
        this.codigo = codigo;
        this.precoEpoca = precoEpoca;
        this.quantidade = quantidade;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Double getPrecoEpoca() {
        return precoEpoca;
    }

    public void setPrecoEpoca(Double precoEpoca) {
        this.precoEpoca = precoEpoca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
   
}
