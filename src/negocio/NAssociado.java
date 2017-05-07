/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EAssociado;
import java.sql.SQLException;
import java.util.List;
import persistencia.PAssociado;

/**
 *
 * @author vinicius caetano
 */
public class NAssociado {

    PAssociado pAssociado;

    public NAssociado() {
        pAssociado = new PAssociado();
    }

    public void salvar(EAssociado associado) throws SQLException, Exception {

        if (validar(associado)) {
            if (associado.getCodigo() == 0) {
                pAssociado.incluir(associado);
            } else {
                pAssociado.alterar(associado);
            }
        }
    }

    public void excluir(int codigo) throws SQLException {
        pAssociado.excluir(codigo);
    }

    public EAssociado consultar(int codigo) throws SQLException {
        return pAssociado.consultar(codigo);
    }

    public List<EAssociado> listar(EAssociado associado) throws SQLException {
        return pAssociado.listar(associado);
    }

    private boolean validar(EAssociado associado) throws Exception {
        if (associado.getNome() == null) {
            throw new Exception("É necessário preencher o campo nome.");
        }

        if (associado.getNome().isEmpty()) {
            throw new Exception("É necessário preencher o campo nome.");
        }

        if (associado.getEndereco() == null) {
            throw new Exception("É necessário preencher o campo endereço.");
        }

        if (associado.getEndereco().isEmpty()) {
            throw new Exception("É necessário preencher o campo endereço.");
        }

        if (associado.getEndereco().isEmpty()) {
            throw new Exception("É necessário preencher o campo endereço.");
        }

        if (associado.getTipoAssociado().getCodigo() == 0) {
            throw new Exception("É necessário preencher o campo Tipo Associado.");
        }
        return true;
    }

}
