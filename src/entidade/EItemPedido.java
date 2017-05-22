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
    
    private EPedido pedido;
    private EProduto produto;

    public EItemPedido() {
        this.produto = produto;
        this.pedido = pedido;
    }
    
 

    public EItemPedido(long codigo, Double precoEpoca, int quantidade, EPedido pedido) {
        this.codigo = codigo;
        this.precoEpoca = precoEpoca;
        this.quantidade = quantidade;
        this.pedido = pedido;
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

    public EPedido getPedido() {
        return pedido;
    }

    public void setPedido(EPedido pedido) {
        this.pedido = pedido;
    }
    
      public EProduto getProduto() {
        return produto;
    }

    public void setProduto(EProduto produto) {
        this.produto = produto;
    }

}
