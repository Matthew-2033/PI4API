package AcademiaGestaoWebApi.Repository;

import AcademiaGestaoWebApi.Enums.RepositoryEnum;

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
        }

        return null;
    }
}