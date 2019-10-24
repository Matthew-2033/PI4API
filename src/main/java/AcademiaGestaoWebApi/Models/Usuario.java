package AcademiaGestaoWebApi.Models;

import java.time.LocalDate;
import java.util.UUID;

public class Usuario {
    
    private UUID id;
    
    private UUID idAluno;
    
    private String userName;
    
    private LocalDate dataDeCriacao;
    
    private LocalDate ultimoAcesso;
    
    private boolean senhaRedefinida;        
    
    private String role;
    
    private Aluno aluno;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(UUID idAluno) {
        this.idAluno = idAluno;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDate dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public LocalDate getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDate ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public boolean getSenhaRedefinida() {
        return senhaRedefinida;
    }

    public void setSenhaRedefinida(boolean senhaRedefinida) {
        this.senhaRedefinida = senhaRedefinida;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }      
}
