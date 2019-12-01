package AcademiaGestaoWebApi.Controllers.Treino;

import AcademiaGestaoWebApi.Manager.Treinos.GrupoMuscularManager;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import AcademiaGestaoWebApi.Models.Treinos.GrupoMuscular;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matheusvieira
 */
@Api("Grupo Muscular")
@RestController
@RequestMapping("Api/GrupoMuscular")
public class GrupoMuscularController {

    @ApiOperation(value = "Retorna um ou mais Grupos Musculares")
    @GetMapping()
    public ResponseEntity<ApiRetorno<List<GrupoMuscular>>> getGruposMusculares() {

        GrupoMuscularManager manager = new GrupoMuscularManager();
        ApiRetorno<List<GrupoMuscular>> response = new ApiRetorno<>();

        try {
            List<GrupoMuscular> gruposMusculares = manager.selectGrupoMuscular();

            if (gruposMusculares.isEmpty()) {
                response.setMensagem("Nenhum Gruop Muscular foi encontrado");
                return new ResponseEntity<ApiRetorno<List<GrupoMuscular>>>(response, HttpStatus.NOT_FOUND);
            }

            response.setSucess(true);
            response.setData(gruposMusculares);
            return new ResponseEntity<ApiRetorno<List<GrupoMuscular>>>(response, HttpStatus.OK);

        } catch (Exception ex) {
            List<String> errorMessages = new ArrayList<>();
            errorMessages.add(ex.getMessage());
            response.setErrorMessages(errorMessages);
            response.setSucess(false);
            return new ResponseEntity<ApiRetorno<List<GrupoMuscular>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
