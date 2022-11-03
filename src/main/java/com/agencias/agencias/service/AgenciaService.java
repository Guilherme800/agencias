package com.agencias.agencias.service;

import com.agencias.agencias.model.Agencia;
import com.agencias.agencias.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public void cadastraAgencia (Agencia agencia) {
        agenciaRepository.save(agencia);
    }

    public List<Agencia> listaAgencias (){
        return agenciaRepository.findAll();
    }

    public Agencia buscaAgenciaCodigo (Integer codigo) {
        return agenciaRepository.findByCodigo(codigo);
    }

    public List<Agencia> buscaAgenciaendereco (String endereco) {
        return agenciaRepository.findByEndereco(endereco);
    }

    public boolean excluirAgencia(Integer codigo) {
        Agencia agencia = agenciaRepository.findByCodigo(codigo);
        if (agencia != null) {
            agenciaRepository.delete(agencia);
            return true;
        }
        return false;
    }

    public boolean atualizarAgencia(Integer codigo, Agencia agencia) {
        Agencia agenciadb = agenciaRepository.findByCodigo(codigo);
        if (agencia != null) {
            if (agencia.getEndereco() != null){
                agenciadb.setEndereco(agencia.getEndereco());}
            if (agencia.getTelefone() != null){
                agenciadb.setTelefone(agencia.getTelefone());}
            if (agencia.getGerenteGeral() != null){
                agenciadb.setGerenteGeral(agencia.getGerenteGeral());}
            agenciaRepository.save(agenciadb);
            return true;
        }
        return false;
    }
}
