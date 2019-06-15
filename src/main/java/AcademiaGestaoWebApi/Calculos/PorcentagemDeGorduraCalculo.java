package AcademiaGestaoWebApi.Calculos;

import AcademiaGestaoWebApi.Models.PorcentagemDeGordura;
import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;

import java.util.ArrayList;
import java.util.List;

import AcademiaGestaoWebApi.Enums.AutorEnum;
import AcademiaGestaoWebApi.Enums.SexoEnum;;

public class PorcentagemDeGorduraCalculo{    


    private final double multiplicador = 100;
    private final double constValue1 = 4.95;
    private final double constValue2 = 4.5;


    public List<PorcentagemDeGordura> executaCalculos(AvaliacaoRequest avaliacao){
        
        List<PorcentagemDeGordura> porcentagemDeGorduraLista = new ArrayList<>();

        double pollock7D = this.pollock7D(avaliacao);
        if (pollock7D >= 0 ) {
            PorcentagemDeGordura gordura = new PorcentagemDeGordura(AutorEnum.POLLOCK7D, pollock7D);
            porcentagemDeGorduraLista.add(gordura);
        }

        double pollock3D = this.pollock3D(avaliacao);
        if (pollock3D >= 0 ) {
            PorcentagemDeGordura gordura = new PorcentagemDeGordura(AutorEnum.POLLOCK3D, pollock3D);
            porcentagemDeGorduraLista.add(gordura);
        }
        
        double guedes = this.guedes(avaliacao);
        if (guedes >= 0 ) {
            PorcentagemDeGordura gordura = new PorcentagemDeGordura(AutorEnum.GUEDES, guedes);
            porcentagemDeGorduraLista.add(gordura);
        }

        double petroski = this.petroski(avaliacao);
        if (petroski >= 0 ) {
            PorcentagemDeGordura gordura = new PorcentagemDeGordura(AutorEnum.PETROSKY, petroski);
            porcentagemDeGorduraLista.add(gordura);
        }

        double thorland7D = this.thorland7D(avaliacao);
        if (thorland7D >= 0 ) {
            PorcentagemDeGordura gordura = new PorcentagemDeGordura(AutorEnum.THORLAND7D, thorland7D);
            porcentagemDeGorduraLista.add(gordura);
        }

        double thorland3D = this.thorland3D(avaliacao);
        if (thorland3D >= 0 ) {
            PorcentagemDeGordura gordura = new PorcentagemDeGordura(AutorEnum.THORLAND3D, thorland3D);
            porcentagemDeGorduraLista.add(gordura);
        }

        return porcentagemDeGorduraLista;
    }

    private double pollock7D(AvaliacaoRequest avaliacao){

        DensidadeCorporalCalculo pollock7DCalculo = new DensidadeCorporalCalculo(avaliacao.getSexo());
        double pollockResult = pollock7DCalculo.pollock7D(avaliacao);

        if(pollockResult == 0){
            return 0; 
        }

        double porcentagemGordura = 0;
        if(avaliacao.getSexo() == SexoEnum.MASCULINO){
            porcentagemGordura = (this.constValue1 / pollockResult - this.constValue2) * multiplicador;
            return porcentagemGordura;
        }

        porcentagemGordura = ( ( this.constValue1 / pollockResult ) - this.constValue2 ) * multiplicador;
        return porcentagemGordura;
    }

    private double pollock3D(AvaliacaoRequest avaliacao){

        DensidadeCorporalCalculo pollock3DCalculo = new DensidadeCorporalCalculo(avaliacao.getSexo());
        double pollockResult = pollock3DCalculo.pollock3D(avaliacao);

        if (pollockResult == 0) {
            return 0;
        }

        double porcentagemGordura = 0;
        if (avaliacao.getSexo() == SexoEnum.MASCULINO) {
            porcentagemGordura = ( this.constValue1 / pollockResult - this.constValue2 ) * multiplicador;
            return porcentagemGordura;
        }

        porcentagemGordura = ( ( this.constValue1 / pollockResult ) - this.constValue2 ) * multiplicador;
        return porcentagemGordura;
    }

    private double guedes(AvaliacaoRequest avaliacao){

        DensidadeCorporalCalculo guedesCalculo = new DensidadeCorporalCalculo(avaliacao.getSexo());
        double guedesResult = guedesCalculo.guedes(avaliacao);

        if (guedesResult == 0) {
            return 0;
        }

        double porcentagemGordura = 0;
        if (avaliacao.getSexo() == SexoEnum.MASCULINO) {
            porcentagemGordura = ( this.constValue1 / guedesResult - this.constValue2 ) * this.multiplicador;
            return porcentagemGordura;
        }

        porcentagemGordura = ( ( this.constValue1 / guedesResult ) - this.constValue2 ) * this.multiplicador;
        return porcentagemGordura;
      
    }

    private double petroski(AvaliacaoRequest avaliacao){

        DensidadeCorporalCalculo petroskiCalculo = new DensidadeCorporalCalculo(avaliacao.getSexo());
        double petroskiResult = petroskiCalculo.petroski(avaliacao);

        if (petroskiResult == 0) {
            return 0;
        }

        double porcentagemGordura = 0;
        if (avaliacao.getSexo() == SexoEnum.MASCULINO) {
            porcentagemGordura = ( this.constValue1 / petroskiResult - this.constValue2 ) * this.multiplicador;
            return porcentagemGordura;
        }

        porcentagemGordura = ( ( this.constValue1  / petroskiResult ) - this.constValue2) * this.multiplicador;
        return porcentagemGordura;
    }

    /**
     * Calculos de Thorland tem a mesma equacao para ambos os sexos
     * independente da quantidade de dobras
     */
    private double thorland7D(AvaliacaoRequest avaliacao){

        DensidadeCorporalCalculo thorland7DCalculo = new DensidadeCorporalCalculo(avaliacao.getSexo());
        double thorland7DResult = thorland7DCalculo.thorland7D(avaliacao);

        if (thorland7DResult == 0) {
            return 0;
        }

        double porcentagemGordura = 0;
        porcentagemGordura = ( ( this.constValue1 / thorland7DResult ) - this.constValue2 ) * this.multiplicador;

        return porcentagemGordura;

    }

    private double thorland3D(AvaliacaoRequest avaliacao){

        DensidadeCorporalCalculo thorland3DCalculo = new DensidadeCorporalCalculo(avaliacao.getSexo());
        double thorland3DResult = thorland3DCalculo.thorland3D(avaliacao);

        if(thorland3DResult == 0){
            return 0;
        }

        double porcentagemGordura = 0;
        porcentagemGordura = ( ( this.constValue1 / thorland3DResult ) - this.constValue2 ) * this.multiplicador;

        return porcentagemGordura;
    }
}