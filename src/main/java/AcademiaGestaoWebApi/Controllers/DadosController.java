package AcademiaGestaoWebApi.Controllers;

import AcademiaGestaoWebApi.Manager.DadosManager;
import AcademiaGestaoWebApi.Models.Dados;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
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
@Api("Dados")
@RestController
@RequestMapping("Api/Dados")
public class DadosController {

    @ApiOperation("Retorna dados para o dashboard da empresa")
    @GetMapping
    public ResponseEntity<ApiRetorno<Dados>> selectDados() {
        ApiRetorno<Dados> response = new ApiRetorno<>();
        DadosManager manager = new DadosManager();

        try {

            Dados dados = manager.selectDados();

            response.setData(dados);
            response.setSucess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception ex) {
            List<String> errorMensagens = new ArrayList<>();
            errorMensagens.add(ex.getMessage());
            response.setErrorMessages(errorMensagens);
            response.setSucess(false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
