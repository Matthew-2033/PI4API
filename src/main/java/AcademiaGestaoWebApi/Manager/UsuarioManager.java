package AcademiaGestaoWebApi.Manager;

import AcademiaGestaoWebApi.Repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioManager {
    
    public boolean atualizarSenha(String senha, String usuario) throws Exception {        
        String senhaEncrypt = new BCryptPasswordEncoder().encode(senha);
        UsuarioRepository repositori = new UsuarioRepository();
        try {
            Boolean result = repositori.atualizarSenha(senhaEncrypt, usuario);
            return result;
        } catch (Exception ex) {
            throw ex;
        } 
    }   
}