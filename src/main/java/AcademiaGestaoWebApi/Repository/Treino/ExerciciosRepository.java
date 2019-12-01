package AcademiaGestaoWebApi.Repository.Treino;

import AcademiaGestaoWebApi.Models.Treinos.Exercicio;
import AcademiaGestaoWebApi.Repository.Repository;
import DataLib.AutoMapper.AutoMapper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExerciciosRepository extends Repository<Exercicio> {

    @Override
    public List<Exercicio> select(Object idObject, Connection connection) throws Exception {

        CallableStatement stmt = null;
        ResultSet data = null;

        List<Exercicio> exercicios = new ArrayList<>();

        try {
            String query = "SELECT \n"
                    + "id_exercicio id, \n"
                    + "ex.nome, \n"
                    + "media mediaUrl, \n"
                    + "ex.data_criacao dataCriacao, \n"
                    + "ex.ativo ativo, \n"
                    + "to_json(ARRAY_AGG(gm)) gruposMusculares\n"
                    + "FROM treino.grupo_muscular_exercicio gme\n"
                    + "JOIN treino.exercicio ex USING(id_exercicio),\n"
                    + "LATERAL (\n"
                    + "	SELECT id_grupo_muscular, grupo_muscular FROM treino.grupo_muscular WHERE id_grupo_muscular = gme.id_grupo_muscular\n"
                    + ") gm\n"
                    + "GROUP BY id_exercicio, ex.nome, mediaUrl, dataCriacao, ativo";

            stmt = connection.prepareCall(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            data = stmt.executeQuery();

            AutoMapper mapper = new AutoMapper<>(new Exercicio());
            exercicios = mapper.map(data);

            while (data.previous()) {
                UUID idTreino = UUID.fromString(data.getString("id"));
                Exercicio exercicio = exercicios.stream().filter(x -> x.getId().equals(idTreino)).findFirst().get();
                exercicio.setGruposMusculares(data.getString("gruposMusculares"));
            }

            return exercicios;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }

    @Override
    public boolean insert(Exercicio object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Exercicio object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
