package br.com.springboot.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Employee implements Serializable {
    @Id
    private String id;
    private String nome;
    private String registro;
    private String tipoSanguineo;

    public Employee() {
    }

    public Employee(String id, String nome, String registro, String tipoSanguineo) {
        this.id = id;
        this.nome = nome;
        this.registro = registro;
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
}
