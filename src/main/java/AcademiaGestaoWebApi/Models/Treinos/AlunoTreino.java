package AcademiaGestaoWebApi.Models.Treinos;

import AcademiaGestaoWebApi.Enums.SexoEnum;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class AlunoTreino {

    private UUID idTreino;
    private String nivel;
    private String nome;
    private LocalDate dataCriacao;
    private SexoEnum sexo;
    private int repeticoes;
    private List<ExercicioAtributos> exercicios;
    private boolean ativo;
    private boolean finalizado;

    public UUID getId() {
        return idTreino;
    }

    public void setId(UUID id) {
        this.idTreino = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public void setSexo(int sexo) {
        switch (sexo) {
            case 1:
                this.sexo = SexoEnum.MASCULINO;
                break;
            case 2:
                this.sexo = SexoEnum.FEMININO;
                break;
            case 3:
                this.sexo = SexoEnum.AMBOS;
                break;
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ExercicioAtributos> getExercicios() {
        return exercicios;
    }

    public void setExercicios(String exercicios) {
        JSONArray jsonarray = new JSONArray(exercicios);
        List<ExercicioAtributos> atributos = new ArrayList<>();

        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            ExercicioAtributos atributo = new ExercicioAtributos();
            atributo.setId(UUID.fromString(jsonobject.getString("idexercicio")));
            atributo.setCarga(jsonobject.getDouble("carga"));
            atributo.setExercicio(jsonobject.getString("exercicio"));
            atributo.setRepeticoes(jsonobject.getInt("repeticoes"));
            atributo.setVezes(jsonobject.getInt("vezes"));

            atributos.add(atributo);
        }

        this.exercicios = atributos;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public UUID getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(UUID idTreino) {
        this.idTreino = idTreino;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

}
