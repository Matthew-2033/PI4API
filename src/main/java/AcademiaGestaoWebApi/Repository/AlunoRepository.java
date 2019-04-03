package AcademiaGestaoWebApi.Repository;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Models.Aluno;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import DataLib.AutoMapper.*;

/**
 *
 * @author Matheus
 */
public class AlunoRepository  {

    PreparedStatement stmt = null;
        
    public List<Aluno> select() throws Exception {
        Connection connection = ConnectionConfig.getConnection();
        try {
            List<Aluno> alunos = select(connection);
            ConnectionConfig.closeConnection(connection, stmt);
            return alunos;
        } catch (Exception ex) {
            ConnectionConfig.closeConnection(connection, stmt);
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }
    
    public List<Aluno> select(Connection connection) throws Exception {        

        CallableStatement stmt = null;
        ResultSet data = null;
        
        List<Aluno> alunos = new ArrayList<>();
        
        try{
            
            String query = "{CALL SP_S_Avaliado(?)}";
            
            stmt = connection.prepareCall(query);
            
            stmt.setNull(1, Types.INTEGER, null); 
            data = stmt.executeQuery();
            
            AutoMapper<Aluno> autoMapper = new AutoMapper<Aluno>(new Aluno());

            alunos = autoMapper.map(data); 
         
            return alunos;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex);
        }                 
    }

    public boolean update(Aluno aluno) throws Exception {
        Connection connection = ConnectionConfig.getConnection();

        try {
            boolean update = update(aluno, connection);
            ConnectionConfig.closeConnection(connection, stmt);
            return update;
        } catch (Exception ex) {

            connection.rollback();
            ConnectionConfig.closeConnection(connection, stmt);
            ex.printStackTrace();            
            throw new Exception(ex);
        }
    }
     
    public boolean update(Aluno aluno, Connection connection) throws Exception {        
        try{

            String query = "UPDATE Avaliado SET "
                        + "nome = ?,"
                        + "data_nascimento = ?,"
                        + "sexo = ?,"
                        + "email = ?,"
                        + "CPF = ?,"
                        + "ativo = ? " 
                    + " WHERE avaliado_id = ?;";
            
            stmt = connection.prepareStatement(query);
            
            //Params
            stmt.setString(1, aluno.getNome());
            stmt.setDate(2, Date.valueOf(aluno.getDataNascimento()));            
            stmt.setInt(3, aluno.getSexo().getInt());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getCpf());
            stmt.setBoolean(6, aluno.getAtivo());
            stmt.setInt(7, aluno.getId());

            stmt.executeUpdate();         

            return true;
        }catch(Exception error){
            error.printStackTrace();
            throw new Exception(error);
        }
    } 

    public boolean delete(Aluno aluno) throws Exception {
        Connection connection = ConnectionConfig.getConnection();
        try {
            Boolean delete = delete(aluno, connection);
            ConnectionConfig.closeConnection(connection, stmt);
            return delete;
        } catch (Exception ex) {
            connection.rollback();
            ConnectionConfig.closeConnection(connection, stmt);
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }
    
    public boolean delete(Aluno aluno, Connection connection) throws Exception {
        
        boolean temConexao = true;
        if(connection == null){
            connection = ConnectionConfig.getConnection();
            temConexao = false;
        }
        
        PreparedStatement stmt = null;
        
        try{
            
            String query = "DELETE FROM Avaliado WHERE avaliado_id = ?"; 
            
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, aluno.getId());
            stmt.execute();
            
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
