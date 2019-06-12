package AcademiaGestaoWebApi.Repository;

import AcademiaGestaoWebApi.Models.Avaliacao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import AcademiaGestaoWebApi.Models.AvaliacaoPerimetros;
import AcademiaGestaoWebApi.Models.PorcentagemDeGordura;
import DataLib.AutoMapper.AutoMapper;

public class AvaliacaoPorcentagemGorduraRepository extends Repository {

    @Override
    public List<PorcentagemDeGordura> select(Object idObject, Connection connection) throws Exception {

        UUID id = (UUID) idObject;
        CallableStatement stmt = null;
        ResultSet rs = null;

        List<PorcentagemDeGordura> porcentagemGorduras = new ArrayList<>();

        try {

            String query = "SELECT "
                    + "    id_avaliacao AS idAvaliacao"
                    + "   ,porcentagemGordura AS porcentagemDeGordura"
                    + "   ,case"
                    + "      when autor = 'POLLCK7D' then 1 "
                    + "      when autor = 'POLLOCK3D' then 2 "
                    + "      when autor = 'GUEDES' then 3 "
                    + "      when autor = 'PETROSKY' then 4 "
                    + "      when autor = 'THORLAND7D' then 5 "
                    + "      when autor = 'THORLAND3D' then 6 "
                    + "    end as autor "
                    + "FROM avaliacaoPorcentagemGordura "
                    + "WHERE id_avaliacao = ? ";

            stmt = connection.prepareCall(query);

            stmt.setString(1, id.toString());

            rs = stmt.executeQuery();

            AutoMapper<PorcentagemDeGordura> autoMapper = new AutoMapper<PorcentagemDeGordura>(new PorcentagemDeGordura());

            porcentagemGorduras = autoMapper.map(rs);
            return porcentagemGorduras;

        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    @Override
    public boolean insert(Object obejct, Connection connection) throws Exception {
        List<PorcentagemDeGordura> porcentagens = (ArrayList<PorcentagemDeGordura>) obejct;
        try {
            String query = "INSERT INTO avaliacaoPorcentagemGordura"
                    + "("
                    + "    id_avaliacaoPorcentagemGordura"
                    + "   ,id_avaliacao"
                    + "   ,porcentagemGordura"
                    + "   ,autor"
                    + ")"
                    + "VALUES(uuid(),?,?,?);";

            stmt = connection.prepareStatement(query);

            boolean sucesso = true;
            for (PorcentagemDeGordura porcentagem : porcentagens) {

                stmt.setString(1, porcentagem.getIdAvaliacao().toString());
                stmt.setDouble(2, porcentagem.getPorcentagemDeGordura());
                stmt.setString(3, porcentagem.getAutor().toString());

                int rows = stmt.executeUpdate();

                if (rows <= 0) {
                    sucesso = false;
                    break;
                }
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
