package AcademiaGestaoWebApi.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import AcademiaGestaoWebApi.Enums.RepositoryEnum;
import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.Repository.Repository;
import AcademiaGestaoWebApi.Repository.RepositoryFactory;
 
public class AlunoManager {

    public List<Aluno> selectAlunos(UUID id) throws Exception {

        Repository<Aluno> repositori = RepositoryFactory.CreateRepository(RepositoryEnum.ALUNO);

        List<Aluno> alunos = new ArrayList<Aluno>();

        try {
            if(id.toString().equals("00000000-0000-0000-0000-000000000000")){
                alunos = repositori.select();
                return alunos;
            }

            Aluno aluno = repositori.select(id);
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
    
    public boolean insertAluno(Aluno aluno) throws Exception {
        Repository<Aluno> repositori = RepositoryFactory.CreateRepository(RepositoryEnum.ALUNO);

        try {
            boolean sucesso = repositori.insert(aluno);
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

    public Boolean deleteAluno(UUID idAluno) throws Exception {
        Repository<Aluno> repositori = RepositoryFactory.CreateRepository(RepositoryEnum.ALUNO);

        try {
            Boolean result = repositori.delete(idAluno);
            return result;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }
}