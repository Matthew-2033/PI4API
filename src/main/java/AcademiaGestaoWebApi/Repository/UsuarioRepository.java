package AcademiaGestaoWebApi.Repository;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class UsuarioRepository {
    
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
}
