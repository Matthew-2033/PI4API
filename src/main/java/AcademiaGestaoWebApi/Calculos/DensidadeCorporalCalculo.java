package AcademiaGestaoWebApi.Calculos;

import AcademiaGestaoWebApi.Enums.SexoEnum;
import AcademiaGestaoWebApi.Models.Avaliacao;
import AcademiaGestaoWebApi.Models.DensidadeCorporal;
import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DensidadeCorporalCalculo {

    private final double multiplicadorPolock7DVal_1;
    private final double multiplicadorPolockVal_2;
    private final double multiplicadorDobrasPolock7D;
    private final double multiplicadorIdadePolock7D;

    private final double multiplicadorPolock3DVal_1;
    private final double multiplicadorPolock3DVal_2;
    private final double multiplicadorDobrasPolock3D;
    private final double multiplicadorIdadePolock3D;

    private final double guedesMultiplicadorVal_1;
    private final double guedesMultiplicadorVal_2;

    private final double petroskiMultiplicadorVal_1;
    private final double petroskiMultiplicadorVal_2;
    private final double petroskiMultiplicadorDobras;
    private final double petroskiMultiplicadorIdade;

    private final double thorland7DMultiplicadorVal_1;
    private final double thorland7DMultiplicadorVal_2;
    private final double thorland7DMultiplicadorDobras;

    private final double thorland3DMultiplicadorVal_1;
    private final double thorland3DMultiplicadorVal_2;
    private final double thorland3DMultiplicadorDobras;

    protected DensidadeCorporalCalculo(SexoEnum sexo) {
        if (sexo == SexoEnum.MASCULINO) {

            multiplicadorPolock7DVal_1 = 1.112;
            multiplicadorPolockVal_2 = 0.00043499;
            multiplicadorDobrasPolock7D = 0.00000055;
            multiplicadorIdadePolock7D = 0.00028826;

            multiplicadorPolock3DVal_1 = 1.10938;
            multiplicadorPolock3DVal_2 = 0.0008267;
            multiplicadorDobrasPolock3D = 0.0002574;
            multiplicadorIdadePolock3D = 0.0000016;

            guedesMultiplicadorVal_1 = 1.1714;
            guedesMultiplicadorVal_2 = 0.0671;

            petroskiMultiplicadorVal_1 = 1.10726863;
            petroskiMultiplicadorVal_2 = 0.00081201;
            petroskiMultiplicadorDobras = 0.00000212;
            petroskiMultiplicadorIdade = 0.00041761;

            thorland7DMultiplicadorVal_1 = 1.1091;
            thorland7DMultiplicadorVal_2 = 0.00052;
            thorland7DMultiplicadorDobras = 0.00000032;

            thorland3DMultiplicadorVal_1 = 1.1136;
            thorland3DMultiplicadorVal_2 = 0.00154;
            thorland3DMultiplicadorDobras = 0.00000516;
            return;
        }

        multiplicadorPolock7DVal_1 = 1.097;
        multiplicadorPolockVal_2 = 0.00046971;
        multiplicadorDobrasPolock7D = 0.00000056;
        multiplicadorIdadePolock7D = 0.00012828;

        multiplicadorPolock3DVal_1 = 1.0994921;
        multiplicadorPolock3DVal_2 = 0.0009929;
        multiplicadorDobrasPolock3D = 0.0000023;
        multiplicadorIdadePolock3D = 0.0001392;

        guedesMultiplicadorVal_1 = 1.1665;
        guedesMultiplicadorVal_2 = 0.0706;

        petroskiMultiplicadorVal_1 = 1.1954713;
        petroskiMultiplicadorVal_2 = 0.07513507;
        petroskiMultiplicadorDobras = 0;
        petroskiMultiplicadorIdade = 0.00041072;

        thorland7DMultiplicadorVal_1 = 1.1046;
        thorland7DMultiplicadorVal_2 = 0.00059;
        thorland7DMultiplicadorDobras = 0.0000006;

        thorland3DMultiplicadorVal_1 = 1.0987;
        thorland3DMultiplicadorVal_2 = 0.00122;
        thorland3DMultiplicadorDobras = 0.00000263;
    }

    protected double pollock7D(AvaliacaoRequest avaliacao) {
        if (avaliacao.getIdade() == 0 || avaliacao.getPeitoral() == 0 || avaliacao.getMediaAuxiliar() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getTricipital() == 0 || avaliacao.getSupraIliaca() == 0 || avaliacao.getAbdominalDobra() == 0 || avaliacao.getCoxa() == 0) {
            return 0;
        }

        double dobras = avaliacao.getPeitoral() + avaliacao.getMediaAuxiliar() + avaliacao.getSubEscapular() + avaliacao.getTricipital() + avaliacao.getSupraIliaca() + avaliacao.getAbdominalDobra() + avaliacao.getCoxa();

        double densidadeCorporal = multiplicadorPolock7DVal_1 - multiplicadorPolockVal_2 * dobras + multiplicadorDobrasPolock7D * (dobras * dobras) - multiplicadorIdadePolock7D * avaliacao.getIdade();
        return densidadeCorporal;
    }

    ;
    
    protected double pollock3D(AvaliacaoRequest avaliacao) {
        if (avaliacao.getIdade() == 0 || avaliacao.getPeitoral() == 0 || avaliacao.getAbdominalDobra() == 0 || avaliacao.getCoxa() == 0) {
            return 0;
        }

        double densidadeCorporal = 0;
        double dobras = avaliacao.getPeitoral() + avaliacao.getAbdominalDobra() + avaliacao.getCoxa();
        if (avaliacao.getSexo() == SexoEnum.MASCULINO) {
            densidadeCorporal = multiplicadorPolock3DVal_1 - multiplicadorPolock3DVal_2  * dobras + multiplicadorIdadePolock3D * (avaliacao.getIdade() * avaliacao.getIdade()) - multiplicadorDobrasPolock3D * dobras;
            return densidadeCorporal;
        }

        densidadeCorporal = multiplicadorPolock3DVal_1 - multiplicadorPolock3DVal_2 * avaliacao.getIdade() + multiplicadorDobrasPolock3D * (dobras * dobras) - multiplicadorIdadePolock3D * avaliacao.getIdade();
        return densidadeCorporal;
    }

    protected double guedes(AvaliacaoRequest avaliacao) {
        if (avaliacao.getTricipital() == 0 || avaliacao.getSupraIliaca() == 0 || avaliacao.getAbdominalDobra() == 0) {
            return 0;
        }

        double densidadeCorporal = guedesMultiplicadorVal_1 - guedesMultiplicadorVal_2 * Math.log10(avaliacao.getTricipital() + avaliacao.getSupraIliaca() + avaliacao.getAbdominalDobra());
        return densidadeCorporal;
    }

    protected double petroski(AvaliacaoRequest avaliacao) {
        if (avaliacao.getIdade() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getTricipital() == 0 || avaliacao.getSupraIliaca() == 0 || avaliacao.getPanturrilha() == 0) {
            return 0;
        }

        double dobras = avaliacao.getSubEscapular() + avaliacao.getTricipital() + avaliacao.getSupraIliaca() + avaliacao.getPanturrilha();
        double densidadeCorporal = 0;
        if (avaliacao.getSexo() == SexoEnum.MASCULINO) {
            densidadeCorporal = petroskiMultiplicadorVal_1 - petroskiMultiplicadorVal_2 * dobras + petroskiMultiplicadorDobras * (dobras * dobras) - petroskiMultiplicadorIdade * avaliacao.getIdade();
            return densidadeCorporal;
        }

        densidadeCorporal = petroskiMultiplicadorVal_1 - petroskiMultiplicadorVal_2 * Math.log10(dobras) - petroskiMultiplicadorIdade * avaliacao.getIdade();
        return densidadeCorporal;
    }

    protected double thorland7D(AvaliacaoRequest avaliacao) {
        if (avaliacao.getMediaAuxiliar() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getAbdominalDobra() == 0 || avaliacao.getCoxa() == 0 || avaliacao.getPanturrilha() == 0) {
            return 0;
        }

        double dobras = avaliacao.getMediaAuxiliar() + avaliacao.getSubEscapular() + avaliacao.getSubEscapular() + avaliacao.getAbdominalDobra() + avaliacao.getCoxa() + avaliacao.getPanturrilha();
        double densidadeCorporal = thorland7DMultiplicadorVal_1 - thorland3DMultiplicadorVal_2 * dobras + thorland7DMultiplicadorDobras * (dobras * dobras);
        return densidadeCorporal;
    }

    protected double thorland3D(AvaliacaoRequest avaliacao) {
        if (avaliacao.getMediaAuxiliar() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getTricipital() == 0) {
            return 0;
        }

        double dobras = avaliacao.getMediaAuxiliar() + avaliacao.getSubEscapular() + avaliacao.getTricipital();
        double densidadeCorporal = thorland3DMultiplicadorVal_1 - thorland3DMultiplicadorVal_2 * (dobras) + thorland3DMultiplicadorDobras * (dobras * dobras);
        return densidadeCorporal;
    }
}
