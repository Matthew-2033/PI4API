package AcademiaGestaoWebApi.Models.Treinos;

import AcademiaGestaoWebApi.Enums.SexoEnum;
import java.time.LocalDate;
import java.util.UUID;

public class Treino {
    
    private UUID id;
    private UUID idNivel;
    private String nome;
    private LocalDate dataCriacao;
    private SexoEnum genero;
    private boolean ativo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(UUID idNivel) {
        this.idNivel = idNivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public SexoEnum getGenero() {
        return genero;
    }

    public void setGenero(SexoEnum genero) {
        this.genero = genero;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }           
}
