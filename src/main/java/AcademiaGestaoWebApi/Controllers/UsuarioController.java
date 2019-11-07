package AcademiaGestaoWebApi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import AcademiaGestaoWebApi.Manager.UsuarioManager;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import AcademiaGestaoWebApi.Models.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "Usuario")
@RestController
@RequestMapping("Api/Usuario")
public class UsuarioController {
    
    @ApiOperation(value = "Obtem usuário")
    @GetMapping()
    public ResponseEntity<ApiRetorno<Usuario>> obterUsuario(@RequestParam String userName){
        UsuarioManager usuarioManager = new UsuarioManager();
        ApiRetorno<Usuario> response = new ApiRetorno<Usuario>();

        if (userName == null || userName.isEmpty()){
            response.setMensagem("UserName é obrigatório.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        
        try {
            Usuario usuario = usuarioManager.obterUsuario(userName);
            if (usuario == null){
                response.setMensagem("Usuario não encontrado.");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            
            response.setData(usuario);            
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