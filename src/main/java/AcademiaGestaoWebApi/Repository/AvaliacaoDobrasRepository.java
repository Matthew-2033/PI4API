package AcademiaGestaoWebApi.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import AcademiaGestaoWebApi.Models.AvaliacaoDobras;
import DataLib.AutoMapper.AutoMapper;

public class AvaliacaoDobrasRepository extends Repository {

    @Override
    public List select(Object idObject, Connection connection) throws Exception {

        UUID id = (UUID) idObject;
        CallableStatement stmt = null;
        ResultSet data = null;

        List<AvaliacaoDobras> dobras = new ArrayList<>();

        try {

            String query = "SELECT"
                    + "     id_dobras AS id"
                    + "    ,id_avaliacao AS idAvaliacao"
                    + "    ,peitoral AS peitoral"
                    + "    ,auxiliar_media AS mediaAuxiliar"
                    + "    ,sub_escapular AS subEscapular"
                    + "    ,tricipital AS tricipital"
                    + "    ,biciptal AS biciptal"
                    + "    ,supra_iliaca AS supraIliaca"
                    + "    ,abdominal AS abdominalDobra"
                    + "    ,coxa AS coxa"
                    + "    ,panturrilha AS panturrilha"
                    + "FROM avaliacao.dobras "
                    + " WHERE idAvaliacao = ?";

            stmt = connection.prepareCall(query);

            stmt.setObject(1, id);

            data = stmt.executeQuery();

            AutoMapper<AvaliacaoDobras> autoMapper = new AutoMapper<AvaliacaoDobras>(new AvaliacaoDobras());

            dobras = autoMapper.map(data);

            return dobras;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }

    @Override
    public boolean insert(Object object, Connection connection) throws Exception {
        AvaliacaoDobras dobras = (AvaliacaoDobras) object;
        try {
            String query = "INSERT INTO avaliacao.dobras"
                    + "("
                    + "     id_avaliacao"
                    + "    ,peitoral"
                    + "    ,auxiliar_media"
                    + "    ,sub_escapular"
                    + "    ,tricipital"
                    + "    ,biciptal"
                    + "    ,supra_iliaca"
                    + "    ,abdominal"
                    + "    ,coxa"
                    + "    ,panturrilha"
                    + ")"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?);";

            stmt = connection.prepareStatement(query);

            stmt.setObject(1, dobras.getIdAvaliacao());
            stmt.setDouble(2, dobras.getPeitoral());
            stmt.setDouble(3, dobras.getMediaAuxiliar());
            stmt.setDouble(4, dobras.getSubEscapular());
            stmt.setDouble(5, dobras.getTricipital());
            stmt.setDouble(6, dobras.getBiciptal());
            stmt.setDouble(7, dobras.getSupraIliaca());
            stmt.setDouble(8, dobras.getAbdominalDobra());
            stmt.setDouble(9, dobras.getCoxa());
            stmt.setDouble(10, dobras.getPanturrilha());
            System.out.println(stmt);
            int rows = stmt.executeUpdate();

            boolean sucesso = false;
            if (rows > 0) {
                sucesso = true;
            }

            return sucesso;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public boolean update(Object object, Connection connection) throws Exception {
        AvaliacaoDobras dobras = (AvaliacaoDobras) object;
        try {
            String query = "UPDATE avaliacao.dobras SET "
                    + "	  peitoral = ? "
                    + "	 ,auxiliar_media = ? "
                    + "	 ,sub_escapular = ? "
                    + "	 ,tricipital = ? "
                    + "	 ,biciptal = ? "
                    + "	 ,supra_iliaca = ? "
                    + "	 ,abdominal = ? "
                    + "	 ,coxa = ? "
                    + "	 ,panturrilha = ? "
                    + "WHERE id_avaliacao = ?;";

            stmt = connection.prepareStatement(query);

            stmt.setDouble(1, dobras.getPeitoral());
            stmt.setDouble(2, dobras.getMediaAuxiliar());
            stmt.setDouble(3, dobras.getSubEscapular());
            stmt.setDouble(4, dobras.getTricipital());
            stmt.setDouble(5, dobras.getBiciptal());
            stmt.setDouble(6, dobras.getSupraIliaca());
            stmt.setDouble(7, dobras.getAbdominalDobra());
            stmt.setDouble(8, dobras.getCoxa());
            stmt.setDouble(9, dobras.getPanturrilha());
            stmt.setObject(10, dobras.getIdAvaliacao());

            int rows = stmt.executeUpdate();

            boolean sucesso = false;
            if (rows > 0) {
                sucesso = true;
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

            String query = "DELETE FROM avaliacao.dobras WHERE id_avaliacao = ?;";

            stmt = connection.prepareStatement(query);
            stmt.setObject(1, idAvaliacao);

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
