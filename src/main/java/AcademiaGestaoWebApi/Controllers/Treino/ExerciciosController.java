package AcademiaGestaoWebApi.Controllers.Treino;

import AcademiaGestaoWebApi.Manager.Treinos.ExercicioManager;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import AcademiaGestaoWebApi.Models.Treinos.Exercicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matheusvieira
 */
@RestController
@Api(value = "Exercicios")
@RequestMapping("Api/Exercicio")
public class ExerciciosController {

    @GetMapping()
    @ApiOperation(value = "Retorna um ou mais exercicios")
    public ResponseEntity<ApiRetorno<List<Exercicio>>> getExercicio() {
        ExercicioManager manager = new ExercicioManager();
        ApiRetorno<List<Exercicio>> response = new ApiRetorno<>();

        try {

            List<Exercicio> exercicios = manager.selectExercicios();

            if (exercicios.isEmpty()) {
                response.setMensagem("Nenhum exercicio foi encontrado");
                return new ResponseEntity<ApiRetorno<List<Exercicio>>>(response, HttpStatus.NOT_FOUND);
            }

            response.setData(exercicios);
            response.setSucess(true);
            return new ResponseEntity<ApiRetorno<List<Exercicio>>>(response, HttpStatus.OK);

        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            return new ResponseEntity<ApiRetorno<List<Exercicio>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
