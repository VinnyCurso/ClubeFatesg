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
public class EPessoaJuridica extends EAssociado{
    
    private String cnpj;
    private String razaoSocial;
    private String IE;

    public EPessoaJuridica() {
    }

    public EPessoaJuridica(String cnpj, String razaoSocial, String IE) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.IE = IE;
    }

    public EPessoaJuridica(String cnpj, String razaoSocial, String IE, ETipoAssociado tipoAssociado) {
        super(tipoAssociado);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.IE = IE;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }
    
    
    
}
