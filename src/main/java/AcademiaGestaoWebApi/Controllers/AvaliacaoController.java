package AcademiaGestaoWebApi.Controllers;

import AcademiaGestaoWebApi.Manager.AlunoManager;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AcademiaGestaoWebApi.Manager.AvaliacaoManager;
import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.Models.Avaliacao;
import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import DTO.AvaliacaoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Api("Avaliação")
@RestController
@RequestMapping("Api/Avaliacao")
public class AvaliacaoController {

    @ApiOperation("Retorna uma lista de Avaliações")
    @GetMapping()
    public ResponseEntity<ApiRetorno<List<AvaliacaoDTO>>> selectAvaliacao(@RequestParam String id) {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        ApiRetorno<List<AvaliacaoDTO>> response = new ApiRetorno<List<AvaliacaoDTO>>();

        try {
            UUID idGuid = new UUID(0, 0);
            if (id != null && !id.isEmpty()) {
                idGuid = UUID.fromString(id);
            }

            List<AvaliacaoDTO> avaliacoes = avaliacaoManager.selectAvaliacao(idGuid);
            if (avaliacoes.isEmpty()) {
                response.setMensagem("Nenhuma avaliacao foi encontrada");
                return new ResponseEntity<ApiRetorno<List<AvaliacaoDTO>>>(response, HttpStatus.NOT_FOUND);
            }

            response.setData(avaliacoes);            
            response.setSucess(true);
            
            return new ResponseEntity<ApiRetorno<List<AvaliacaoDTO>>>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            return new ResponseEntity<ApiRetorno<List<AvaliacaoDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param avaliacao
     * @return
     */
    @ApiOperation("Inseri uma avaliação")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiRetorno<List<Boolean>>> insertAvaliacao(@RequestBody @Valid AvaliacaoRequest avaliacao) {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        ApiRetorno<List<Boolean>> response = new ApiRetorno<List<Boolean>>();

        try {
            ApiRetorno<Boolean> result = avaliacaoManager.insertAvaliacao(avaliacao);

            if (!result.isSucess()) {
                throw new Exception("Não foi possivel inserir a avaliação");
            }

            response.setMensagem("Avaliação inserida com sucesso");
            return new ResponseEntity<ApiRetorno<List<Boolean>>>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setMensagem("Não foi possivel inserir a avaliação");
            response.setSucess(false);
            return new ResponseEntity<ApiRetorno<List<Boolean>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
