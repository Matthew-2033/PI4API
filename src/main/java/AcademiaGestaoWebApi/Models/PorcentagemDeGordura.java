package AcademiaGestaoWebApi.Models;

import java.util.UUID;

import AcademiaGestaoWebApi.Enums.AutorEnum;

public class PorcentagemDeGordura{

    private UUID idAvaliacao;
    private AutorEnum autor;
    private double porcentagemDeGordura;

    public PorcentagemDeGordura(AutorEnum autor, double porcentagemDeGordura){
        this.autor = autor;
        this.porcentagemDeGordura = porcentagemDeGordura;
    }

    public UUID getIdAvaliacao() {
        return this.idAvaliacao;
    }

    public void setIdAvaliacao(UUID idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }    

    public AutorEnum getAutor(){
        return this.autor;
    }

    public void setAutor(AutorEnum autor){
        this.autor = autor;
    }

    public double getPorcentagemDeGordura() {
        return this.porcentagemDeGordura;
    }

    public void setPorcentagemDeGordura(double porcentagemDeGordura) {
        this.porcentagemDeGordura = porcentagemDeGordura;
    }
}