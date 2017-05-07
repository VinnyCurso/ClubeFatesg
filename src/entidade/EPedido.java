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
public class EPedido {
    
    private int codigo;
    private Double valorTotal;
    private Date dataPedido;

    public EPedido() {
    }

    public EPedido(int codigo, Double valorTotal, Date dataPedido) {
        this.codigo = codigo;
        this.valorTotal = valorTotal;
        this.dataPedido = dataPedido;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
    
}
