package AcademiaGestaoWebApi.Manager.Treinos;

import AcademiaGestaoWebApi.Models.Treinos.Exercicio;
import AcademiaGestaoWebApi.Repository.Treino.ExerciciosRepository;
import java.util.List;

public class ExercicioManager {
    
    private final ExerciciosRepository repository;
    
    public ExercicioManager() {
        repository = new ExerciciosRepository();
    }
            
    public List<Exercicio> selectExercicios() throws Exception {
        List<Exercicio> exercicios = repository.select();
        return exercicios;
    }
}
