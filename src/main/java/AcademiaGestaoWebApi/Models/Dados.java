package AcademiaGestaoWebApi.Models;

import java.util.List;

/**
 *
 * @author matheusvieira
 */
public class Dados {

    private int total;
    private int ativo;
    private int feminino;
    private int inativos;
    private int masculino;
    private double nao_avaliado;    

    public int getQtdMasculino() {
        return masculino;
    }

    public void setQtdMasculino(int qtdMasculino) {
        this.masculino = qtdMasculino;
    }

    public int getQtdFeminino() {
        return feminino;
    }

    public void setQtdFeminino(int qtdFeminino) {
        this.feminino = qtdFeminino;
    }

    public int getQtdAtivados() {
        return ativo;
    }

    public void setQtdAtivados(int qtdAtivados) {
        this.ativo = qtdAtivados;
    }

    public int getQtdInativados() {
        return inativos;
    }

    public void setQtdInativados(int qtdInativados) {
        this.inativos = qtdInativados;
    }

    public double getPorcentagemDeAvaliados() {
        return nao_avaliado;
    }

    public void setPorcentagemDeAvaliados(double porcentagemDeAvaliados) {
        this.nao_avaliado = porcentagemDeAvaliados;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    } 
}
