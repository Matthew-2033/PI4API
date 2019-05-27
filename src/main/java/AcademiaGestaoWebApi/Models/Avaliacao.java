package AcademiaGestaoWebApi.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;

/**
 *
 * @author Gabriel
 */
public class Avaliacao {

    private UUID iD;

    private UUID idAluno;

    private double massa;
    
    private double estatura;

    private double imc;

    private double pccg;

    private double pesoIdeal;
    
    private double pesoEmExcesso;
    
    private double massaMagra;
    
    private double massaDeGordura;

    private AvaliacaoDobras dobrasAvaliacao;

    private AvaliacaoPerimetros perimetrosAvaliacao;

    private List<PorcentagemDeGordura> porcentagemDeGordura;

    public UUID getID() {
        return this.iD;
    }

    public void setID(UUID id) {        
        this.iD = id;

        if(dobrasAvaliacao != null){
            dobrasAvaliacao.setIdAvaliacao(id);
        }

        if(perimetrosAvaliacao != null){
            perimetrosAvaliacao.setIdAvaliacao(id);
        }

        if(porcentagemDeGordura == null){
            return;
        }

        List<PorcentagemDeGordura> porcentagemDeGorduras = new ArrayList<>();
        for (PorcentagemDeGordura item : porcentagemDeGordura) {
            item.setIdAvaliacao(id);
            porcentagemDeGorduras.add(item);
        }      
        
        porcentagemDeGordura = porcentagemDeGorduras;
    }

    public UUID getIdAluno() {
        return this.idAluno;
    }

    public void setIdAluno(UUID idAluno) {
        this.idAluno = idAluno;
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

    public List<PorcentagemDeGordura> getPorcentagemDeGordura() {
        return this.porcentagemDeGordura;
    }

    public void setPorcentagemDeGordura(List<PorcentagemDeGordura> porcentagemDeGordura) {
        this.porcentagemDeGordura = porcentagemDeGordura;
    }

    public AvaliacaoDobras getDobrasAvaliacao() {
        return this.dobrasAvaliacao;
    }

    public void setDobrasAvaliacao(AvaliacaoDobras dobrasAvaliacao) {
        this.dobrasAvaliacao = dobrasAvaliacao;
    }

    public AvaliacaoPerimetros getPerimetrosAvaliacao() {
        return this.perimetrosAvaliacao;
    }

    public void setPerimetrosAvaliacao(AvaliacaoPerimetros perimetrosAvaliacao) {
        this.perimetrosAvaliacao = perimetrosAvaliacao;
    }

    public static class Factory{

        public static Avaliacao create(AvaliacaoRequest avaliacaoRequest){
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setIdAluno(UUID.fromString(avaliacaoRequest.getIdAluno()));
            avaliacao.setMassa(avaliacaoRequest.getMassa());
            avaliacao.setEstatura(avaliacaoRequest.getEstatura());
            
            AvaliacaoDobras dobrasAvaliacao = new AvaliacaoDobras();
            dobrasAvaliacao.setPeitoral(avaliacaoRequest.getPeitoral());
            dobrasAvaliacao.setMediaAuxiliar(avaliacaoRequest.getMediaAuxiliar());
            dobrasAvaliacao.setSubEscapular(avaliacaoRequest.getSubEscapular());
            dobrasAvaliacao.setTricipital(avaliacaoRequest.getTricipital());
            dobrasAvaliacao.setBiciptal(avaliacaoRequest.getBiciptal());
            dobrasAvaliacao.setSupraIliaca(avaliacaoRequest.getSupraIliaca());
            dobrasAvaliacao.setAbdominalDobra(avaliacaoRequest.getAbdominalDobra());
            dobrasAvaliacao.setCoxa(avaliacaoRequest.getCoxa());
            dobrasAvaliacao.setPanturrilha(avaliacaoRequest.getPanturrilha());

            AvaliacaoPerimetros perimetrosAvaliacao = new AvaliacaoPerimetros();
            perimetrosAvaliacao.setTorax(avaliacaoRequest.getTorax());
            perimetrosAvaliacao.setBracoDireito(avaliacaoRequest.getBracoDireito());
            perimetrosAvaliacao.setBracoEsquerdo(avaliacaoRequest.getBracoEsquerdo());
            perimetrosAvaliacao.setAntebracoDireito(avaliacaoRequest.getAntebracoDireito());
            perimetrosAvaliacao.setAntebracoEsquerdo(avaliacaoRequest.getAntebracoEsquerdo());
            perimetrosAvaliacao.setAbdominal(avaliacaoRequest.getAbdominalPerimetro());
            perimetrosAvaliacao.setCintura(avaliacaoRequest.getCintura());
            perimetrosAvaliacao.setQuadril(avaliacaoRequest.getQuadril());
            perimetrosAvaliacao.setCoxaDireita(avaliacaoRequest.getCoxaDireita());
            perimetrosAvaliacao.setCoxaEsquerda(avaliacaoRequest.getCoxaEsquerda());
            perimetrosAvaliacao.setPernaDireita(avaliacaoRequest.getPernaDireita());
            perimetrosAvaliacao.setPernaEsquerda(avaliacaoRequest.getPernaEsquerda());

            avaliacao.setDobrasAvaliacao(dobrasAvaliacao);
            avaliacao.setPerimetrosAvaliacao(perimetrosAvaliacao);
            return avaliacao;
        }

    }
}