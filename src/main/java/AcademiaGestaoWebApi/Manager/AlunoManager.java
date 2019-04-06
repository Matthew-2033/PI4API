package AcademiaGestaoWebApi.Manager;

import java.util.List;

import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.Repository.AlunoRepository;
 
public class AlunoManager {

    public List<Aluno> selectAlunos() throws Exception {
        AlunoRepository alunoRepository = new AlunoRepository();

        try {
            List<Aluno> alunos = alunoRepository.select();
            return alunos;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }

    public Boolean insertAluno(Aluno aluno) throws Exception {
        AlunoRepository alunoRepository = new AlunoRepository();

        try {
            int idNovoAluno = alunoRepository.insert(aluno);
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
        AlunoRepository alunoRepository = new AlunoRepository();

        try {
            Boolean result = alunoRepository.update(aluno);
            return result;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }

    public Boolean deleteAluno(int idAluno) throws Exception {
        AlunoRepository alunoRepository = new AlunoRepository();

        try {
            Boolean result = alunoRepository.delete(idAluno);
            return result;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }
}