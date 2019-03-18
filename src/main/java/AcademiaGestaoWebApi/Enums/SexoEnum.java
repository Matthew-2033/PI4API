package AcademiaGestaoWebApi.Enums;

import java.util.Calendar;

public enum SexoEnum{
    MASCULINO(1),
    Feminino(2),
    NaoIdentificado(3);

    public int valorSexo;
    SexoEnum(int valor) {
        valorSexo = valor;
    }

    public int getInt(){
        return valorSexo;
    }
}