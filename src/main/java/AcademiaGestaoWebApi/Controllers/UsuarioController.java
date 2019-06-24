package AcademiaGestaoWebApi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import AcademiaGestaoWebApi.Manager.AlunoManager;
import AcademiaGestaoWebApi.Manager.UsuarioManager;
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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "Usuario")
@RestController
@RequestMapping("Api/Usuario")
public class UsuarioController {
    
    @ApiOperation(value = "Atualiza senha")
    @PatchMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiRetorno<Boolean>> atualizarAluno(@RequestHeader String novaSenha, @RequestHeader String usuario) {
        UsuarioManager usuarioManager = new UsuarioManager();
        ApiRetorno<Boolean> response = new ApiRetorno<Boolean>();

        try {
            Boolean result = usuarioManager.atualizarSenha(novaSenha, usuario);
            
            if (!result) {
                response.setMensagem("Erro ao alterar senha");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            response.setData(result);
            response.setSucess(true);
            response.setMensagem("Senha alterada com sucesso");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
          
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            response.setData(false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
