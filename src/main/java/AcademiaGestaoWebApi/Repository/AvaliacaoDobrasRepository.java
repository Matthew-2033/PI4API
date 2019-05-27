package AcademiaGestaoWebApi.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import AcademiaGestaoWebApi.Models.AvaliacaoDobras;
import DataLib.AutoMapper.AutoMapper;

public class AvaliacaoDobrasRepository extends Repository {

    @Override
    public List select(Object param, Connection connection) throws Exception {
        return null;
    }

    @Override
    public boolean insert(Object obejct, Connection connection) throws Exception {
        AvaliacaoDobras dobras = (AvaliacaoDobras) obejct;
        try {
            String query = "INSERT INTO avaliacaoDobras" 
            +"("
            +"     id_avaliacaoDobras"
            +"    ,id_avaliacao"
            +"    ,peitoral"
            +"    ,auxiliar_media"
            +"    ,sub_escapular"
            +"    ,tricipital"
            +"    ,biciptal"
            +"    ,supra_iliaca"
            +"    ,abdominal"
            +"    ,coxa"
            +"    ,panturrilha"
            +")" 
            +"VALUES(uuid(),?,?,?,?,?,?,?,?,?,?);";

            stmt = connection.prepareStatement(query);

            stmt.setString(1, dobras.getIdAvaliacao().toString());
            stmt.setDouble(2, dobras.getPeitoral());
            stmt.setDouble(3, dobras.getMediaAuxiliar());
            stmt.setDouble(4, dobras.getSubEscapular());
            stmt.setDouble(5, dobras.getTricipital());
            stmt.setDouble(6, dobras.getBiciptal());
            stmt.setDouble(7, dobras.getSupraIliaca());
            stmt.setDouble(8, dobras.getAbdominalDobra());
            stmt.setDouble(9, dobras.getCoxa());
            stmt.setDouble(10, dobras.getPanturrilha());
            
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