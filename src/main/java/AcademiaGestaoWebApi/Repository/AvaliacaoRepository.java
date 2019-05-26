package AcademiaGestaoWebApi.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import AcademiaGestaoWebApi.Models.Avaliacao;
import DataLib.AutoMapper.AutoMapper;

public class AvaliacaoRepository extends Repository {

    @Override
    public List<Avaliacao> select(Object id, Connection connection) throws Exception {

        UUID guidId = (UUID) id;
        CallableStatement stmt = null;
        ResultSet data = null;

        List<Avaliacao> avaliacoes = new ArrayList();

        try {
            String query = "{CALL SP_SELECT_AVALIACAO(?)}";

            stmt = connection.prepareCall(query);

            switch (id.toString()) {
                case "00000000-0000-0000-0000-000000000000":
                    stmt.setNull(1, Types.INTEGER, null);
                    break;
                default:
                    stmt.setString(1, id.toString());
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
    public boolean insert(Object object, Connection connection) throws Exception {
        Avaliacao avaliacao = (Avaliacao) object;

        try {

            String query = "INSERT INTO aluno "
            +   "("
            +   ")"
            +   "VALUES ();";

            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            //Params
            //stmt.setString(1, aluno.getNome());

            stmt.executeUpdate(); 

        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public boolean update(Object object, Connection connection) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        return false;
    }
}