package AcademiaGestaoWebApi.Manager;

import java.util.ArrayList;
import java.util.List;

import AcademiaGestaoWebApi.Enums.RepositoryEnum;
import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.Repository.Repository;
import AcademiaGestaoWebApi.Repository.RepositoryFactory;
 
public class AlunoManager {

    public List<Aluno> selectAlunos(String id) throws Exception {

        Repository<Aluno> repositori = RepositoryFactory.CreateRepository(RepositoryEnum.ALUNO);

        List<Aluno> alunos = new ArrayList<Aluno>();

        try {
            if(id == null){
                alunos = repositori.select();
                return alunos;
            }

            if(!id.matches("[0-9]+")){
                throw new NumberFormatException("O ID passado não é um número");
            }

            int idAluno = Integer.parseInt(id);
            Aluno aluno = repositori.select(idAluno);
            alunos.add(aluno);
            return alunos;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }

    public Aluno selectAluno(int id) throws Exception {

        Repository<Aluno> repositori = RepositoryFactory.CreateRepository(RepositoryEnum.ALUNO);

        try {
            Aluno aluno = repositori.select(id);
            
            return aluno;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }
    
    public Boolean insertAluno(Aluno aluno) throws Exception {
        Repository<Aluno> repositori = RepositoryFactory.CreateRepository(RepositoryEnum.ALUNO);

        try {
            int idNovoAluno = repositori.insert(aluno);
            Boolean sucesso = false;
            if(idNovoAluno >= 0){
                sucesso = true;
            }
            
            return sucesso;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }

    public Boolean updateAluno(Aluno aluno) throws Exception {
        Repository<Aluno> repositori = RepositoryFactory.CreateRepository(RepositoryEnum.ALUNO);

        try {
            Boolean result = repositori.update(aluno);
            return result;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }

    public Boolean deleteAluno(int idAluno) throws Exception {
        Repository<Aluno> repositori = RepositoryFactory.CreateRepository(RepositoryEnum.ALUNO);

        try {
            Boolean result = repositori.delete(idAluno);
            return result;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }
}