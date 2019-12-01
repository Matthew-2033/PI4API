package AcademiaGestaoWebApi.Repository.Treino;

import AcademiaGestaoWebApi.Models.Treinos.Nivel;
import AcademiaGestaoWebApi.Repository.Repository;
import DataLib.AutoMapper.AutoMapper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheusvieira
 */
public class NivelRepository extends Repository<Nivel> {

    @Override
    public List<Nivel> select(Object param, Connection connection) throws Exception {
        CallableStatement stmt = null;
        ResultSet data = null;

        try {
            List<Nivel> niveis = new ArrayList<>();

            String query = "SELECT id_nivel id, nivel FROM treino.nivel";

            stmt = connection.prepareCall(query);
            data = stmt.executeQuery();

            AutoMapper mapper = new AutoMapper<>(new Nivel());
            niveis = mapper.map(data);

            return niveis;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }

    }

    @Override
    public boolean insert(Nivel object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Nivel object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
