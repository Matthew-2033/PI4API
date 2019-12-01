package AcademiaGestaoWebApi.Manager.Treinos;

import AcademiaGestaoWebApi.Models.Treinos.Nivel;
import AcademiaGestaoWebApi.Repository.Treino.NivelRepository;
import java.util.List;

/**
 *
 * @author matheusvieira
 */
public class NivelManager {
    
    private final NivelRepository repostiory;
    
    public NivelManager() {
        repostiory = new NivelRepository();
    }
    
    public List<Nivel> selectNivel() throws Exception {
        List<Nivel> niveis = repostiory.select();
        return niveis;
    }
}
