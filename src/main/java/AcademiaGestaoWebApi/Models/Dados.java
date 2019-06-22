package AcademiaGestaoWebApi.Models;

import java.util.List;

/**
 *
 * @author matheusvieira
 */
public class Dados {

    private int qtdMasculino;
    private int qtdFeminino;
    private int qtdAtivados;
    private int qtdInativados;
    private double porcentagemDeAvaliados;
    private List<MediaImc> mediaImc;

    public int getQtdMasculino() {
        return qtdMasculino;
    }

    public void setQtdMasculino(int qtdMasculino) {
        this.qtdMasculino = qtdMasculino;
    }

    public int getQtdFeminino() {
        return qtdFeminino;
    }

    public void setQtdFeminino(int qtdFeminino) {
        this.qtdFeminino = qtdFeminino;
    }

    public int getQtdAtivados() {
        return qtdAtivados;
    }

    public void setQtdAtivados(int qtdAtivados) {
        this.qtdAtivados = qtdAtivados;
    }

    public int getQtdInativados() {
        return qtdInativados;
    }

    public void setQtdInativados(int qtdInativados) {
        this.qtdInativados = qtdInativados;
    }

    public double getPorcentagemDeAvaliados() {
        return porcentagemDeAvaliados;
    }

    public void setPorcentagemDeAvaliados(double porcentagemDeAvaliados) {
        this.porcentagemDeAvaliados = porcentagemDeAvaliados;
    }

    public List<MediaImc> getMediaImc() {
        return mediaImc;
    }

    public void setMediaImc(List<MediaImc> mediaImc) {
        this.mediaImc = mediaImc;
    }

}
