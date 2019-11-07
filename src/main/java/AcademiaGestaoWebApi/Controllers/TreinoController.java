package AcademiaGestaoWebApi.Controllers;

import AcademiaGestaoWebApi.Manager.Treinos.TreinoManager;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import AcademiaGestaoWebApi.Models.Treinos.Treino;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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

@Api(value = "Treino")
@RestController
@RequestMapping("Api/Treino")
public class TreinoController {
 
    @ApiOperation(value = "Retorna treino")
    @GetMapping()
    public ResponseEntity<ApiRetorno<List<Treino>>> getTreino(String id) {
        
        TreinoManager treinoManager = new TreinoManager();
        ApiRetorno<List<Treino>> response = new ApiRetorno<List<Treino>>();
        try { 
            
            UUID idGuid = new UUID(0,0);
            
            if (id != null && !id.isEmpty() ) {
                idGuid = UUID.fromString(id);
            }
            
            List<Treino> treinos = treinoManager.selectTreino(idGuid);
            
            if (treinos.isEmpty()) {
             response.setMensagem("Nenhum treino foi encontrado");
                return new ResponseEntity<ApiRetorno<List<Treino>>>(response, HttpStatus.NOT_FOUND);   
            }
            
            response.setData(treinos);
            response.setSucess(true);
            
            return new ResponseEntity<ApiRetorno<List<Treino>>>(response, HttpStatus.OK);
        } catch (Exception ex) {
            List<String> errorMensages = new ArrayList<String>();
            errorMensages.add(ex.getMessage());
            response.setErrorMessages(errorMensages);
            response.setSucess(false);
            return new ResponseEntity<ApiRetorno<List<Treino>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
