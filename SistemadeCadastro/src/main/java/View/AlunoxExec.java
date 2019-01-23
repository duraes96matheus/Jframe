package View;

import java.sql.Connection;



import Controler.AlunosjdbcDAO;
import Controler.JdbUtil;
import Model.Alunos;

public class AlunoxExec {

	public static void main(String[] args) {
		Alunos alunos = new Alunos();
		try {
			alunos.setNome("");
			alunos.setEndereco("");
			alunos.setTelefone("");
			alunos.setCursocursado("");
			alunos.setIdCurso("");
				
			Connection connection = JdbUtil.getConnection();
			AlunosjdbcDAO alunosJdbcDao = new AlunosjdbcDAO(connection);
			
			alunosJdbcDao.salvar(alunos);
			alunosJdbcDao.listar();
		//	alunosJdbcDao.alterar(alunos);
			//alunosJdbcDao.deletar();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

