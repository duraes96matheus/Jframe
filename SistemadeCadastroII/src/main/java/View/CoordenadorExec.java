package View;

import java.sql.Connection;
import Controler.CoordenadorjdbcDAO;
import Controler.JdbUtil;
import Model.Coordenador;

public class CoordenadorExec {
	public static void main(String[] args) {
		Coordenador coordenador = new Coordenador();
		try {
			coordenador.setId("");
			coordenador.setIDcurosCoordenados("");
			coordenador.setNome("");
			coordenador.setCursosCoordenados("");
			
	
			Connection connection = JdbUtil.getConnection();
			CoordenadorjdbcDAO coordenadorjdbcDao = new CoordenadorjdbcDAO(connection);		
			
			coordenadorjdbcDao.salvar(coordenador);
			coordenadorjdbcDao.alterar(coordenador);
			coordenadorjdbcDao.deletar(coordenador);
			coordenadorjdbcDao.listar();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


