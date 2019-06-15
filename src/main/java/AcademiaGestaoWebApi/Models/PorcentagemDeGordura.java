package AcademiaGestaoWebApi.Models;

import java.util.UUID;

import AcademiaGestaoWebApi.Enums.AutorEnum;

public class PorcentagemDeGordura {

    private UUID idAvaliacao;
    private AutorEnum autor;
    private double porcentagemDeGordura;

    public PorcentagemDeGordura() {

    }

    public PorcentagemDeGordura(AutorEnum autor, double porcentagemDeGordura) {
        this.autor = autor;
        this.porcentagemDeGordura = porcentagemDeGordura;
    }

    public UUID getIdAvaliacao() {
        return this.idAvaliacao;
    }

    public void setIdAvaliacao(UUID idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public AutorEnum getAutor() {
        return this.autor;
    }

    public void setAutorEnum(AutorEnum autor) {
        this.autor = autor;
    }

    public void setAutorEnum(int autor) {
        switch (autor) {
            case 1:
                this.autor = AutorEnum.POLLOCK7D;
                break;
            case 2:
                this.autor = AutorEnum.POLLOCK3D;
                break;
            case 3:
                this.autor = AutorEnum.GUEDES;
                break;
            case 4:
                this.autor = AutorEnum.PETROSKY;
                break;
            case 5:
                this.autor = AutorEnum.THORLAND7D;
                break;
            case 6:
                this.autor = AutorEnum.THORLAND3D;
                break;
        }
    }

    public double getPorcentagemDeGordura() {
        return this.porcentagemDeGordura;
    }

    public void setPorcentagemDeGordura(double porcentagemDeGordura) {
        this.porcentagemDeGordura = porcentagemDeGordura;
    }
}
