package AcademiaGestaoWebApi.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Models.Avaliacao;

public class AvaliacaoRepository extends Repository {

    private Connection con = null;

    public  AvaliacaoRepository() {
        con = ConnectionConfig.getConnection();
    }

    public List<Avaliacao> select(int avaliadoId, int a){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Avaliacao> avaliacaoList = new ArrayList<>();

        try {
            
            String query = "SELECT * FROM Avaliacao "
                            +"INNER JOIN Avaliado "
                            +"on Avaliado.avaliado_id = Avaliacao.avaliado_id "
                            +"WHERE Avaliado.avaliado_id = ?";

            stmt = con.prepareStatement(query);
            //Param:
            stmt.setInt(1, avaliadoId);            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Avaliacao avaliacao = new Avaliacao();                
                avaliacao.setID(rs.getInt("avalicao_id"));
                avaliacao.setMassa(rs.getDouble("massa"));
                avaliacao.setEstatura(rs.getDouble("estatura"));
                avaliacao.setPeitoral(rs.getDouble("peitoral"));
                avaliacao.setMediaAuxiliar(rs.getDouble("auxiliar_media"));
                avaliacao.setSubEscapular(rs.getDouble("sub_escapular"));
                avaliacao.setTricipital(rs.getDouble("tricipital"));
                avaliacao.setBiciptal(rs.getDouble("biciptal"));
                avaliacao.setSupraIliaca(rs.getDouble("supra_iliaca"));
                avaliacao.setCoxa(rs.getDouble("coxa"));
                avaliacao.setPanturrilha(rs.getDouble("panturrilha"));                                                
                avaliacao.setTorax(rs.getDouble("torax"));
                avaliacao.setBracoDireito(rs.getDouble("braco_direito"));
                avaliacao.setBracoEsquerdo(rs.getDouble("braco_esquerdo"));
                avaliacao.setAntebracoDireito(rs.getDouble("antebraco_direito"));
                avaliacao.setAntebracoEsquerdo(rs.getDouble("antebraco_esquerdo"));
                avaliacao.setAbdominal(rs.getDouble("abdominal"));
                avaliacao.setCintura(rs.getDouble("cintura"));
                avaliacao.setQuadril(rs.getDouble("quadril"));
                avaliacao.setCoxaDireita(rs.getDouble("coxa_direita"));
                avaliacao.setCoxaEsquerda(rs.getDouble("coxa_esquerda"));
                avaliacao.setPernaDireita(rs.getDouble("perna_direita"));
                avaliacao.setPernaEsquerda(rs.getDouble("perna_esquerda"));
                avaliacao.setImc(rs.getDouble("imc"));
                avaliacao.setPccg(rs.getDouble("pccg"));
                avaliacao.setPesoAtual(rs.getDouble("peso_atual"));
                avaliacao.setMassaDeGordura(rs.getDouble("massa_de_gordura"));
                avaliacao.setMassaMagra(rs.getDouble("massa_magra"));
                avaliacao.setPesoIdeal(rs.getDouble("peso_ideal"));
                avaliacao.setQuantidadeDePesoEmExcesso(rs.getDouble("peso_em_excesso"));

                avaliacaoList.add(avaliacao);
                
            }

        } catch (SQLException error) {
            error.printStackTrace();
        }finally{
            ConnectionConfig.closeConnection(con, stmt, rs);;
        }

        return avaliacaoList;
    }

    public boolean update(){

        con = ConnectionConfig.getConnection();
        PreparedStatement stmt = null;

        try {

            
            String query = "UPDATE `hugolutke01`.`Avaliacao` SET "
                                + " `massa` = ?, "
                                + "`estatura` = ?, "
                                + "`peitoral` = ?, "
                                + "`auxiliar_media` = ?, "
                                +"`sub_escapular` = ?, "
                                +"`tricipital` = ?, "
                                +"`biciptal` = ?, "
                                +"`supra_iliaca` = ?, "
                                +"`coxa` = ?, "
                                +"`panturrilha` = ?, "
                                +"`torax` = ?, "
                                +"`braco_direito` = ?, "
                                +"`braco_esquerdo` = ?, "
                                +"`antebraco_direito` = ?, "
                                +"`antebraco_esquerdo` = ?, "
                                +"`abdominal` = ?, "
                                +"`cintura` = ?, "
                                +"`quadril` = ?, "
                                +"`coxa_direita` = ?, "
                                +"`coxa_esquerda` = ?, "
                                +"`perna_direita` = ?, "
                                +"`perna_esquerda` = ?, "
                                +"`imc` = ?, "
                                +"`pccg` = ?, "
                                +"`peso_atual` = ?, "
                                +"`massa_de_gordura` = ?, "
                                +"`massa_magra` = ?, "
                                +"`peso_ideal` = ?, "
                                +"`peso_em_excesso` = ?" 
                            +"WHERE (`avaliacao_id` = '1')";

            stmt = con.prepareStatement(query);

            //Params
            

        } catch (Exception e) {

        }            


        return false;
    }

    public boolean delete(Avaliacao avaliacao){

        PreparedStatement stmt = null;

        try {

            String query = "DELETE FROM Avaliacao WHERE avaliacao_id = ?";

            stmt = con.prepareStatement(query);
            stmt.setInt(1, avaliacao.getID());
            stmt.execute();

            return true;

        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        } finally {
            ConnectionConfig.closeConnection(con, stmt);
        }

        
    }

    @Override
    public List select(int id, Connection connection) throws Exception {
        return null;
    }

    @Override
    public int insert(Object object, Connection connection) throws Exception {
        return 0;
    }

    @Override
    public boolean update(Object object, Connection connection) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int id, Connection connection) throws Exception {
        return false;
    }


}