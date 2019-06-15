package AcademiaGestaoWebApi.Models.RequestModels;

import AcademiaGestaoWebApi.Enums.SexoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AvaliacaoRequest {

    private String id;
    
    private String idAluno;

    private int idade;

    private SexoEnum sexo;

    private double massa;

    private double estatura;

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

    public String getIdAluno() {
        return this.idAluno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }        

    public void setIdAluno(String idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public SexoEnum getSexo() {
        return this.sexo;
    }

    public void setSexoEnum(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public void setSexoEnum(int sexo) {
        switch (sexo) {
            case 1:
                this.sexo = SexoEnum.MASCULINO;
                break;
            case 2:
                this.sexo = SexoEnum.FEMININO;
                break;
        }
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
