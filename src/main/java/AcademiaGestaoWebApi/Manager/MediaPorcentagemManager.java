package AcademiaGestaoWebApi.Manager;

import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Enums.RepositoryEnum;
import AcademiaGestaoWebApi.Models.MediaPorcentagemGordura;
import AcademiaGestaoWebApi.Repository.DadosRepository;
import AcademiaGestaoWebApi.Repository.Repository;
import AcademiaGestaoWebApi.Repository.RepositoryFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheusvieira
 */
public class MediaPorcentagemManager {

    private final DadosRepository repositoryMedias;
    private final Connection connection;

    public MediaPorcentagemManager() {
        this.connection = ConnectionConfig.getConnection(false);
        this.repositoryMedias = new DadosRepository();
    }

    public List<MediaPorcentagemGordura> selectMedias() throws Exception {

        MediaPorcentagemGordura media = new MediaPorcentagemGordura();
        List<MediaPorcentagemGordura> medias = repositoryMedias.select(media, this.connection);

        return medias;

    }

}
