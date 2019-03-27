package AcademiaGestaoWebApi.Repository;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Enums.SexoEnum;
import AcademiaGestaoWebApi.Models.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class AlunoRepository  {
    
    private Connection con = null;

    public AlunoRepository() {
        con = ConnectionConfig.getConnection();
        
    }
    
    public List<Aluno> select() {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        
        try{
            
            String query = "SELECT "
                            + "avaliado_id AS ID,"
                            + "nome AS NOME,"
                            + "data_nascimento AS DATA_NASC,"
                            + "sexo AS SEXO,"
                            + "email AS EMAIL,"
                            + "CPF AS CPF,"
                            + "ativo AS ATIVO "
                        + "FROM Avaliado";
            
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Aluno aluno = new Aluno();
                
				aluno.setId(rs.getInt("ID"));
                aluno.setNome(rs.getString("NOME"));                
                aluno.setDataNascimento(rs.getString("DATA_NASC"));
                aluno.setSexo(SexoEnum.MASCULINO);
                aluno.setEmail(rs.getString("EMAIL"));
                aluno.setCpf(rs.getString("CPF"));
                aluno.setAtivo(rs.getBoolean("ATIVO"));                
                
                alunos.add(aluno);
            }   
                  
        }catch(SQLException error){
            error.printStackTrace();
        } finally{
            ConnectionConfig.closeConnection(con, stmt, rs);
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
            stmt.setString(2, aluno.getDataNascimento());            
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
