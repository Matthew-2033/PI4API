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
    
    private Connection con = null;

    public AlunoRepository() {
        con = ConnectionConfig.getConnection();
        
    }
    
    public List<Aluno> select() throws InstantiationException, IllegalAccessException, NoSuchFieldException,
            SecurityException, IllegalArgumentException {
        
        CallableStatement stmt = null;
        ResultSet data = null;
        
        List<Aluno> alunos = new ArrayList<>();
        
        try{
            
            String query = "{CALL SP_S_Avaliado(?)}";
            
            stmt = con.prepareCall(query);
            
            stmt.setNull(1, Types.INTEGER, null); 
            data = stmt.executeQuery();
            
            AutoMapper<Aluno> autoMapper = new AutoMapper<Aluno>(new Aluno());

            alunos = autoMapper.map(data); 
                  
        }catch(SQLException error){
            error.printStackTrace();
        } finally{
            ConnectionConfig.closeConnection(con, stmt, data);
        }
        
        return alunos;
    }
     
    public boolean update(Aluno aluno){

        con = ConnectionConfig.getConnection();
        PreparedStatement stmt = null;
        
        try{

            String query = "UPDATE Avaliado SET "
                        + "nome = ?,"
                        + "data_nascimento = ?,"
                        + "sexo = ?,"
                        + "email = ?,"
                        + "CPF = ?,"
                        + "ativo = ? " 
                    + " WHERE avaliado_id = ?";
            
            stmt = con.prepareStatement(query);
            
            //Params
            stmt.setString(1, aluno.getNome());
            stmt.setDate(2, Date.valueOf(aluno.getDataNascimento()));            
            stmt.setInt(3, aluno.getSexo().getInt());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getCpf());
            stmt.setInt(6, aluno.getId());
            stmt.setBoolean(7, aluno.getAtivo());

            stmt.executeUpdate();         
            return true;

        }catch(Exception error){
            error.printStackTrace();
            return false;

        }finally{
            ConnectionConfig.closeConnection(con, stmt);
        }
    } 
    
    public boolean delete(Aluno aluno){
        
        PreparedStatement stmt = null;
        
        try{
            
            String query = "DELETE FROM Avaliado WHERE avaliado_id = ?"; 
            
            stmt = con.prepareStatement(query);
            stmt.setInt(1, aluno.getId());
            stmt.execute();
            
            return true;

        }catch(SQLException error){
            error.printStackTrace();
            return false;
        }finally{
            ConnectionConfig.closeConnection(con, stmt);
        }
    }
}
