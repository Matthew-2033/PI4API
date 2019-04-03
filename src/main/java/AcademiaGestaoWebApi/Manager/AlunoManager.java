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

    public Boolean updateAluno(Aluno aluno) throws Exception {
        AlunoRepository alunoRepository = new AlunoRepository();

        try {
            Boolean result = alunoRepository.update(aluno);
            return result;
        } catch (Exception ex) {
            throw new Exception(ex);
        }                
    }

}