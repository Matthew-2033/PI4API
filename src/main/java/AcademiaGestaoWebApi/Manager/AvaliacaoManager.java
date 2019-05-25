package AcademiaGestaoWebApi.Manager;

import AcademiaGestaoWebApi.Calculos.CalculosGerais;
import AcademiaGestaoWebApi.Calculos.PorcentagemDeGorduraCalculo;
import AcademiaGestaoWebApi.Models.Avaliacao;
import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;

public class AvaliacaoManager {

    private PorcentagemDeGorduraCalculo porcentagemDeGorduraCalculos;
    
    public ApiRetorno<Boolean> insertAvaliacao(AvaliacaoRequest avaliacaoRequest) {

        Avaliacao avaliacao = RealizaCalculosAvalicao(avaliacaoRequest);                

        return new ApiRetorno<Boolean>();
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
}
