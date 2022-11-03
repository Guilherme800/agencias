package com.agencias.agencias.controller;

import com.agencias.agencias.model.Agencia;
import com.agencias.agencias.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencia")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @PostMapping
    public String criarAgencia (@RequestBody Agencia agencia) {

        if (agencia.getEndereco() == null || agencia.getEndereco().equals("")){
            return "Endereço obrigatório.";
        }
        if (agencia.getTelefone() == null || agencia.getTelefone().equals("")){
            return "Telefone obrigatório.";
        }
        if (agencia.getGerenteGeral() == null || agencia.getGerenteGeral().equals("")){
            return "Gerente Geral obrigatório.";
        }
        if (agenciaService.buscaAgenciaCodigo(agencia.getCodigo()) != null) {
            return "Agencia já cadastrada.";
        }

        agenciaService.cadastraAgencia(agencia);

        return "Agencia cadastrada com sucesso.";
    }

    @GetMapping
    public List<Agencia> agencias () {

        return agenciaService.listaAgencias();
    }

    @GetMapping("/endereco/{endereco}")
    public List<Agencia> buscaAgenciasPorEndereco (@PathVariable String endereco) {

        return agenciaService.buscaAgenciaendereco(endereco);}

    @GetMapping("/codigo/{codigo}")
    public Agencia buscaAgenciasPorCodigo (@PathVariable Integer codigo) {

        return agenciaService.buscaAgenciaCodigo(codigo);}

    @DeleteMapping("/{codigo}")
    public String excluirAgencia(@PathVariable Integer codigo) {
        boolean excluiu = agenciaService.excluirAgencia(codigo);
        if (excluiu) {
            return "Agencia excluída com sucesso!";
        }
        return "Agencia não encontrada.";
    }

    @PutMapping("/{codigo}")
    public String atualizarAgencia(@PathVariable Integer codigo, @RequestBody Agencia agencia) {
        boolean atualizou = agenciaService.atualizarAgencia(codigo, agencia);
        if (atualizou) {
            return "Agencia atualizada com sucesso!";
        }
        return "Agencia não encontrada.";
    }

    /*
    C - Create - @PostMapping *
    R - Read - @GetMapping *
    U - Update @PutMapping
    D - Delete @DeleteMapping
     */

    /*
    Salvar um objeto no banco de dados. *
    Listar todos os objetos. *
    Filtrar os objetos por algum campo da entidade. *
    Excluir um objeto.
    Atualizar os dados de um objeto.
    */

}
