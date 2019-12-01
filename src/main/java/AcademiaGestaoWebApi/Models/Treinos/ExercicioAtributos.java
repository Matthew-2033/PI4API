package AcademiaGestaoWebApi.Models.Treinos;

import java.util.UUID;

public class ExercicioAtributos {

    private UUID idExercicio;
    private String exercicio;
    private int vezes;
    private int repeticoes;
    private double carga;

    public UUID getId() {
        return idExercicio;
    }

    public void setId(UUID id) {
        this.idExercicio = id;
    }
          
    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public int getVezes() {
        return vezes;
    }

    public void setVezes(int vezes) {
        this.vezes = vezes;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
}
