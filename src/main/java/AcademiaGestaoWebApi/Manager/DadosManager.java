package AcademiaGestaoWebApi.Manager;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Models.Dados;
import AcademiaGestaoWebApi.Repository.DadosRepository;
import java.sql.Connection;

/**
 *
 * @author matheusvieira
 */
public class DadosManager {

    private final DadosRepository dadosRepository;
    private final Connection connection;

    public DadosManager() {
        this.connection = ConnectionConfig.getConnection(false);
        this.dadosRepository = new DadosRepository();
    }

    public Dados selectDados() throws Exception {

        Dados dados = new Dados();

        dados = dadosRepository.selectDados(connection);
        //dados.setPorcentagemDeAvaliados(dadosRepository.selectPorcentagem(connection));
        //dados.setMediaImc(dadosRepository.selectMediaIMC(connection));

        return dados;
    }
}
