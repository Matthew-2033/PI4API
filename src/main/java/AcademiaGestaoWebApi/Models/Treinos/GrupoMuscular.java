package AcademiaGestaoWebApi.Models.Treinos;

import java.util.UUID;

/**
 *
 * @author matheusvieira
 */
public class GrupoMuscular {
    
    private UUID id;
    private String grupoMuscular;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }    
}
