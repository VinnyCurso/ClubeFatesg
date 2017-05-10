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
public class EMovimentacao {
    
    private Date dataHoraEntrada;
    private Date dataHoraSaida;

    public EMovimentacao() {
    }

    public EMovimentacao(Date dataHoraEntrada, Date dataHoraSaida) {
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
    }

    public Date getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(Date dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public Date getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(Date dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }
    
    
    public void registarMovimentacao(int codigo, String senha){
        
    }
    
    public void registarEntrada(){
        
    }
    
    public void registarSaida(){
    
    }
    
    public void verificarEntrada(){
        
    }
}
