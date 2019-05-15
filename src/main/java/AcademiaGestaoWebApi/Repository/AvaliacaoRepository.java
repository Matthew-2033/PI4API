package AcademiaGestaoWebApi.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Models.Avaliacao;

public class AvaliacaoRepository extends Repository {

    @Override
    public List<Avaliacao> select(int id, Connection connection) throws Exception {
        return null;
    }

    @Override
    public int insert(Object object, Connection connection) throws Exception {
        return 0;
    }

    @Override
    public boolean update(Object object, Connection connection) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int id, Connection connection) throws Exception {
        return false;
    }
}