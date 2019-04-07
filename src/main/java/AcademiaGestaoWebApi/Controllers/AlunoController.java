package AcademiaGestaoWebApi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import AcademiaGestaoWebApi.Manager.AlunoManager;
import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.ResponseModels.ApiRetorno;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "Alunos")
@RestController
@RequestMapping("Api/Aluno")
public class AlunoController{

    @ApiOperation(value = "Retorna um ou mais alunos")
    @GetMapping()
    public ApiRetorno<List<Aluno>> getAluno() {
        AlunoManager alunoManager = new AlunoManager();
        ApiRetorno<List<Aluno>> response = new ApiRetorno<List<Aluno>>();

        try {
            List<Aluno> alunos = alunoManager.selectAlunos();    

            response.setData(alunos);
            response.setSucess(true);
            return response;
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            return response;
        }                
    }

    @ApiOperation(value = "Inseri um aluno")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ApiRetorno<Boolean> postAluno(@RequestBody @Valid Aluno aluno) {
        AlunoManager alunoManager = new AlunoManager();
        ApiRetorno<Boolean> response = new ApiRetorno<Boolean>();

        try {
            Boolean result = alunoManager.insertAluno(aluno);    

            if(!result){
                throw new Exception("Não foi possivel inserir o Aluno");
            }

            response.setSucess(result);
            response.setMensagem("Aluno inserido com sucesso");
            return response;
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setMensagem("Não foi possivel inserir o aluno");
            response.setSucess(false);
            return response;
        } 
    }

    @ApiOperation(value = "Atualiza as informações de um aluno")
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ApiRetorno<Boolean> putAluno(@RequestBody @Valid Aluno aluno) {
        AlunoManager alunoManager = new AlunoManager();
        ApiRetorno<Boolean> response = new ApiRetorno<Boolean>();

        try {
            Boolean result = alunoManager.updateAluno(aluno);    
            
            if(!result){
                throw new Exception("Não foi possivel atualizar o Aluno");
            }

            response.setSucess(result);
            response.setMensagem("Aluno atualizado com sucesso");
            return response;
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setMensagem("Não foi possivel atualizar o aluno");
            response.setSucess(false);
            return response;
        } 
    }

    @ApiOperation(value = "Deleta um aluno")
    @DeleteMapping()
    public ApiRetorno<Boolean> deleteAluno(@RequestParam @Valid int idAluno) {
        AlunoManager alunoManager = new AlunoManager();
        ApiRetorno<Boolean> response = new ApiRetorno<Boolean>();

        try {
            Boolean result = alunoManager.deleteAluno(idAluno);    

            response.setData(result);
            response.setSucess(true);
            return response;
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            response.setData(false);
            return response;
        }                
    }
}