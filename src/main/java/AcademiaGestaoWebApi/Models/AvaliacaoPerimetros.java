package AcademiaGestaoWebApi.Models;

import java.util.UUID;

public class AvaliacaoPerimetros {

    private UUID id;

    private UUID idAvaliacao;
    
    private double torax;

    private double bracoDireito;

    private double bracoEsquerdo;

    private double antebracoDireito;

    private double antebracoEsquerdo;

    private double abdominal;

    private double cintura;

    private double quadril;

    private double coxaDireita;

    private double coxaEsquerda;

    private double pernaDireita;

    private double pernaEsquerda;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdAvaliacao() {
        return this.idAvaliacao;
    }

    public void setIdAvaliacao(UUID idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public double getTorax() {
        return this.torax;
    }

    public void setTorax(double torax) {
        this.torax = torax;
    }

    public double getBracoDireito() {
        return this.bracoDireito;
    }

    public void setBracoDireito(double bracoDireito) {
        this.bracoDireito = bracoDireito;
    }

    public double getBracoEsquerdo() {
        return this.bracoEsquerdo;
    }

    public void setBracoEsquerdo(double bracoEsquerdo) {
        this.bracoEsquerdo = bracoEsquerdo;
    }

    public double getAntebracoDireito() {
        return this.antebracoDireito;
    }

    public void setAntebracoDireito(double antebracoDireito) {
        this.antebracoDireito = antebracoDireito;
    }

    public double getAntebracoEsquerdo() {
        return this.antebracoEsquerdo;
    }

    public void setAntebracoEsquerdo(double antebracoEsquerdo) {
        this.antebracoEsquerdo = antebracoEsquerdo;
    }

    public double getAbdominal() {
        return this.abdominal;
    }

    public void setAbdominal(double abdominalPerimetro) {
        this.abdominal = abdominalPerimetro;
    }

    public double getCintura() {
        return this.cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return this.quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getCoxaDireita() {
        return this.coxaDireita;
    }

    public void setCoxaDireita(double coxaDireita) {
        this.coxaDireita = coxaDireita;
    }

    public double getCoxaEsquerda() {
        return this.coxaEsquerda;
    }

    public void setCoxaEsquerda(double coxaEsquerda) {
        this.coxaEsquerda = coxaEsquerda;
    }

    public double getPernaDireita() {
        return this.pernaDireita;
    }

    public void setPernaDireita(double pernaDireita) {
        this.pernaDireita = pernaDireita;
    }

    public double getPernaEsquerda() {
        return this.pernaEsquerda;
    }

    public void setPernaEsquerda(double pernaEsquerda) {
        this.pernaEsquerda = pernaEsquerda;
    }
}