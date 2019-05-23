package AcademiaGestaoWebApi.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Models.Avaliacao;
import DataLib.AutoMapper.AutoMapper;

public class AvaliacaoRepository extends Repository {

    @Override
    public List<Avaliacao> select(int id, Connection connection) throws Exception {

        CallableStatement stmt = null;
        ResultSet data = null;

        List<Avaliacao> avaliacoes = new ArrayList();

        try {
            String query = "{CALL SP_SELECT_AVALIACAO(?)}";

            stmt = connection.prepareCall(query);

            switch (id) {
                case 0:
                    stmt.setNull(1, Types.INTEGER, null);
                    break;
                default:
                    stmt.setInt(1, id);
                    break;
            }

            data = stmt.executeQuery();

            AutoMapper<Avaliacao> autoMapper = new AutoMapper<Avaliacao>(new Avaliacao());

            avaliacoes = autoMapper.map(data);
            return avaliacoes;
            
        } catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex);
        }
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