package AcademiaGestaoWebApi.Enums;

public enum SexoEnum{
    MASCULINO(1),
    FEMININO(2),
    AMBOS(3);

    public int valorSexo;

    SexoEnum(int valor) {
        valorSexo = valor;
    }

    public int getInt(){
        return valorSexo;
    }
}