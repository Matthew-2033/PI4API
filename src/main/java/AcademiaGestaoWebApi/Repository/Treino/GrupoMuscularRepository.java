/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcademiaGestaoWebApi.Repository.Treino;

import AcademiaGestaoWebApi.Models.Treinos.GrupoMuscular;
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
public class GrupoMuscularRepository extends Repository<GrupoMuscular> {

    @Override
    public List<GrupoMuscular> select(Object idObject, Connection connection) throws Exception {

        CallableStatement stmt = null;
        ResultSet data = null;

        List<GrupoMuscular> grupos = new ArrayList<>();

        try {
            String query = "SELECT id_grupo_muscular id, grupo_muscular grupoMuscular FROM treino.grupo_muscular;";

            stmt = connection.prepareCall(query);
            data = stmt.executeQuery();

            AutoMapper<GrupoMuscular> autoMapper = new AutoMapper<>(new GrupoMuscular());
            grupos = autoMapper.map(data);

            return grupos;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }

    }

    @Override
    public boolean insert(GrupoMuscular object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(GrupoMuscular object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
