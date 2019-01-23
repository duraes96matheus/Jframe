package Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Curso;

public class CursoJdbcDao {
	private Connection conn;
	
	public CursoJdbcDao(Connection conn) {
		this.conn=conn;
	}
	public void salvar(Curso c) throws SQLException{
	String SQL="insert into TB_Curso(Nome,Area,CargaHoraria,Professor)values('"+c.getNome()+"','"+c.getArea()+"','"+c.getCargahoraria()+"','"+c.getProfessor()+"')'";
	PreparedStatement prepareStatement=this.conn.prepareStatement(SQL);
	prepareStatement.executeUpdate();
	prepareStatement.close();		
	}
	public void alterar(Curso c) throws SQLException{
		String SQL = "update TB_Curso set Nome='"+c.getNome()+"',CargaHoraria='"+c.getCargahoraria()+"',Area='"+c.getArea()+"',Professor='"+c.getProfessor()+"';";
		System.out.println(SQL);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(SQL);
			prepareStatement.executeUpdate();
	        prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
		public void deletar (int id) throws SQLException{
			String SQL ="DELETE FROM TB_Curso WHERE id = '"+id+"'";
			System.out.println(SQL);
			PreparedStatement prepareStatement = this.conn.prepareStatement(SQL);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}
		public List<Curso> listar(){
			String SQL = "select * from TB_Curso";
			System.out.println(SQL);
			List<Curso> cursos = new ArrayList<Curso>();
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(SQL);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					int IdCurso = rs.getInt("idCuros");
					String nome = rs.getString("nome");
					
					System.out.println();					
				
				}
				prepareStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return cursos;
			
		}
		
	}
	
	


