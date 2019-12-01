package AcademiaGestaoWebApi.Controllers.Treino;

import AcademiaGestaoWebApi.Manager.Treinos.AlunoTreinoManager;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import AcademiaGestaoWebApi.Models.Treinos.AlunoTreino;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "AlunoTreino")
@RestController
@RequestMapping("Api/AlunoTreino")
public class AlunoTreinoController {

    private final AlunoTreinoManager manager;

    public AlunoTreinoController() {
        this.manager = new AlunoTreinoManager();
    }

    @ApiOperation(value = "Retorna treino atrelado ao aluno")
    @GetMapping()
    public ResponseEntity<ApiRetorno<List<AlunoTreino>>> getAlunoTreino(String idAluno) {

        ApiRetorno<List<AlunoTreino>> response = new ApiRetorno<List<AlunoTreino>>();

        try {

            UUID idGuid = new UUID(0, 0);
            idGuid = UUID.fromString(idAluno);

            List<AlunoTreino> treinos = manager.selectTreinoAtrelado(idGuid);

            if (treinos.isEmpty()) {
                response.setMensagem("Nenhum treino encontrado");
                return new ResponseEntity<ApiRetorno<List<AlunoTreino>>>(response, HttpStatus.NOT_FOUND);
            }

            if (treinos.get(0).isFinalizado()) {
                response.setMensagem("Treino atual finalizado");
                return new ResponseEntity<ApiRetorno<List<AlunoTreino>>>(response, HttpStatus.NOT_FOUND);
            }

            response.setData(treinos);
            response.setSucess(true);
            return new ResponseEntity<ApiRetorno<List<AlunoTreino>>>(response, HttpStatus.OK);

        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            return new ResponseEntity<ApiRetorno<List<AlunoTreino>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PatchMapping(path = "/Finaliza/{idAluno}")
    @ApiOperation(value = "Finaliza treino diário do aluno")
    public ResponseEntity<ApiRetorno<Boolean>> finalizar(@PathVariable String idAluno) {
        ApiRetorno<Boolean> retorno = new ApiRetorno<Boolean>();

        try {
            return this.manager.finaliza(UUID.fromString(idAluno));

        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            retorno.setErrorMessages(errorMensages);
            retorno.setSucess(false);
            retorno.setData(false);
            return new ResponseEntity<ApiRetorno<Boolean>>(retorno, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
