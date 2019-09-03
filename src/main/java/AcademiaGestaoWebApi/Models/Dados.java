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
    private int nao_avaliado;    
    private List<MediaPorcentagemGordura> mediaPorcentagem;
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public int getFeminino() {
        return feminino;
    }

    public void setFeminino(int feminino) {
        this.feminino = feminino;
    }

    public int getInativos() {
        return inativos;
    }

    public void setInativos(int inativos) {
        this.inativos = inativos;
    }

    public int getMasculino() {
        return masculino;
    }

    public void setMasculino(int masculino) {
        this.masculino = masculino;
    }

    public double getNao_avaliado() {
        return nao_avaliado;
    }

    public void setNao_avaliado(int nao_avaliado) {
        this.nao_avaliado = nao_avaliado;
    }

    public List<MediaPorcentagemGordura> getMediaPorcentagem() {
        return mediaPorcentagem;
    }

    public void setMediaPorcentagem(List<MediaPorcentagemGordura> mediaPorcentagem) {
        this.mediaPorcentagem = mediaPorcentagem;
    }       
}
