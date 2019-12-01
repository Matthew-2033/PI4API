package AcademiaGestaoWebApi.Enums;

public enum RepositoryEnum{
    ALUNO(1),
    AVALIACAO(2),
    MEDIAGORDURA(3),
    TREINO(4),    
    GRUPOMUSCULAR(5),
    ALUNOTREINO(6);
    
    public int valorRepository;

    RepositoryEnum(int valor) {
        valorRepository = valor;
    }

    public int getInt(){
        return valorRepository;
    }
}