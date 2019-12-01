package AcademiaGestaoWebApi.Controllers.Treino;

import AcademiaGestaoWebApi.Manager.Treinos.NivelManager;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import AcademiaGestaoWebApi.Models.Treinos.Nivel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Nivel")
@RequestMapping("Api/Nivel")
public class NivelController {

    private final NivelManager manager;

    public NivelController() {
        manager = new NivelManager();
    }

    @GetMapping
    @ApiOperation(value = "Retorna um mais níveis")
    public ResponseEntity<ApiRetorno<List<Nivel>>> getNivel() {

        ApiRetorno<List<Nivel>> response = new ApiRetorno<>();

        try {

            List<Nivel> niveis = this.manager.selectNivel();

            if (niveis.isEmpty()) {
                response.setMensagem("Nenhum nível foi encontrado");
                return new ResponseEntity<ApiRetorno<List<Nivel>>>(response, HttpStatus.NOT_FOUND);
            }
            
            response.setSucess(true);
            response.setData(niveis);
            return new ResponseEntity<ApiRetorno<List<Nivel>>>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMessages = new ArrayList<>();
            errorMessages.add(ex.getMessage());
            response.setErrorMessages(errorMessages);
            response.setSucess(false);
            return new ResponseEntity<ApiRetorno<List<Nivel>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }
}
