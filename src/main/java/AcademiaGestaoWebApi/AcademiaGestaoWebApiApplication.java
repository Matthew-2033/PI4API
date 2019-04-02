package AcademiaGestaoWebApi;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import AcademiaGestaoWebApi.Enums.SexoEnum;
import AcademiaGestaoWebApi.Models.Aluno;
import java.time.LocalDate;
import AcademiaGestaoWebApi.Repository.AlunoRepository;
import java.util.List;

@SpringBootApplication
public class AcademiaGestaoWebApiApplication {

	/**
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws InstantiationException
	 *
	 */
	public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException,
			InstantiationException, NoSuchFieldException, SecurityException {
		SpringApplication.run(AcademiaGestaoWebApiApplication.class, args);

		AlunoRepository dao = new AlunoRepository();
		List<Aluno> alunos = dao.select();

		System.out.println("Quantidade: " + alunos.get(0).getNome());

		LocalDate data = LocalDate.of(1999, 2, 1);

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Matheus2");
		aluno2.setDataNascimento(data);
		aluno2.setSexoEnum(SexoEnum.FEMININO);
		aluno2.setEmail("matheus@email.com");
		aluno2.setCpf("123456789");
		aluno2.setAtivo(true);		
		aluno2.setId(5);

		if(dao.update(aluno2)){
			System.out.println("SUCESSO");
		}
	}
}
