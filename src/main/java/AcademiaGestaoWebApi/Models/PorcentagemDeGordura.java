package AcademiaGestaoWebApi.Models;

import AcademiaGestaoWebApi.Enums.AutorEnum;

public class PorcentagemDeGordura{

    private AutorEnum autor;
    private double porcentagemDeGordura;

    public PorcentagemDeGordura(AutorEnum autor, double porcentagemDeGordura){
        this.autor = autor;
        this.porcentagemDeGordura = porcentagemDeGordura;
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