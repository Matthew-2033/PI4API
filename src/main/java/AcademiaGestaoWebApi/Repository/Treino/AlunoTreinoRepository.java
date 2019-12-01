/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcademiaGestaoWebApi.Repository.Treino;

import AcademiaGestaoWebApi.Models.Treinos.AlunoTreino;
import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Repository.Repository;
import DataLib.AutoMapper.AutoMapper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author matheusvieira
 */
public class AlunoTreinoRepository extends Repository<AlunoTreino> {

    @Override
    public List<AlunoTreino> select(Object idObject, Connection connection) throws Exception {
        UUID id = (UUID) idObject;
        CallableStatement stmt = null;
        ResultSet data = null;

        List<AlunoTreino> alunoTreinos = new ArrayList<>();

        try {

            String query = "SELECT * FROM treino.view_select_treino_atrelado WHERE idAluno = ?";

            stmt = connection.prepareCall(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setObject(1, id);

            data = stmt.executeQuery();

            AutoMapper<AlunoTreino> autoMapper = new AutoMapper<AlunoTreino>(new AlunoTreino());

            alunoTreinos = autoMapper.map(data);

            while (data.previous()) {
                UUID idTreino = UUID.fromString(data.getString("idTreino"));
                AlunoTreino treino = alunoTreinos.stream().filter(x -> x.getId().equals(idTreino)).findFirst().get();
                treino.setExercicios(data.getString("exercicios"));
            }

            return alunoTreinos;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }

    @Override
    public boolean insert(AlunoTreino object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(AlunoTreino object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean finaliza(UUID id) throws Exception {

        try {
            ResultSet data = null;
            boolean result = false;
            CallableStatement stmt = null;
            Connection connection = ConnectionConfig.getConnection(true);

            String query = "SELECT treino.treino_finaliza(?) AS finalizado";

            stmt = connection.prepareCall(query);
            stmt.setObject(1, id);

            data = stmt.executeQuery();
            data.next();

            result = data.getBoolean("finalizado");
            return result;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }
}
