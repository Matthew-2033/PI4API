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
import AcademiaGestaoWebApi.Models.PorcentagemDeGordura;
import DataLib.AutoMapper.AutoMapper;

public class AvaliacaoPorcentagemGordura extends Repository {

    @Override
    public List select(Object param, Connection connection) throws Exception {
        return null;
    }

    @Override
    public boolean insert(Object obejct, Connection connection) throws Exception {
        List<PorcentagemDeGordura> porcentagens = (ArrayList<PorcentagemDeGordura>) obejct;
        try {
            String query = "INSERT INTO avaliacaoPorcentagemGordura" 
            +"("
            +"    id_avaliacaoPorcentagemGordura"
            +"   ,id_avaliacao"
            +"   ,porcentagemGordura"
            +"   ,autor"
            +")" 
            +"VALUES(uuid(),?,?,?);";

            stmt = connection.prepareStatement(query);

            boolean sucesso = true;
            for (PorcentagemDeGordura porcentagem : porcentagens) {

                stmt.setString(1, porcentagem.getIdAvaliacao().toString());
                stmt.setDouble(2, porcentagem.getPorcentagemDeGordura());
                stmt.setString(3, porcentagem.getAutor().toString());
                
                int rows = stmt.executeUpdate(); 
    
                if(rows <= 0){
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