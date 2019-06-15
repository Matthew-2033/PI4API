package AcademiaGestaoWebApi.Enums;

public enum AutorEnum {
    POLLOCK7D(1),
    POLLOCK3D(2),
    GUEDES(3),
    PETROSKY(4),
    THORLAND7D(5),
    THORLAND3D(6);
    
    public int valorAutor;

    AutorEnum(int valor) {
        valorAutor = valor;
    }

    public int getInt(){
        return valorAutor;
    }
}
