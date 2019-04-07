package AcademiaGestaoWebApi.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AcademiaGestaoWebApi.Manager.AvaliacaoManager;
import AcademiaGestaoWebApi.Models.Avaliacao;
import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Avaliação")
@RestController
@RequestMapping("Api/Avaliacao")
public class AvaliacaoController{

    @ApiOperation("Retorna uma lista de Avaliações")
    @GetMapping()
    public ApiRetorno<List<Avaliacao>> selectAvaliacao() {
        return new ApiRetorno<List<Avaliacao>>();
    }

    @ApiOperation("Inseri uma avaliação")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ApiRetorno<List<Boolean>> insertAvaliacao(@RequestBody @Valid AvaliacaoRequest avaliacao) {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        ApiRetorno<List<Boolean>> response = new ApiRetorno<List<Boolean>>();

        try {
            Boolean result = avaliacaoManager.insertAvaliacao(avaliacao);    

            if(!result){
                throw new Exception("Não foi possivel inserir a avaliação");
            }

            response.setSucess(result);
            response.setMensagem("Avaliação inserida com sucesso");
            return response;
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setMensagem("Não foi possivel inserir a avaliação");
            response.setSucess(false);
            return response;
        } 
    }
}