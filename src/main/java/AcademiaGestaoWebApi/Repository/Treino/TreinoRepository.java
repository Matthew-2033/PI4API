package AcademiaGestaoWebApi.Repository.Treino;

import AcademiaGestaoWebApi.Models.Treinos.Treino;
import AcademiaGestaoWebApi.Repository.Repository;
import DataLib.AutoMapper.AutoMapper;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

public class TreinoRepository extends Repository<Treino> {

    @Override
    public List<Treino> select(Object idObject, Connection connection) throws Exception {
        
        List<Treino> treinos = new ArrayList<>();
        CallableStatement stmt = null;
        ResultSet data = null;

        String query = "SELECT * FROM treino.view_select_treino";        
                 
        stmt = connection.prepareCall(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                
        data = stmt.executeQuery();

        AutoMapper<Treino> mapper = new AutoMapper<Treino>(new Treino());
        treinos = mapper.map(data);
        
        while (data.previous()) {                    
            UUID idTreino = UUID.fromString(data.getString("idTreino"));                        
            
            Treino treino = treinos.stream().filter(
                x -> x.getIdTreino().equals(idTreino)
            ).findFirst().get();                        
            
            treino.setExercicios(data.getString("exercicios"));                        
        }

        return treinos;
    }

    @Override
    public boolean insert(Treino object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Treino object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
