package AcademiaGestaoWebApi.Calculos;

public class PorcentagemDeGordura{    

    public double pollock7D(int idade, double peitoral, double axilarMedia, double subEscapular, double tricipital, double supraIliciaca, double abdominal, double coxa){
        if(idade == 0 || peitoral == 0 || axilarMedia == 0 || subEscapular == 0 || tricipital == 0 || supraIliciaca == 0 || abdominal == 0 || coxa == 0){
            return 0;
        }
        
        double dobras = peitoral + axilarMedia + subEscapular + tricipital + supraIliciaca + abdominal + coxa;

        double densidadeDeGordura = 1.112 - 0.00043499 * dobras + 0.00000055 * (dobras * dobras) - 0.00028826 * idade;
        return densidadeDeGordura;
    };

    public double pollock3D(int idade, double peitoral, double abdominal, double coxa){
        if(idade == 0 || peitoral == 0 || abdominal == 0 || coxa == 0){
            return 0;
        }

        double dobras = peitoral + abdominal + coxa;
        double densidadeDeGordura = 1.10938 - 0.0008267 * dobras + 0.0000016 * (idade * idade) - 0.0002574 * dobras;
        return densidadeDeGordura;
    }

    public double guedes(double tricipital, double supraIliciaca, double abdominal){
        if(tricipital == 0 || supraIliciaca == 0 || abdominal == 0){
            return 0;
        }

        double densidadeDeGordura = 1.1714- 0.0671 * Math.log10(tricipital + supraIliciaca + abdominal);
        return densidadeDeGordura;
    }
}