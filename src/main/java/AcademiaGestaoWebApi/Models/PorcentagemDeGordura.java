package AcademiaGestaoWebApi.Models;

public class PorcentagemDeGordura{

    private String autor;
    private double porcentagemDeGordura;

    public PorcentagemDeGordura(String autor, double porcentagemDeGordura){
        this.autor = autor;
        this.porcentagemDeGordura = porcentagemDeGordura;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public double getPorcentagemDeGordura() {
        return this.porcentagemDeGordura;
    }

    public void setPorcentagemDeGordura(double porcentagemDeGordura) {
        this.porcentagemDeGordura = porcentagemDeGordura;
    }
}