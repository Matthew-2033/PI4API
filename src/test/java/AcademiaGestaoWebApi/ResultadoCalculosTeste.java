package AcademiaGestaoWebApi;

import AcademiaGestaoWebApi.Enums.SexoEnum;
import AcademiaGestaoWebApi.Manager.AvaliacaoManager;
import AcademiaGestaoWebApi.Models.Avaliacao;
import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

/**
 *
 * @author matheusvieira
 */
public class ResultadoCalculosTeste {
    
    @Test
    public void testaCalculoManager(){
        
        AvaliacaoRequest avaliacaoRequest = new AvaliacaoRequest();
        avaliacaoRequest.setSexoEnum(SexoEnum.MASCULINO);
        avaliacaoRequest.setIdade(22);
        avaliacaoRequest.setMassa(81);
        avaliacaoRequest.setEstatura(1.74);
        avaliacaoRequest.setPeitoral(8);
        avaliacaoRequest.setMediaAuxiliar(12);
        avaliacaoRequest.setSubEscapular(31);
        avaliacaoRequest.setTricipital(21);
        avaliacaoRequest.setBiciptal(16);
        avaliacaoRequest.setSupraIliaca(31);
        avaliacaoRequest.setAbdominalDobra(25);
        avaliacaoRequest.setCoxa(20);
        avaliacaoRequest.setPanturrilha(25);
        avaliacaoRequest.setTorax(98);
        avaliacaoRequest.setBracoDireito(31);
        avaliacaoRequest.setBracoEsquerdo(32);
        avaliacaoRequest.setAntebracoDireito(27);
        avaliacaoRequest.setAntebracoEsquerdo(27);
        avaliacaoRequest.setAbdominalPerimetro(86);
        avaliacaoRequest.setCintura(81);
        avaliacaoRequest.setQuadril(101);
        avaliacaoRequest.setCoxaDireita(58);
        avaliacaoRequest.setCoxaEsquerda(57);
        avaliacaoRequest.setPernaDireita(39);
        avaliacaoRequest.setPernaEsquerda(40);
        
        AvaliacaoManager manager = new AvaliacaoManager();
        Avaliacao avaliacao = new Avaliacao();
        avaliacao = manager.RealizaCalculosAvalicao(avaliacaoRequest);
        

        Assert.assertTrue(26.7538644470868 == avaliacao.getImc());
        Assert.assertTrue(0.801980198019802 == avaliacao.getPccg());
        Assert.assertTrue(68.26168421052633 == avaliacao.getPesoIdeal());
        Assert.assertTrue(16.151400000000002 == avaliacao.getMassaDeGordura());
        Assert.assertTrue(64.8486 == avaliacao.getMassaMagra());
        Assert.assertTrue(12.738315789473674 ==avaliacao.getPesoEmExcesso());

    }
    
}
