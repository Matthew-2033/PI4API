package AcademiaGestaoWebApi.Models;

import java.time.LocalDate;
import java.util.List;

import AcademiaGestaoWebApi.Enums.SexoEnum;

/**
 *
 * @author Gabriel
 */
public class Aluno{

    private int id;

    private String nome;

    private LocalDate dataNascimento;

    private SexoEnum sexo;

    private String email;

    private String cpf;

    private boolean ativo;

    private List<Avaliacao> historicoDeAvaliacao;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public SexoEnum getSexo() {
        return this.sexo;
    }

    public void setSexoEnum(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public void setSexoEnum(int sexo) {
        switch (sexo) {
            case 1:
                this.sexo = SexoEnum.MASCULINO;
                break;        
            case 2:
                this.sexo = SexoEnum.FEMININO;
                break;
            case 3:
                this.sexo = SexoEnum.NAODECLARADO;
                break;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Avaliacao> getHistoricoDeAvaliacao() {
        return this.historicoDeAvaliacao;
    }

    public void setHistoricoDeAvaliacao(List<Avaliacao> historicoDeAvaliacao) {
        this.historicoDeAvaliacao = historicoDeAvaliacao;
    }
}