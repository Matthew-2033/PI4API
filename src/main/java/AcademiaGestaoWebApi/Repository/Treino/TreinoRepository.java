package AcademiaGestaoWebApi.Repository.Treino;

import AcademiaGestaoWebApi.Models.Treinos.Treino;
import AcademiaGestaoWebApi.Repository.Repository;
import DataLib.AutoMapper.AutoMapper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TreinoRepository extends Repository<Treino> {

    @Override
    public List<Treino> select(Object idObject, Connection connection) throws Exception {
        UUID id = (UUID) idObject;

        CallableStatement stmt = null;
        ResultSet data = null;

        List<Treino> treinos = new ArrayList<>();

        String query = "SELECT \n"
                + "	t.id_treino id,\n"
                + "	t.nome nome,\n"
                + "	n.nivel nivel,\n"
                + "	ta.repeticoes repeticoes,\n"
                + "	t.data_criacao dataCriacao,\n"
                + "	t.ativo ativo,\n"
                + "	to_json(ARRAY_AGG(ex))exercicios\n"
                + "FROM treino.aluno_treino ta\n"
                + "JOIN treino.treino t USING(id_treino)\n"
                + "JOIN treino.nivel n USING(id_nivel),\n"
                + "LATERAL ( \n"
                + "	SELECT \n"
                + "		e.nome exercicio, \n"
                + "		exercicios->>'vezes' vezes, \n"
                + "		exercicios->>'repeticoes' repeticoes,"
                + "             exercicios->>'carga' carga FROM jsonb_array_elements(ta.atributos->'exercicios') exercicios\n"
                + "		JOIN treino.exercicio e ON e.id_exercicio = cast(exercicios->>'id_exercicio' as UUID)\n"
                + "	) ex\n"
                + "WHERE ta.id_aluno = ? AND ta.ativo = TRUE\n"
                + "GROUP BY 1,2,3,4,5,6";

        stmt = connection.prepareCall(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        stmt.setObject(1, id);

        data = stmt.executeQuery();

        AutoMapper<Treino> mapper = new AutoMapper<Treino>(new Treino());
                
        treinos = mapper.map(data);
        
        while (data.previous()) {            
            UUID idTreino = UUID.fromString(data.getString("id"));            
            Treino treino = treinos.stream().filter(x -> x.getId().equals(idTreino)).findFirst().get();             
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
