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

            String query = "CALL SP_S_Avaliacao(?)";
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

            String query = "INSERT INTO avaliacao"
                    + "("
                    + "     id_avaliacao"
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
                    + "VALUES(?,?,?,?,?,?,?,?,?,?);";

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
        return false;
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        return false;
    }
}
