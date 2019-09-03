/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcademiaGestaoWebApi.Models;

import AcademiaGestaoWebApi.Enums.AutorEnum;
import AcademiaGestaoWebApi.Enums.SexoEnum;

/**
 *
 * @author matheusvieira
 */
public class MediaDeGordura {

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

    public void setSexo(int sexo) {
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

   
}
