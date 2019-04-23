package AcademiaGestaoWebApi.Calculos;

public class CalculosGerais{

    // Calculos de resultado simples:
    public static Double calculo_imc(double massa, double estatura){
        
        double result = 0;

        if(massa != 0 && estatura != 0){
            result = massa / (estatura * estatura);
        }
        
        return result;
    }
    
    public static Double calculo_pccq(double cintura, double quadril){
        
        double result = 0;
        
        if(cintura != 0 && quadril != 0){
            result = cintura / quadril;
        }
        
        return result;
    }
    
    //Calculos de Fracionamento CC
    public static Double calculo_massaDeGordura(double pesoAtual, double gordura){
        
        double result = 0;
        
        if(pesoAtual != 0 && gordura != 0){
            result = pesoAtual * gordura;
        }
        
        return result;
    }
    
    public static Double calculo_massaMagra(double pesoAtual, double massaDeGordura){
        
        double result = 0;
        
        if(pesoAtual != 0 && massaDeGordura != 0){            
            result = pesoAtual - massaDeGordura;
        }
        
        return result;
    }
    
    public static Double calculo_pesoIdeal(double massaMagra, double gorduraIdeal){
        
        double result = 0;
        
        if(massaMagra != 0 && gorduraIdeal != 0){
            result = massaMagra / (1 - gorduraIdeal);
        }
        
        return result;
    }
    
    public static Double calculo_pesoExcesso(double pesoAtual, double pesoIdeal){
        
        double result = 0;
        
        if(pesoAtual != 0 && pesoIdeal != 0){
            result = pesoAtual - pesoIdeal;
        }
        
        return result;
    }
}