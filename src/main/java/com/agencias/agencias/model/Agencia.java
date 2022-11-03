package com.agencias.agencias.model;

import javax.persistence.*;

@Entity
@Table(name = "Agencias")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String endereco;
    private String telefone;
    private String gerenteGeral;

    public Agencia() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGerenteGeral() {
        return gerenteGeral;
    }

    public void setGerenteGeral(String gerenteGeral) {
        this.gerenteGeral = gerenteGeral;
    }
}
