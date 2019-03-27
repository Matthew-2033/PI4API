package AcademiaGestaoWebApi;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import AcademiaGestaoWebApi.Config.ConnectionConfig;
import AcademiaGestaoWebApi.Enums.SexoEnum;
import AcademiaGestaoWebApi.Models.Aluno;
import AcademiaGestaoWebApi.Repository.AlunoRepository;
import java.util.List;

@SpringBootApplication
public class AcademiaGestaoWebApiApplication {

	/**
	 *
	 */
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(AcademiaGestaoWebApiApplication.class, args);

		AlunoRepository dao = new AlunoRepository();
		List<Aluno> alunos = dao.select();
		System.out.println("Quantidade: " + alunos.get(0).getNome());

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Matheus2");
		aluno2.setDataNascimento("1999-05-27");
		aluno2.setSexo(SexoEnum.FEMININO);
		aluno2.setEmail("matheus@email.com");
		aluno2.setCpf("123456789");
		aluno2.setAtivo(true);		
		aluno2.setId(5);

		if(dao.update(aluno2)){
			System.out.println("SUCESSO");
		}
	}
}
