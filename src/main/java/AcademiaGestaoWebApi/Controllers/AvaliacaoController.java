package AcademiaGestaoWebApi.Controllers;

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
import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import DTO.AvaliacaoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api("Avaliação")
@RestController
@RequestMapping("Api/Avaliacao")
public class AvaliacaoController {
   

    @ApiOperation("Retorna uma lista de Avaliações")
    @GetMapping()
    public ResponseEntity<ApiRetorno<List<AvaliacaoDTO>>> selectAvaliacao(@RequestParam String id) {
        ApiRetorno<List<AvaliacaoDTO>> response = new ApiRetorno<>();
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

        try {
            UUID idGuid = new UUID(0, 0);
            if (id != null && !id.isEmpty()) {
                idGuid = UUID.fromString(id);
            }

            List<AvaliacaoDTO> avaliacoes = avaliacaoManager.selectAvaliacao(idGuid);
            if (avaliacoes.isEmpty()) {
                response.setMensagem("Nenhuma avaliacao foi encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
                        
            response.setData(avaliacoes);            
            response.setSucess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param avaliacao
     * @return
     */
    @ApiOperation("Inseri uma avaliação")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiRetorno<Boolean>> insertAvaliacao(@RequestBody @Valid AvaliacaoRequest avaliacao) {
        ApiRetorno<Boolean> response = new ApiRetorno<>();
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

        try {
            response = avaliacaoManager.insertAvaliacao(avaliacao);

            if (!response.isSucess()) {
                throw new Exception("Não foi possivel inserir a avaliação");
            }
            
            response.setMensagem("Avaliação inserida com sucesso");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setMensagem("Não foi possivel inserir a avaliação");
            response.setSucess(false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation("Altera uma avaliação")
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiRetorno<Boolean>> updateAvaliacao(@RequestBody @Valid AvaliacaoRequest avaliacao) {
        ApiRetorno<Boolean> response = new ApiRetorno<>();
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

        try {
            response = avaliacaoManager.updateAvaliacao(avaliacao);

            if (!response.isSucess()) {
                throw new Exception("Não foi possivel atualizar a avaliação");
            }

            response.setMensagem("Avaliação atualizada com sucesso");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setMensagem("Não foi possivel atualizar a avaliação");
            response.setSucess(false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation("Deleta uma avaliação")
    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiRetorno<Boolean>>  deleteAvaliacao(@RequestParam @Valid String idAvaliacao) {
        ApiRetorno<Boolean> response = new ApiRetorno<>();
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

        try {
            response = avaliacaoManager.deleteAvaliacao(idAvaliacao);

            if (!response.isSucess()) {
                throw new Exception("Não foi possivel deletar a avaliação");
            }

            response.setMensagem("Avaliação deletada com sucesso");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setMensagem("Não foi possivel deletar a avaliação");
            response.setSucess(false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
