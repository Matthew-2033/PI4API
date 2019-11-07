package AcademiaGestaoWebApi.Manager.Treinos;

import AcademiaGestaoWebApi.Enums.RepositoryEnum;
import AcademiaGestaoWebApi.Models.Treinos.Treino;
import AcademiaGestaoWebApi.Repository.Repository;
import AcademiaGestaoWebApi.Repository.RepositoryFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TreinoManager {
    
    public List<Treino> selectTreino(UUID id) throws Exception {
        
        Repository<Treino> repository = RepositoryFactory.CreateRepository(RepositoryEnum.TREINO);
        
        List<Treino> treinos = new ArrayList<>();
        
        Treino treino = repository.select(id);
        treinos.add(treino);
        
        return treinos;
    }
    
    
}
