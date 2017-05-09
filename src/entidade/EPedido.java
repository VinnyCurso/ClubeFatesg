/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Date;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class EPedido {
    
    private int codigo;
    private Double valorTotal;
    private Date dataPedido;
    
    private EAssociado associado;
    private List<EItemPedido> listaItem;

    public EPedido() {
    }

    public EPedido(int codigo, Double valorTotal, Date dataPedido, EAssociado associado,List<EItemPedido> listaItem) {
        this.codigo = codigo;
        this.valorTotal = valorTotal;
        this.dataPedido = dataPedido;
        this.associado = associado;
        this.listaItem = listaItem;
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

    public EAssociado getAssociado() {
        return associado;
    }

    public void setAssociado(EAssociado associado) {
        this.associado = associado;
    }

    public List<EItemPedido> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<EItemPedido> listaItem) {
        this.listaItem = listaItem;
    }
    
    
    
}
