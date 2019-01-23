package View;

import java.sql.Connection;

import Controler.CursoJdbcDao;
import Controler.JdbUtil;
import Model.Curso;


public class CursoExec {
	public static void main(String[] args) {
		Curso cursos = new Curso();
		try {
			
			
	
			Connection connection = JdbUtil.getConnection();
			CursoJdbcDao  cursoJdbcDao = new CursoJdbcDao(connection);
			
			cursoJdbcDao.salvar(cursos);
			cursos.setNome("");
			cursos.setArea("");
			cursos.setCargahoraria("");
			cursos.setProfessor("");			
			
			cursoJdbcDao.listar();
			cursoJdbcDao.alterar(cursos);
			cursoJdbcDao.deletar(cursos);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
