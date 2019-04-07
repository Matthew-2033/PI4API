package AcademiaGestaoWebApi.Models;

public class IndiceDeGordura{

    private int id;

    private Calculo caluculo;

    private double porcentagemDeGordura;

    private double densidadeDeGordura;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calculo getCaluculo() {
        return this.caluculo;
    }

    public void setCaluculo(Calculo caluculo) {
        this.caluculo = caluculo;
    }

    public double getPorcentagemDeGordura() {
        return this.porcentagemDeGordura;
    }

    public void setPorcentagemDeGordura(double porcentagemDeGordura) {
        this.porcentagemDeGordura = porcentagemDeGordura;
    }

    public double getDensidadeDeGordura() {
        return this.densidadeDeGordura;
    }

    public void setDensidadeDeGordura(double densidadeDeGordura) {
        this.densidadeDeGordura = densidadeDeGordura;
    }
}