package AcademiaGestaoWebApi.Models;

import AcademiaGestaoWebApi.Enums.AutorEnum;
import AcademiaGestaoWebApi.Enums.SexoEnum;

/**
 *
 * @author matheusvieira
 */
public class MediaPorcentagemGordura {

    private double media;
    private SexoEnum sexo;
    private AutorEnum autor;

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SexoEnum getSexo() {
        return sexo;
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

    public AutorEnum getAutor() {
        return autor;
    }

    public void setAutor(AutorEnum autor) {
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

}
