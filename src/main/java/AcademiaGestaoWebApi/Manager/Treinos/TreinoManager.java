package AcademiaGestaoWebApi.Manager.Treinos;

import AcademiaGestaoWebApi.Enums.RepositoryEnum;
import AcademiaGestaoWebApi.Models.Treinos.AlunoTreino;
import AcademiaGestaoWebApi.Models.Treinos.Treino;
import AcademiaGestaoWebApi.Repository.Repository;
import AcademiaGestaoWebApi.Repository.RepositoryFactory;
import AcademiaGestaoWebApi.Repository.Treino.TreinoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TreinoManager {

    public List<Treino> selectTreino(UUID id) throws Exception {

        Repository<Treino> repository = RepositoryFactory.CreateRepository(RepositoryEnum.TREINO);
        List<Treino> treinos = new ArrayList<>();

        if (id.toString().equals("00000000-0000-0000-0000-000000000000")) {
            treinos = repository.select();
        } else {
            treinos.add(repository.select(id));
        }

        return treinos;
    }
}
