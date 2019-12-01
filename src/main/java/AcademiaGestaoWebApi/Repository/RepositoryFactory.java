package AcademiaGestaoWebApi.Repository;

import AcademiaGestaoWebApi.Enums.RepositoryEnum;
import AcademiaGestaoWebApi.Repository.Treino.AlunoTreinoRepository;
import AcademiaGestaoWebApi.Repository.Treino.GrupoMuscularRepository;
import AcademiaGestaoWebApi.Repository.Treino.TreinoRepository;

public final class RepositoryFactory {

    private RepositoryFactory(){
    }
    
    public static Repository CreateRepository(RepositoryEnum repository){
        return CreateRepository(repository.toString());
    }

    private static Repository CreateRepository(String repository){

        switch (repository) {
            case "ALUNO":  
                return new AlunoRepository();              
            case "AVALIACAO":
                return new AvaliacaoRepository();
            case "MEDIAGORDURA":
                return new DadosRepository();
            case "TREINO":
                return new TreinoRepository();
            case "GRUPOMUSCULAR":
                return new GrupoMuscularRepository();
            case "ALUNOTREINO":
                return new AlunoTreinoRepository();
        }

        return null;
    }
}