package AcademiaGestaoWebApi.Models;

import java.util.List;

import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;

/**
 *
 * @author Gabriel
 */
public class Avaliacao {

    private int iD;

    private double massa;
    
    private double estatura;

    private double imc;

    private double pccg;

    private double pesoIdeal;
    
    private double pesoEmExcesso;
    
    private double massaMagra;
    
    private double massaDeGordura;

    private double peitoral;

    private double mediaAuxiliar;

    private double subEscapular;

    private double tricipital;

    private double biciptal;

    private double supraIliaca;

    private double abdominalDobra;

    private double coxa;

    private double panturrilha;

    private double torax;

    private double bracoDireito;

    private double bracoEsquerdo;

    private double antebracoDireito;

    private double antebracoEsquerdo;

    private double abdominalPerimetro;

    private double cintura;

    private double quadril;

    private double coxaDireita;

    private double coxaEsquerda;

    private double pernaDireita;

    private double pernaEsquerda;

    private List<PorcentagemDeGordura> porcentagemDeGordura;

    public int getID() {
        return this.iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public double getMassa() {
        return this.massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getEstatura() {
        return this.estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getImc() {
        return this.imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getPccg() {
        return this.pccg;
    }

    public void setPccg(double pccg) {
        this.pccg = pccg;
    }

    public double getPesoIdeal() {
        return this.pesoIdeal;
    }

    public void setPesoIdeal(double pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public double getPesoEmExcesso() {
        return this.pesoEmExcesso;
    }

    public void setPesoEmExcesso(double pesoEmExcesso) {
        this.pesoEmExcesso = pesoEmExcesso;
    }

    public double getMassaMagra() {
        return this.massaMagra;
    }

    public void setMassaMagra(double massaMagra) {
        this.massaMagra = massaMagra;
    }

    public double getMassaDeGordura() {
        return this.massaDeGordura;
    }

    public void setMassaDeGordura(double massaDeGordura) {
        this.massaDeGordura = massaDeGordura;
    }

    public double getPeitoral() {
        return this.peitoral;
    }

    public void setPeitoral(double peitoral) {
        this.peitoral = peitoral;
    }

    public double getMediaAuxiliar() {
        return this.mediaAuxiliar;
    }

    public void setMediaAuxiliar(double mediaAuxiliar) {
        this.mediaAuxiliar = mediaAuxiliar;
    }

    public double getSubEscapular() {
        return this.subEscapular;
    }

    public void setSubEscapular(double subEscapular) {
        this.subEscapular = subEscapular;
    }

    public double getTricipital() {
        return this.tricipital;
    }

    public void setTricipital(double tricipital) {
        this.tricipital = tricipital;
    }

    public double getBiciptal() {
        return this.biciptal;
    }

    public void setBiciptal(double biciptal) {
        this.biciptal = biciptal;
    }

    public double getSupraIliaca() {
        return this.supraIliaca;
    }

    public void setSupraIliaca(double supraIliaca) {
        this.supraIliaca = supraIliaca;
    }

    public double getAbdominalDobra() {
        return this.abdominalDobra;
    }

    public void setAbdominalDobra(double abdominalDobra) {
        this.abdominalDobra = abdominalDobra;
    }

    public double getCoxa() {
        return this.coxa;
    }

    public void setCoxa(double coxa) {
        this.coxa = coxa;
    }

    public double getPanturrilha() {
        return this.panturrilha;
    }

    public void setPanturrilha(double panturrilha) {
        this.panturrilha = panturrilha;
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

    public double getAbdominalPerimetro() {
        return this.abdominalPerimetro;
    }

    public void setAbdominalPerimetro(double abdominalPerimetro) {
        this.abdominalPerimetro = abdominalPerimetro;
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

    public List<PorcentagemDeGordura> getPorcentagemDeGordura() {
        return this.porcentagemDeGordura;
    }

    public void setPorcentagemDeGordura(List<PorcentagemDeGordura> porcentagemDeGordura) {
        this.porcentagemDeGordura = porcentagemDeGordura;
    }

    public static class Factory{

        public static Avaliacao create(AvaliacaoRequest avaliacaoRequest){
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setMassa(avaliacaoRequest.getMassa());
            avaliacao.setEstatura(avaliacaoRequest.getEstatura());
            avaliacao.setPeitoral(avaliacaoRequest.getPeitoral());
            avaliacao.setMediaAuxiliar(avaliacaoRequest.getMediaAuxiliar());
            avaliacao.setSubEscapular(avaliacaoRequest.getSubEscapular());
            avaliacao.setTricipital(avaliacaoRequest.getTricipital());
            avaliacao.setBiciptal(avaliacaoRequest.getBiciptal());
            avaliacao.setSupraIliaca(avaliacaoRequest.getSupraIliaca());
            avaliacao.setAbdominalDobra(avaliacaoRequest.getAbdominalDobra());
            avaliacao.setCoxa(avaliacaoRequest.getCoxa());
            avaliacao.setPanturrilha(avaliacaoRequest.getPanturrilha());
            avaliacao.setTorax(avaliacaoRequest.getTorax());
            avaliacao.setBracoDireito(avaliacaoRequest.getBracoDireito());
            avaliacao.setBracoEsquerdo(avaliacaoRequest.getBracoEsquerdo());
            avaliacao.setAntebracoDireito(avaliacaoRequest.getAntebracoDireito());
            avaliacao.setAntebracoEsquerdo(avaliacaoRequest.getAntebracoEsquerdo());
            avaliacao.setAbdominalPerimetro(avaliacaoRequest.getAbdominalPerimetro());
            avaliacao.setCintura(avaliacaoRequest.getCintura());
            avaliacao.setQuadril(avaliacaoRequest.getQuadril());
            avaliacao.setCoxaDireita(avaliacaoRequest.getCoxaDireita());
            avaliacao.setCoxaEsquerda(avaliacaoRequest.getCoxaEsquerda());
            avaliacao.setPernaDireita(avaliacaoRequest.getPernaDireita());
            avaliacao.setPernaEsquerda(avaliacaoRequest.getPernaEsquerda());

            return avaliacao;
        }

    }
}