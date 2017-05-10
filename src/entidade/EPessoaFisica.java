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
public class EPessoaFisica extends EAssociado{
    
    private String rg;
    private String cpf;
    private boolean dependente;
    private String senha;
    private boolean debitoEmConta;

    public EPessoaFisica() {
    }

    public EPessoaFisica(String rg, String cpf, boolean dependente, String senha, boolean debitoEmConta) {
        this.rg = rg;
        this.cpf = cpf;
        this.dependente = dependente;
        this.senha = senha;
        this.debitoEmConta = debitoEmConta;
    }


    public EPessoaFisica(String rg, String cpf, boolean dependente, String senha, boolean debitoEmConta, ETipoAssociado tipoAssociado) {
        super(tipoAssociado);
        this.rg = rg;
        this.cpf = cpf;
        this.dependente = dependente;
        this.senha = senha;
        this.debitoEmConta = debitoEmConta;
    }

    
    

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isDependente() {
        return dependente;
    }

    public void setDependente(boolean dependente) {
        this.dependente = dependente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isDebitoEmConta() {
        return debitoEmConta;
    }

    public void setDebitoEmConta(boolean debitoEmConta) {
        this.debitoEmConta = debitoEmConta;
    }
    
    
    
}
