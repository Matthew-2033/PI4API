package AcademiaGestaoWebApi.Controllers;

import AcademiaGestaoWebApi.Manager.MediaPorcentagemManager;
import AcademiaGestaoWebApi.Models.MediaPorcentagemGordura;
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
@Api("MediaPorcentagemDeGordura")
@RestController
@RequestMapping("Api/MediaPorcentagem")
public class MediaPorcentagemController {

    @ApiOperation("Retorna média de gordura por sexo")
    @GetMapping()
    public ResponseEntity<ApiRetorno<List<MediaPorcentagemGordura>>> selectMediaGorduraPorSexo() {
        ApiRetorno<List<MediaPorcentagemGordura>> response = new ApiRetorno<>();
        MediaPorcentagemManager manager = new MediaPorcentagemManager();

        try {

            List<MediaPorcentagemGordura> medias = manager.selectMedias();

            if (medias.isEmpty()) {
                response.setMensagem("Nenhum dado foi encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            response.setData(medias);
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
