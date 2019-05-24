package AcademiaGestaoWebApi.Calculos;

import AcademiaGestaoWebApi.Enums.SexoEnum;
import AcademiaGestaoWebApi.Models.Avaliacao;
import AcademiaGestaoWebApi.Models.DensidadeCorporal;
import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DensidadeCorporalCalculo{    
    
    private final double multiplicadorPolock7D;
    private final double multiplicadorDobrasPolock7D;
    private final double multiplicadorIdadePolock7D;
    
    private final double multiplicadorPolock3D;
    private final double multiplicadorDobrasPolock3D;
    private final double multiplicadorIdadePolock3D;
    
    private final double guedesMultiplicador;
    
    private final double petroskiMultiplicador;
    private final double petroskiMultiplicadorDobras; 
    private final double petroskiMultiplicadorIdade; 
    
    private final double thorland7DMultiplicador;
    private final double thorland7DMultiplicadorDobras;   
    
    private final double thorland3DMultiplicador;
    private final double thorland3DMultiplicadorDobras; 
    
    public DensidadeCorporalCalculo(SexoEnum sexo){
        if(sexo == SexoEnum.MASCULINO){
            multiplicadorPolock7D = 1.11156501;
            multiplicadorDobrasPolock7D = 0.00000055;
            multiplicadorIdadePolock7D = 0.00028826;    
            
            multiplicadorPolock3D = 1.1085533;
            multiplicadorDobrasPolock3D = 0.0002574;
            multiplicadorIdadePolock3D = 0.0000016;
            
            guedesMultiplicador = 1.1043;
            
            petroskiMultiplicador = 1.10645662;
            petroskiMultiplicadorDobras = 0.00000212;
            petroskiMultiplicadorIdade = 0.00041761;
            
            thorland7DMultiplicador = 1.10858;
            thorland7DMultiplicadorDobras = 0.00000032;
            
            thorland3DMultiplicador = 1.11206;
            thorland3DMultiplicadorDobras = 0.00000516;
            return;
        }
        
        multiplicadorPolock7D = 1.09653029;
        multiplicadorDobrasPolock7D = 0.00000056;
        multiplicadorIdadePolock7D = 0.00012828; 
        
        multiplicadorPolock3D = 1.0984992;
        multiplicadorDobrasPolock3D = 0.0000023;
        multiplicadorIdadePolock3D = 0.0001392;
        
        guedesMultiplicador = 1.0959;
        
        petroskiMultiplicador = 1.12033623;
        petroskiMultiplicadorDobras = 0;
        petroskiMultiplicadorIdade = 0.00041072;
        
        thorland7DMultiplicador = 1.10401;
        thorland7DMultiplicadorDobras = 0.0000006;
        
        thorland3DMultiplicador = 1.09748;
        thorland3DMultiplicadorDobras = 0.00000263;        
    }
    
    public List<DensidadeCorporal> ExecutaCalculos(AvaliacaoRequest avaliacao){
        List<DensidadeCorporal> densidadesCoporais = new ArrayList<>();
        
        double pollock7D = pollock7D(avaliacao);            
        if(pollock7D >= 0){            
            DensidadeCorporal densidadePollock7D = new DensidadeCorporal();
            densidadePollock7D.setAutor("Pollock7D");
            densidadePollock7D.setDensidadeCorporal(pollock7D);
            densidadesCoporais.add(densidadePollock7D);
        }
        
        double pollock3D = pollock3D(avaliacao);
        if(pollock3D >= 0){            
            DensidadeCorporal densidadePollock3D = new DensidadeCorporal();   
            densidadePollock3D.setAutor("Pollock3D");
            densidadePollock3D.setDensidadeCorporal(pollock3D);
            densidadesCoporais.add(densidadePollock3D);
        }
        
        double guedes = guedes(avaliacao);
        if (guedes >=0) {
            DensidadeCorporal densidadeGuedes = new DensidadeCorporal();
            densidadeGuedes.setAutor("Guedes");
            densidadeGuedes.setDensidadeCorporal(guedes);
            densidadesCoporais.add(densidadeGuedes);
        }
        
        double petroski = petroski(avaliacao);
        if (petroski >=0) {
            DensidadeCorporal densidadePetroski = new DensidadeCorporal();
            densidadePetroski.setAutor("Petroski");
            densidadePetroski.setDensidadeCorporal(petroski);
            densidadesCoporais.add(densidadePetroski);   
        }

        double thorland7D = thorland7D(avaliacao);
        if (thorland7D >=0) {
            DensidadeCorporal densidadeThorland7D = new DensidadeCorporal();
            densidadeThorland7D.setAutor("Thorland7D");
            densidadeThorland7D.setDensidadeCorporal(thorland7D);
            densidadesCoporais.add(densidadeThorland7D);               
        }

        double thorland3D = thorland3D(avaliacao);
        if (thorland3D >=0) {
            DensidadeCorporal densidadeThorland3D = new DensidadeCorporal();
            densidadeThorland3D.setAutor("Thorland3D");
            densidadeThorland3D.setDensidadeCorporal(thorland3D);
            densidadesCoporais.add(densidadeThorland3D);               
        }

        return densidadesCoporais;
    }
    
    public double pollock7D(AvaliacaoRequest avaliacao){
        if(avaliacao.getIdade() == 0 || avaliacao.getPeitoral() == 0 || avaliacao.getMediaAuxiliar() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getTricipital() == 0 || avaliacao.getSupraIliaca() == 0 || avaliacao.getAbdominalDobra() == 0 || avaliacao.getCoxa() == 0){
            return 0;
        }
        
        double dobras = avaliacao.getPeitoral() + avaliacao.getMediaAuxiliar() + avaliacao.getSubEscapular() + avaliacao.getTricipital() + avaliacao.getSupraIliaca() + avaliacao.getAbdominalDobra() + avaliacao.getCoxa();
        
        double densidadeCorporal = multiplicadorPolock7D * dobras + multiplicadorDobrasPolock7D * (dobras * dobras) - multiplicadorIdadePolock7D * avaliacao.getIdade();
        return densidadeCorporal;
    };
    
    public double pollock3D(AvaliacaoRequest avaliacao){
        if(avaliacao.getIdade() == 0 || avaliacao.getPeitoral() == 0 || avaliacao.getAbdominalDobra() == 0 || avaliacao.getCoxa() == 0){
            return 0;
        }
        
        double densidadeCorporal = 0;
        double dobras = avaliacao.getPeitoral() + avaliacao.getAbdominalDobra() + avaliacao.getCoxa();
        if(avaliacao.getSexo() == SexoEnum.MASCULINO){
            densidadeCorporal = multiplicadorPolock3D * dobras + multiplicadorIdadePolock3D * (avaliacao.getIdade() * avaliacao.getIdade()) - multiplicadorDobrasPolock3D * dobras;
            return densidadeCorporal;            
        }
        
        densidadeCorporal = multiplicadorPolock3D * avaliacao.getIdade() + multiplicadorDobrasPolock3D * (dobras * dobras) - multiplicadorIdadePolock3D * avaliacao.getIdade();
        return densidadeCorporal;
    }    
    
    public double guedes(AvaliacaoRequest avaliacao){
        if(avaliacao.getTricipital() == 0 || avaliacao.getSupraIliaca() == 0 || avaliacao.getAbdominalDobra() == 0){
            return 0;
        }

        double densidadeCorporal = guedesMultiplicador * Math.log10(avaliacao.getTricipital() + avaliacao.getSupraIliaca() + avaliacao.getAbdominalDobra());
        return densidadeCorporal;
    }
    
    public double petroski(AvaliacaoRequest avaliacao){
        if(avaliacao.getIdade() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getTricipital() == 0 || avaliacao.getSupraIliaca() == 0 || avaliacao.getPanturrilha() == 0){
            return 0;            
        }
        
        double dobras = avaliacao.getSubEscapular() + avaliacao.getTricipital() + avaliacao.getSupraIliaca() + avaliacao.getPanturrilha();       
        double densidadeCorporal = 0;
        if(avaliacao.getSexo() == SexoEnum.MASCULINO){
            densidadeCorporal = petroskiMultiplicador * dobras + petroskiMultiplicadorDobras * (dobras * dobras) - petroskiMultiplicadorIdade * avaliacao.getIdade();            
            return densidadeCorporal;
        }
        
        densidadeCorporal = petroskiMultiplicador * Math.log10(dobras) - petroskiMultiplicadorIdade * avaliacao.getIdade();
        return densidadeCorporal;
    }    
    
    public double thorland7D(AvaliacaoRequest avaliacao){
       if(avaliacao.getMediaAuxiliar() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getAbdominalDobra() == 0 || avaliacao.getCoxa() == 0 || avaliacao.getPanturrilha() == 0){
           return 0;            
       }

       double dobras = avaliacao.getMediaAuxiliar() + avaliacao.getSubEscapular() + avaliacao.getSubEscapular() + avaliacao.getAbdominalDobra() + avaliacao.getCoxa() + avaliacao.getPanturrilha();
       double densidadeCorporal = thorland7DMultiplicador * dobras + thorland7DMultiplicadorDobras * (dobras * dobras);
       return densidadeCorporal;
    }
    
    public double thorland3D(AvaliacaoRequest avaliacao){
        if(avaliacao.getMediaAuxiliar() == 0 || avaliacao.getSubEscapular() == 0 || avaliacao.getTricipital() == 0){
            return 0;
        }
        
        double dobras = avaliacao.getMediaAuxiliar() + avaliacao.getSubEscapular() + avaliacao.getTricipital();
        double densidadeCorporal = thorland3DMultiplicador * (dobras) + thorland3DMultiplicadorDobras * (dobras * dobras);
        return densidadeCorporal;
    }
}