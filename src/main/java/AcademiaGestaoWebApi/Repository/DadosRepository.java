package AcademiaGestaoWebApi.Repository;

import AcademiaGestaoWebApi.Models.Dados;
import AcademiaGestaoWebApi.Models.MediaImc;
import AcademiaGestaoWebApi.Models.MediaPorcentagemGordura;
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
public class DadosRepository extends Repository {

    @Override
    public List<MediaPorcentagemGordura> select(Object param, Connection connection) throws Exception {

        CallableStatement stmt = null;
        ResultSet rs = null;

        List<MediaPorcentagemGordura> medias = new ArrayList<>();

        try {
            String query = "SELECT * FROM wiew_media_de_gordura_por_sexo";

            stmt = connection.prepareCall(query);
            rs = stmt.executeQuery();

            AutoMapper<MediaPorcentagemGordura> autoMapper = new AutoMapper<MediaPorcentagemGordura>(new MediaPorcentagemGordura());
            medias = autoMapper.map(rs);
            return medias;

        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public Double selectPorcentagem(Connection connection) throws Exception {
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            String query = "SELECT fn_calcula_porcentagem() AS porcentagem";

            stmt = connection.prepareCall(query);
            rs = stmt.executeQuery();
            
            rs.next();
            
            Double result = rs.getDouble("porcentagem");
            return result;

        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public Dados selectDados(Connection connection) throws Exception {

        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Dados> dados = new ArrayList<>();
        try {
            String query = "SELECT * FROM view_select_dados";

            stmt = connection.prepareCall(query);
            rs = stmt.executeQuery();

            AutoMapper<Dados> autoMapper = new AutoMapper<Dados>(new Dados());
            dados = autoMapper.map(rs);

            return dados.stream().findFirst().get();

        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public List<MediaImc> selectMediaIMC(Connection connection) throws Exception {

        CallableStatement stmt = null;
        ResultSet rs = null;
        List<MediaImc> medias = new ArrayList<>();
        try {
            String query = "CALL SP_MEDIA_IDADE()";

            stmt = connection.prepareCall(query);
            rs = stmt.executeQuery();

            AutoMapper<MediaImc> autoMapper = new AutoMapper<MediaImc>(new MediaImc());
            medias = autoMapper.map(rs);

            return medias;

        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    @Override
    public boolean insert(Object object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object object, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id, Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
