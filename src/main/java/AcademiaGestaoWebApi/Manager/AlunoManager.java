package AcademiaGestaoWebApi.Manager;

import java.util.List;

import AcademiaGestaoWebApi.Enums.RepositoryEnum;
import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.Repository.Repository;
import AcademiaGestaoWebApi.Repository.RepositoryFactory;
 
public class AlunoManager {

    public List<Aluno> selectAlunos() throws Exception {

        Repository<Aluno> repositori = RepositoryFactory.CreateRepository(RepositoryEnum.ALUNO);

        try {
            List<Aluno> alunos = repositori.select();
            return alunos;
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