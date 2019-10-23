package AcademiaGestaoWebApi.Manager;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.Models.Usuario;
import AcademiaGestaoWebApi.Repository.UsuarioRepository;
import java.sql.Connection;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioManager {
    
    private final Connection connection;
    private final AlunoManager alunoManager;

    public UsuarioManager() {
        connection = ConnectionConfig.getConnection(false);
        alunoManager = new AlunoManager();
    }        

    public Usuario obterUsuario(String userName) throws Exception {
        UsuarioRepository repositori = new UsuarioRepository();
        try {
            Usuario usuario = repositori.obterUsuario(userName, connection);
            
            if (usuario == null || usuario.getIdAluno() == null){
                connection.commit();
                ConnectionConfig.closeConnection(connection);
                return usuario;
            }
            
            List<Aluno> alunos = alunoManager.selectAlunos(usuario.getIdAluno());
            Aluno aluno = alunos.stream().findFirst().get();
            
            usuario.setAluno(aluno);
            
            connection.commit();
            ConnectionConfig.closeConnection(connection);
            return usuario;
        } catch (Exception ex) {
            connection.rollback();
            ConnectionConfig.closeConnection(connection);
            throw ex;
        }
    }

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
