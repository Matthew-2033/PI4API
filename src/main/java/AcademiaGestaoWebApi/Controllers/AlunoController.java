package AcademiaGestaoWebApi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import AcademiaGestaoWebApi.Manager.AlunoManager;
import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "Alunos")
@RestController
@RequestMapping("Api/Aluno")
public class AlunoController {

    @ApiOperation(value = "Retorna um ou mais alunos")
    @GetMapping()
    public ResponseEntity<ApiRetorno<List<Aluno>>> getAluno(String id) {
        AlunoManager alunoManager = new AlunoManager();
        ApiRetorno<List<Aluno>> response = new ApiRetorno<List<Aluno>>();

        try {
            UUID idGuid = new UUID(0, 0);
            if (id != null && !id.isEmpty()) {
                idGuid = UUID.fromString(id);
            }

            List<Aluno> alunos = alunoManager.selectAlunos(idGuid);
            if (alunos.isEmpty()) {
                response.setMensagem("Nenhum aluno foi encontrado");
                return new ResponseEntity<ApiRetorno<List<Aluno>>>(response, HttpStatus.NOT_FOUND);
            }

            response.setData(alunos);
            response.setSucess(true);
            return new ResponseEntity<ApiRetorno<List<Aluno>>>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            return new ResponseEntity<ApiRetorno<List<Aluno>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Inseri um aluno")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiRetorno<Boolean>> postAluno(@RequestBody @Valid Aluno aluno) {
        AlunoManager alunoManager = new AlunoManager();
        ApiRetorno<Boolean> response = new ApiRetorno<Boolean>();

        try {
            Boolean result = alunoManager.insertAluno(aluno);

            if (!result) {
                throw new Exception("Não foi possivel inserir o Aluno");
            }

            response.setSucess(result);
            response.setMensagem("Aluno inserido com sucesso");
            return new ResponseEntity<ApiRetorno<Boolean>>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setMensagem("Não foi possivel inserir o aluno");
            response.setSucess(false);
            return new ResponseEntity<ApiRetorno<Boolean>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Atualiza as informações de um aluno")
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ApiRetorno<Boolean> putAluno(@RequestBody @Valid Aluno aluno) {
        AlunoManager alunoManager = new AlunoManager();
        ApiRetorno<Boolean> response = new ApiRetorno<Boolean>();

        try {
            Boolean result = alunoManager.updateAluno(aluno);

            if (!result) {
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
    @DeleteMapping(path = "/{id}")
    public ApiRetorno<Boolean> deleteAluno(@PathVariable String id) {
        AlunoManager alunoManager = new AlunoManager();
        ApiRetorno<Boolean> response = new ApiRetorno<Boolean>();

        try {
            UUID idGuid = UUID.fromString(id);
            System.out.println("GUID:" + idGuid);
            Boolean result = alunoManager.deleteAluno(idGuid);

            response.setData(result);
            response.setSucess(true);
            response.setMensagem("aluno removido com sucesso");
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
