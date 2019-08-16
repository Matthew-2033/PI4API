package AcademiaGestaoWebApi.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import AcademiaGestaoWebApi.Models.Avaliacao;
import DTO.AvaliacaoDTO;
import DataLib.AutoMapper.AutoMapper;

public class AvaliacaoRepository extends Repository {

    @Override
    public List<AvaliacaoDTO> select(Object id, Connection connection) throws Exception {

        UUID guidId = (UUID) id;
        CallableStatement stmt = null;
        ResultSet data = null;

        List<AvaliacaoDTO> avaliacoes = new ArrayList();

        try {

            String query = "SELECT * FROM view_s_avaliacao";
            String query2 = "SELECT * FROM view_s_avaliacao WHERE id = ?";
            

            switch (id.toString()) {
                case "00000000-0000-0000-0000-000000000000":
                    stmt = connection.prepareCall(query);
                    break;
                default:
                    stmt = connection.prepareCall(query2);
                    stmt.setString(1, id.toString());
                    break;
            }

            data = stmt.executeQuery();

            AutoMapper<AvaliacaoDTO> autoMapper = new AutoMapper<AvaliacaoDTO>(new AvaliacaoDTO());

            avaliacoes = autoMapper.map(data);
            return avaliacoes;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean insert(Object object, Connection connection) throws Exception {
        Avaliacao avaliacao = (Avaliacao) object;
        try {

            String query = "INSERT INTO avaliacao.avaliacao"
                    + "("
                    + "    ,id_aluno"
                    + "    ,massa"
                    + "    ,estatura"
                    + "    ,imc"
                    + "    ,pccg"
                    + "    ,massa_de_gordura"
                    + "    ,massa_magra"
                    + "    ,peso_ideal"
                    + "    ,peso_em_excesso  "
                    + ")"
                    + "VALUES(?,?,?,?,?,?,?,?,?);";

            stmt = connection.prepareStatement(query);

            //Params
            stmt.setString(1, avaliacao.getID().toString());
            stmt.setString(2, avaliacao.getIdAluno().toString());
            stmt.setDouble(3, avaliacao.getMassa());
            stmt.setDouble(4, avaliacao.getEstatura());
            stmt.setDouble(5, avaliacao.getImc());
            stmt.setDouble(6, avaliacao.getPccg());
            stmt.setDouble(7, avaliacao.getMassaDeGordura());
            stmt.setDouble(8, avaliacao.getMassaMagra());
            stmt.setDouble(9, avaliacao.getPesoIdeal());
            stmt.setDouble(10, avaliacao.getPesoEmExcesso());

            int rows = stmt.executeUpdate();

            boolean sucesso = true;
            if (rows <= 0) {
                return false;
            }

            return sucesso;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public boolean update(Object object, Connection connection) throws Exception {
        Avaliacao avaliacao = (Avaliacao) object;
        try {

            String query = ""
                    + "UPDATE avaliacao.avaliacao SET " 
                    +"	    massa = ? " 
                    +"    , estatura = ? " 
                    +"    , imc = ? " 
                    +"    , pccg = ? " 
                    +"    , massa_de_gordura = ? " 
                    +"    , massa_magra = ? " 
                    +"    , peso_ideal = ? " 
                    +"    , peso_em_excesso = ? " 
                    +"WHERE id_avaliacao = ?;";

            stmt = connection.prepareStatement(query);

            //Params
            stmt.setDouble(1, avaliacao.getMassa());
            stmt.setDouble(2, avaliacao.getEstatura());
            stmt.setDouble(3, avaliacao.getImc());
            stmt.setDouble(4, avaliacao.getPccg());
            stmt.setDouble(5, avaliacao.getMassaDeGordura());
            stmt.setDouble(6, avaliacao.getMassaMagra());
            stmt.setDouble(7, avaliacao.getPesoIdeal());
            stmt.setDouble(8, avaliacao.getPesoEmExcesso());
            stmt.setString(9, avaliacao.getID().toString());

            int rows = stmt.executeUpdate();

            boolean sucesso = true;
            if (rows <= 0) {
                return false;
            }

            return sucesso;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        UUID idAvaliacao = (UUID) id;
        try {

            String query = "DELETE FROM avaliacao.avaliacao WHERE id_avaliacao = ?;";

            stmt = connection.prepareStatement(query);
            stmt.setString(1, idAvaliacao.toString());

            int rows = stmt.executeUpdate();

            boolean sucesso = true;
            if (rows <= 0) {
                return false;
            }

            return sucesso;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
