package AcademiaGestaoWebApi.Calculos;

import AcademiaGestaoWebApi.Enums.SexoEnum;

public class DensidadeCorporal{    
    
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
    
    public DensidadeCorporal(SexoEnum sexo){
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
    
    public double pollock7D(int idade, double peitoral, double axilarMedia, double subEscapular, double tricipital, double supraIliciaca, double abdominal, double coxa){
        if(idade == 0 || peitoral == 0 || axilarMedia == 0 || subEscapular == 0 || tricipital == 0 || supraIliciaca == 0 || abdominal == 0 || coxa == 0){
            return 0;
        }
        
        double dobras = peitoral + axilarMedia + subEscapular + tricipital + supraIliciaca + abdominal + coxa;
        
        double densidadeCorporal = multiplicadorPolock7D * dobras + multiplicadorDobrasPolock7D * (dobras * dobras) - multiplicadorIdadePolock7D * idade;
        return densidadeCorporal;
    };
    
    public double pollock3D(int idade, double peitoral, double abdominal, double coxa, SexoEnum sexo){
        if(idade == 0 || peitoral == 0 || abdominal == 0 || coxa == 0){
            return 0;
        }
        
        double densidadeCorporal = 0;
        double dobras = peitoral + abdominal + coxa;
        if(sexo == SexoEnum.MASCULINO){
            densidadeCorporal = multiplicadorPolock3D * dobras + multiplicadorIdadePolock3D * (idade * idade) - multiplicadorDobrasPolock3D * dobras;
            return densidadeCorporal;            
        }
        
        densidadeCorporal = multiplicadorPolock3D * idade + multiplicadorDobrasPolock3D * (dobras * dobras) - multiplicadorIdadePolock3D * idade;
        return densidadeCorporal;
    }    
    
    public double guedes(double tricipital, double supraIliciaca, double abdominal){
        if(tricipital == 0 || supraIliciaca == 0 || abdominal == 0){
            return 0;
        }

        double densidadeCorporal = guedesMultiplicador * Math.log10(tricipital + supraIliciaca + abdominal);
        return densidadeCorporal;
    }
    
    public double petroski(int idade, double subEscapular, double tricipital, double supraIliciaca, double panturrilha, SexoEnum sexo){
        if(idade == 0 || subEscapular == 0 || tricipital == 0 || supraIliciaca == 0 || panturrilha == 0){
            return 0;            
        }
        
        double dobras = subEscapular + tricipital + supraIliciaca + panturrilha;       
        double densidadeCorporal = 0;
        if(sexo == SexoEnum.MASCULINO){
            densidadeCorporal = petroskiMultiplicador * dobras + petroskiMultiplicadorDobras * (dobras * dobras) - petroskiMultiplicadorIdade * idade;            
            return densidadeCorporal;
        }
        
        densidadeCorporal = petroskiMultiplicador * Math.log10(dobras) - petroskiMultiplicadorIdade * idade;
        return densidadeCorporal;
    }    
    
    public double thorland7D(double axilarMedia, double subEscapular, double supraIliciaca, double abdominal, double coxa, double panturrilha){
       if(axilarMedia == 0 || subEscapular == 0 || supraIliciaca == 0 || abdominal == 0 || coxa == 0 || panturrilha == 0){
           return 0;            
       }

       double dobras = axilarMedia + subEscapular + supraIliciaca + abdominal + coxa + panturrilha;
       double densidadeCorporal = thorland7DMultiplicador * dobras + thorland7DMultiplicadorDobras * (dobras * dobras);
       return densidadeCorporal;
    }
    
    public double thorland3D(double axilarMedia, double subEscapular, double tricipital){
        if(axilarMedia == 0 || subEscapular == 0 || tricipital == 0){
            return 0;
        }
        
        double dobras = axilarMedia + subEscapular + tricipital;
        double densidadeCorporal = thorland3DMultiplicador * (dobras) + thorland3DMultiplicadorDobras * (dobras * dobras);
        return densidadeCorporal;
    }
}