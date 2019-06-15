package AcademiaGestaoWebApi.Models;

import java.util.UUID;

/**
 *
 * @author Gabriel
 */
public class AvaliacaoDobras {

    private UUID id;

    private UUID idAvaliacao;

    private double peitoral;

    private double mediaAuxiliar;

    private double subEscapular;

    private double tricipital;

    private double biciptal;

    private double supraIliaca;

    private double abdominalDobra;

    private double coxa;

    private double panturrilha;


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
}