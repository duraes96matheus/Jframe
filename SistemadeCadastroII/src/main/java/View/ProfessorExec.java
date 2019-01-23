package View;

import java.sql.Connection;


import Controler.JdbUtil;
import Controler.ProfessoresjdbcDAO;
import Model.Professor;

public class ProfessorExec {
	

	public static void main(String[] args) {
		Professor professores = new Professor();
		try {
			
			professores.setNome("");
			professores.setCursoMinistrado("");
			professores.setIDCurso("");
	
			Connection connection = JdbUtil.getConnection();
			ProfessoresjdbcDAO  ProfessoresjdbcDAO = new ProfessoresjdbcDAO(connection);
			
			ProfessoresjdbcDAO.salvar(professores);
			ProfessoresjdbcDAO.listar();
			ProfessoresjdbcDAO.alterar(professores);
			ProfessoresjdbcDAO.deletar("");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
