/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcademiaGestaoWebApi.Manager.Treinos;

import AcademiaGestaoWebApi.Enums.RepositoryEnum;
import AcademiaGestaoWebApi.Models.Treinos.GrupoMuscular;
import AcademiaGestaoWebApi.Repository.Repository;
import AcademiaGestaoWebApi.Repository.RepositoryFactory;
import AcademiaGestaoWebApi.Repository.Treino.GrupoMuscularRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author matheusvieira
 */
public class GrupoMuscularManager {

    private final GrupoMuscularRepository repository;

    public GrupoMuscularManager() {
        repository = new GrupoMuscularRepository();
    }

    public List<GrupoMuscular> selectGrupoMuscular() throws Exception {
        List<GrupoMuscular> gruposMusculares = repository.select();
        return gruposMusculares;
    }
}
