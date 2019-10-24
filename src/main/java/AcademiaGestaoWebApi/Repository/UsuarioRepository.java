package AcademiaGestaoWebApi.Repository;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Models.AvaliacaoDobras;
import AcademiaGestaoWebApi.Models.Usuario;
import DataLib.AutoMapper.AutoMapper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsuarioRepository extends Repository<Usuario> {
    
    public Usuario obterUsuario(String userName, Connection connection) throws Exception{        
        List<Usuario> usuarios = select(userName, connection);
        
        Usuario usuario = usuarios.stream().findFirst().get();
        return usuario;
    }
    
    public boolean atualizarSenha(String novaSenha, String usuario) throws Exception {
        Connection connection = ConnectionConfig.getConnection(false);
        boolean temConexao = true;
        if(connection == null){
            connection = ConnectionConfig.getConnection(false);
            temConexao = false;
        }
        
        PreparedStatement stmt = null;
        
        try{
            
            String query = "UPDATE User SET Password = ? WHERE Username = ?"; 
            
            stmt = connection.prepareStatement(query);
            stmt.setString(1, novaSenha);
            stmt.setString(2, usuario);
            stmt.execute();    
            connection.commit();
            ConnectionConfig.closeConnection(connection, stmt);
            return true;
        }catch(SQLException error){
            if(!temConexao){
                connection.rollback();
                ConnectionConfig.closeConnection(connection, stmt);
            }

            error.printStackTrace();
            throw new Exception(error);
        }
    } 

    @Override
    public List<Usuario> select(Object param, Connection connection) throws Exception {
        
        String userName = (String) param;
        CallableStatement stmt;
        ResultSet data;

        List<Usuario> usuarios = new ArrayList<>();

        try {

            String query = "SELECT "
                                +" us.ID_usuario AS id"
                                +" ,us.id_aluno AS idAluno"
                                +" ,us.Username AS userName"
                                +" ,us.Senha_Redefinida AS senhaRedefinida"
                                +" ,us.ultimo_acesso AS ultimoAcesso"
                                +" ,us.data_criacao AS dataDeCriacao"
                                +" ,ro.Role AS role"
                            +" FROM acesso.usuario us"
                            +" JOIN aluno.aluno al ON al.nome = us.username"
                            +" JOIN acesso.usuario_role USING(id_usuario)"
                            +" JOIN acesso.role ro USING(id_role)"
                            +" WHERE us.username = ?;";

            stmt = connection.prepareCall(query);

            stmt.setObject(1, userName);

            data = stmt.executeQuery();

            AutoMapper<Usuario> autoMapper = new AutoMapper<Usuario>(new Usuario());

            usuarios = autoMapper.map(data);

            return usuarios;

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public boolean insert(Usuario object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Usuario object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
