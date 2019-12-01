package AcademiaGestaoWebApi.Models.Treinos;

import AcademiaGestaoWebApi.Enums.SexoEnum;
import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Treino {
    
    private UUID idTreino;
    private String nome;
    private String nivel;
    private SexoEnum sexo;
    private List<String> exercicios;
    private LocalDate dataCriacao;

    public UUID getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(UUID idTreino) {
        this.idTreino = idTreino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public List<String> getExercicios() {
        return exercicios;
    }

    public void setExercicios(String exercicios) {        
        Gson gson = new Gson();
        this.exercicios = gson.fromJson(exercicios, List.class);                       
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }                
}
