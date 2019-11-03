package AcademiaGestaoWebApi.Models.Treinos;

import java.util.UUID;

public class Nivel {
 
    private UUID id;
    private String nivel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
