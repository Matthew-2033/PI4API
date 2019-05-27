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
            throw ex;
        }
    }
    
    @Override
    public boolean insert(Object object, Connection connection) throws Exception {
        Avaliacao avaliacao = (Avaliacao) object;

        try {

            String query = "INSERT INTO avaliacao" 
            +"("
            +"     id_avaliacao"
            +"    ,massa"
            +"    ,estatura"
            +"    ,imc"
            +"    ,pccg"
            +"    ,massa_de_gordura"
            +"    ,massa_magra"
            +"    ,peso_ideal"
            +"    ,peso_em_excesso  "
            +")" 
            +"VALUES(?,?,?,?,?,?,?,?,?);";

            stmt = connection.prepareStatement(query);

            //Params
            stmt.setString(1, avaliacao.getID().toString());
            stmt.setDouble(2, avaliacao.getMassa());
            stmt.setDouble(3, avaliacao.getEstatura());
            stmt.setDouble(4, avaliacao.getImc());
            stmt.setDouble(5, avaliacao.getPccg());
            stmt.setDouble(6, avaliacao.getMassaDeGordura());
            stmt.setDouble(7, avaliacao.getMassaMagra());
            stmt.setDouble(8, avaliacao.getPesoIdeal());
            stmt.setDouble(9, avaliacao.getPesoEmExcesso());

            int rows = stmt.executeUpdate(); 

            boolean sucesso = true;
            if(rows <= 0){
                return false;
            }

            sucesso = insertAvaliacaoAluno(avaliacao.getID(), avaliacao.getIdAluno(), connection);
            return sucesso;
        } catch (Exception ex) {
            throw ex;
        }        
    }

    private boolean insertAvaliacaoAluno(UUID idAvaliacao, UUID idAluno, Connection connection) throws Exception {
        try {
            String query = "INSERT INTO alunoAvaliacao"
            +"("
            +"     id_alunoAvaliacao"
            +"    ,id_aluno"
            +"    ,id_avaliacao"
            +")"
            +"VALUE" 
            +"("
            +"     uuid()"
            +"    ,?"
            +"    ,?"
            +");";

            stmt = connection.prepareStatement(query);
            
            stmt.setString(1, idAluno.toString());
            stmt.setString(2, idAvaliacao.toString());

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