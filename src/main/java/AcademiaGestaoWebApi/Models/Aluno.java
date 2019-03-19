package AcademiaGestaoWebApi.Models;

import java.util.Calendar;
import java.util.List;

import AcademiaGestaoWebApi.Enums.SexoEnum;

/**
 *
 * @author Gabriel
 */
public class Aluno {

    private int id;

    private String nome;

    private String dataNascimento;

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

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public SexoEnum getSexo() {
        return this.sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
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