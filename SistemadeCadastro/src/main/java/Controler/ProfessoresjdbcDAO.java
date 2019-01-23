package Controler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;

import Model.Professor;

public class ProfessoresjdbcDAO {
	
	private Connection conn;
	
	public ProfessoresjdbcDAO (Connection conn) {
		this.conn=conn;
	
	}public void salvar(Professor c) throws SQLException{
		String SQL = "insert into TB_Professor (Nome,CursoMinistrado,ID_Cursos) values ('"+c.getNome()+"','"+c.getCursoMinistrado()+"','"+c.getIDCurso()+"')";
		System.out.println(SQL);
		PreparedStatement prepareStatement=(PreparedStatement) this.conn.prepareStatement(SQL);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		
	}public void alterar(Professor c)throws SQLException{
		String SQL= "uptade  TB_Professor set Nome='"+c.getNome()+"',CursoMinistrado='"+c.getCursoMinistrado()+"',ID_Cursos='"+c.getIDCurso()+"')";
		System.out.println(SQL);
		PreparedStatement prepareStatement=(PreparedStatement) this.conn.prepareStatement(SQL);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void deletar (int id) throws SQLException{
		String SQL="DELETE FROM TB_Professor WHERE id = '"+id+"'";
		System.out.println(SQL);
		java.sql.PreparedStatement prepareStatement = this.conn.prepareStatement(SQL);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		
	}
	public List<Professor> listar() {
		String SQL = "select * from TB_Professor";
        System.out.println(SQL);		
        List<Professor> professores = new ArrayList<Professor>();
		try {
			PreparedStatement prepareStatement = (PreparedStatement) this.conn.prepareStatement(SQL);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			 /* id = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				Alunos aluno = new Alunos();
				System.out.println();**/
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professores;
	}
	
	

}
