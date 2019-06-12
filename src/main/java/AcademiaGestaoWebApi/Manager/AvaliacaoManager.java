package AcademiaGestaoWebApi.Manager;

import java.sql.Connection;
import java.util.UUID;

import AcademiaGestaoWebApi.Calculos.CalculosGerais;
import AcademiaGestaoWebApi.Calculos.PorcentagemDeGorduraCalculo;
import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Models.Avaliacao;
import AcademiaGestaoWebApi.Models.AvaliacaoDobras;
import AcademiaGestaoWebApi.Models.AvaliacaoPerimetros;
import AcademiaGestaoWebApi.Models.PorcentagemDeGordura;
import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;
import AcademiaGestaoWebApi.Repository.AvaliacaoDobrasRepository;
import AcademiaGestaoWebApi.Repository.AvaliacaoPerimetrosRepository;
import AcademiaGestaoWebApi.Repository.AvaliacaoPorcentagemGorduraRepository;
import AcademiaGestaoWebApi.Repository.AvaliacaoRepository;
import DTO.AvaliacaoDTO;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoManager {

    private PorcentagemDeGorduraCalculo porcentagemDeGorduraCalculos;
    private AvaliacaoRepository repositoryAvaliacao;
    private AvaliacaoDobrasRepository repositoryDobras;
    private AvaliacaoPerimetrosRepository repositoryPerimetros;
    private AvaliacaoPorcentagemGorduraRepository repositoryGordura;
    private Connection connection;

    public ApiRetorno<Boolean> insertAvaliacao(AvaliacaoRequest avaliacaoRequest) throws Exception {
        connection = ConnectionConfig.getConnection(false);
        repositoryAvaliacao = new AvaliacaoRepository();
        repositoryDobras = new AvaliacaoDobrasRepository();
        repositoryPerimetros = new AvaliacaoPerimetrosRepository();
        repositoryGordura = new AvaliacaoPorcentagemGorduraRepository();
        ApiRetorno<Boolean> retorno = new ApiRetorno<>();

        try {
            Avaliacao avaliacao = RealizaCalculosAvalicao(avaliacaoRequest);
            avaliacao.setID(UUID.randomUUID());

            boolean sucesso = repositoryAvaliacao.insert(avaliacao, connection);

            if (!sucesso) {
                throw new Exception("Erro ao foi possivel inserir a avaliação");
            }

            sucesso = repositoryDobras.insert(avaliacao.getDobrasAvaliacao(), connection);

            if (!sucesso) {
                throw new Exception("Erro ao foi possivel inserir a avaliação");
            }

            sucesso = repositoryPerimetros.insert(avaliacao.getPerimetrosAvaliacao(), connection);

            if (!sucesso) {
                throw new Exception("Erro ao foi possivel inserir a avaliação");
            }

            sucesso = repositoryGordura.insert(avaliacao.getPorcentagemDeGordura(), connection);

            retorno.setData(sucesso);
            retorno.setSucess(sucesso);
            connection.commit();
            ConnectionConfig.closeConnection(connection);

            return retorno;
        } catch (Exception ex) {
            connection.rollback();
            ConnectionConfig.closeConnection(connection);
            throw ex;
        }
    }

    public Avaliacao RealizaCalculosAvalicao(AvaliacaoRequest avaliacaoRequest) {
        Avaliacao avaliacao = Avaliacao.Factory.create(avaliacaoRequest);
        porcentagemDeGorduraCalculos = new PorcentagemDeGorduraCalculo();

        CalculosGerais calculosGerais = new CalculosGerais(avaliacaoRequest.getSexo());

        avaliacao.setImc(calculosGerais.imc(avaliacaoRequest.getMassa(), avaliacaoRequest.getEstatura()));
        avaliacao.setPccg(calculosGerais.pccq(avaliacaoRequest.getCintura(), avaliacaoRequest.getQuadril()));
        avaliacao.setMassaDeGordura(calculosGerais.massaDeGordura(avaliacaoRequest.getMassa()));
        avaliacao.setMassaMagra(calculosGerais.massaMagra(avaliacao.getMassa(), avaliacao.getMassaDeGordura()));
        avaliacao.setPesoIdeal(calculosGerais.pesoIdeal(avaliacao.getMassaMagra()));
        avaliacao.setPesoEmExcesso(calculosGerais.pesoExcesso(avaliacao.getMassa(), avaliacao.getPesoIdeal()));
        avaliacao.setPorcentagemDeGordura(porcentagemDeGorduraCalculos.executaCalculos(avaliacaoRequest));

        return avaliacao;
    }

    public List<AvaliacaoDTO> selectAvaliacao(UUID id) throws Exception {

        connection = ConnectionConfig.getConnection(false);
        repositoryAvaliacao = new AvaliacaoRepository();
        repositoryGordura = new AvaliacaoPorcentagemGorduraRepository();
        
        List<AvaliacaoDTO> avaliacoes = repositoryAvaliacao.select(id, connection);

        for (AvaliacaoDTO avaliacao : avaliacoes) {
            avaliacao.setPorcentagemDeGordura(repositoryGordura.select(avaliacao.getiD(), connection));
        }

        return avaliacoes;
    }
}
