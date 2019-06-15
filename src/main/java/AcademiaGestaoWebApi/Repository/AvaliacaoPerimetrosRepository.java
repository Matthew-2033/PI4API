package AcademiaGestaoWebApi.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import AcademiaGestaoWebApi.Models.AvaliacaoPerimetros;
import DataLib.AutoMapper.AutoMapper;

public class AvaliacaoPerimetrosRepository extends Repository {

    @Override
    public List select(Object idObject, Connection connection) throws Exception {
        UUID id = (UUID) idObject;
        CallableStatement stmt = null;
        ResultSet data = null;

        List<AvaliacaoPerimetros> dobras = new ArrayList<>();

        try {

            String query = "SELECT"
                    + "    id_avaliacaoPerimetro AS id"
                    + "   ,id_avaliacao AS idAvaliacao"
                    + "   ,torax AS torax"
                    + "   ,braco_direito AS bracoDireito"
                    + "   ,braco_esquerdo AS bracoEsquerdo"
                    + "   ,antebraco_direito AS antebracoDireito"
                    + "   ,antebraco_esquerdo AS antebracoEsquerdo"
                    + "   ,abdominal AS abdominal" 
                    + "   ,cintura AS cintura"
                    + "   ,quadril AS quadril"
                    + "   ,coxa_direita AS coxaDireita"
                    + "   ,coxa_esquerda AS coxaEsquerda"
                    + "   ,perna_direita AS pernaDireita"
                    + "   ,perna_esquerda AS pernaEsquerda " 
                    + "FROM avaliacaoPerimetro "
                    + " WHERE idAvaliacao = ?";

            stmt = connection.prepareCall(query);

            stmt.setString(1, id.toString());

            data = stmt.executeQuery();

            AutoMapper<AvaliacaoPerimetros> autoMapper = new AutoMapper<AvaliacaoPerimetros>(new AvaliacaoPerimetros());

            dobras = autoMapper.map(data);

            return dobras;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }

    @Override
    public boolean insert(Object obejct, Connection connection) throws Exception {
        AvaliacaoPerimetros dobras = (AvaliacaoPerimetros) obejct;
        try {
            String query = "INSERT INTO avaliacaoPerimetro"
                    + "("
                    + "    id_avaliacaoPerimetro"
                    + "   ,id_avaliacao"
                    + "   ,torax"
                    + "   ,braco_direito"
                    + "   ,braco_esquerdo"
                    + "   ,antebraco_direito"
                    + "   ,antebraco_esquerdo"
                    + "   ,abdominal"
                    + "   ,cintura"
                    + "   ,quadril"
                    + "   ,coxa_direita"
                    + "   ,coxa_esquerda"
                    + "   ,perna_direita"
                    + "   ,perna_esquerda"
                    + ")"
                    + "VALUES(uuid(),?,?,?,?,?,?,?,?,?,?,?,?,?);";

            stmt = connection.prepareStatement(query);

            stmt.setString(1, dobras.getIdAvaliacao().toString());
            stmt.setDouble(2, dobras.getTorax());
            stmt.setDouble(3, dobras.getBracoDireito());
            stmt.setDouble(4, dobras.getBracoEsquerdo());
            stmt.setDouble(5, dobras.getAntebracoDireito());
            stmt.setDouble(6, dobras.getAntebracoEsquerdo());
            stmt.setDouble(7, dobras.getAbdominal());
            stmt.setDouble(8, dobras.getCintura());
            stmt.setDouble(9, dobras.getQuadril());
            stmt.setDouble(10, dobras.getCoxaDireita());
            stmt.setDouble(11, dobras.getCoxaEsquerda());
            stmt.setDouble(12, dobras.getPernaDireita());
            stmt.setDouble(13, dobras.getPernaEsquerda());

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
        AvaliacaoPerimetros dobras = (AvaliacaoPerimetros) object;
        try {
            String query = "UPDATE avaliacaoPerimetro SET "
                            +"	 torax = ? "
                            +"	,braco_direito = ? "
                            +"	,braco_esquerdo = ? "
                            +"	,antebraco_direito = ? "
                            +"	,antebraco_esquerdo = ? "
                            +"	,abdominal = ? "
                            +"	,cintura = ? "
                            +"	,quadril = ? "
                            +"	,coxa_direita = ? "
                            +"	,coxa_esquerda = ? "
                            +"	,perna_direita = ? "
                            +"	,perna_esquerda = ? "
                            +"WHERE id_avaliacao = ?; ";

            stmt = connection.prepareStatement(query);

            stmt.setDouble(1, dobras.getTorax());
            stmt.setDouble(2, dobras.getBracoDireito());
            stmt.setDouble(3, dobras.getBracoEsquerdo());
            stmt.setDouble(4, dobras.getAntebracoDireito());
            stmt.setDouble(5, dobras.getAntebracoEsquerdo());
            stmt.setDouble(6, dobras.getAbdominal());
            stmt.setDouble(7, dobras.getCintura());
            stmt.setDouble(8, dobras.getQuadril());
            stmt.setDouble(9, dobras.getCoxaDireita());
            stmt.setDouble(10, dobras.getCoxaEsquerda());
            stmt.setDouble(11, dobras.getPernaDireita());
            stmt.setDouble(12, dobras.getPernaEsquerda());
            stmt.setString(13, dobras.getIdAvaliacao().toString());

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
        return false;
    }
}
