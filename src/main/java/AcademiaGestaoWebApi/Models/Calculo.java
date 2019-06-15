package AcademiaGestaoWebApi.Models;

import java.util.UUID;

public class Calculo {

    private UUID id;

    private String nome;


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}