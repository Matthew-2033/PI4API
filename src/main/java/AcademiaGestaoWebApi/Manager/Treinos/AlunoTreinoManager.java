package AcademiaGestaoWebApi.Manager.Treinos;

import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import java.util.UUID;
import AcademiaGestaoWebApi.Models.Treinos.AlunoTreino;
import AcademiaGestaoWebApi.Repository.Treino.AlunoTreinoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AlunoTreinoManager {

    private final AlunoTreinoRepository repository;

    public AlunoTreinoManager() {
        this.repository = new AlunoTreinoRepository();
    }

    public List<AlunoTreino> selectTreinoAtrelado(UUID id) throws Exception {
        List<AlunoTreino> treinos = new ArrayList<>();
        AlunoTreino alunoTreino = this.repository.select(id);
        treinos.add(alunoTreino);
        return treinos;
    }

    public ResponseEntity<ApiRetorno<Boolean>> finaliza(UUID id) throws Exception {
        List<AlunoTreino> alunosTreino = new ArrayList<>();
        AlunoTreino alunoTreino = this.repository.select(id);
        alunosTreino.add(alunoTreino);

        ApiRetorno<Boolean> response = new ApiRetorno<Boolean>();

        if (alunosTreino.get(0) == null) {  
            System.out.println("vazio");
            response.setMensagem("Aluno não foi encontrado");
            return new ResponseEntity<ApiRetorno<Boolean>>(response, HttpStatus.NOT_FOUND);
        }

        if (alunosTreino.get(0).isFinalizado()) {
            response.setSucess(false);
            response.setMensagem("Aluno não possui treinos ativos");
            return new ResponseEntity<ApiRetorno<Boolean>>(response, HttpStatus.NOT_FOUND);
        }

        boolean result = this.repository.finaliza(id);

        if (!result) {
            response.setSucess(false);
            response.setMensagem("Não foi possível finalizar o treino");
            return new ResponseEntity<ApiRetorno<Boolean>>(response, HttpStatus.NOT_MODIFIED);
        }

        response.setSucess(true);
        response.setMensagem("Treino diário Finalizado");
        return new ResponseEntity<ApiRetorno<Boolean>>(response, HttpStatus.OK);

    }
}
