package AcademiaGestaoWebApi.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import AcademiaGestaoWebApi.Models.AvaliacaoPerimetros;
import DataLib.AutoMapper.AutoMapper;

public class AvaliacaoPerimetrosRepository extends Repository {

    @Override
    public List select(Object param, Connection connection) throws Exception {
        return null;
    }

    @Override
    public boolean insert(Object obejct, Connection connection) throws Exception {
        AvaliacaoPerimetros dobras = (AvaliacaoPerimetros) obejct;
        try {
            String query = "INSERT INTO avaliacaoPerimetro" 
            +"("
            +"    id_avaliacaoPerimetro"
            +"   ,id_avaliacao"
            +"   ,torax"
            +"   ,braco_direito"
            +"   ,braco_esquerdo"
            +"   ,antebraco_direito"
            +"   ,antebraco_esquerdo"
            +"   ,abdominal"
            +"   ,cintura"
            +"   ,quadril"
            +"   ,coxa_direita"
            +"   ,coxa_esquerda" 
            +"   ,perna_direita"
            +"   ,perna_esquerda"
            +")" 
            +"VALUES(uuid(),?,?,?,?,?,?,?,?,?,?,?,?,?);";

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
            if(rows > 0){
                sucesso = true;
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