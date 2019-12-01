package AcademiaGestaoWebApi.Models.Treinos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exercicio {
    
    private UUID id;
    private String nome;
    private LocalDate dataCriacao;
    private List<GrupoMuscular> gruposMusculares;
    private String mediaUrl;
    private boolean ativo;
                
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }  

    public List<GrupoMuscular> getGruposMusculares() {
        return gruposMusculares;
    }

    public void setGruposMusculares(String gruposMusculares) {        
        
        JSONArray jsonarray = new JSONArray(gruposMusculares);
        List<GrupoMuscular> atributos = new ArrayList<>();
        
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            GrupoMuscular atributo = new GrupoMuscular();
            
            atributo.setId(UUID.fromString(jsonobject.getString("id_grupo_muscular")));
            atributo.setGrupoMuscular(jsonobject.getString("grupo_muscular"));
                     
            atributos.add(atributo);
        }
        
        this.gruposMusculares = atributos;
    }

    public String getMedia() {
        return mediaUrl;
    }

    public void setMedia(String media) {
        this.mediaUrl = media;
    }    
}
