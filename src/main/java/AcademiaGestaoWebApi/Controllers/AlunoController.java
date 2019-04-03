package AcademiaGestaoWebApi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import AcademiaGestaoWebApi.Manager.AlunoManager;
import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.ResponseModels.ApiRetorno;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("Aluno")
public class AlunoController{

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
            return null;
        }                
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ApiRetorno<Boolean> putAluno(@RequestBody @Valid Aluno aluno) {
        AlunoManager alunoManager = new AlunoManager();
        ApiRetorno<Boolean> response = new ApiRetorno<Boolean>();

        try {
            Boolean result = alunoManager.updateAluno(aluno);    

            response.setSucess(result);
            response.setMensagem("Aluno atualizado com sucesso");
            return response;
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            return null;
        } 
    }

}