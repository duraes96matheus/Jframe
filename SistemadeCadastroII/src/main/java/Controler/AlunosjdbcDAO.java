package Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Alunos;

public class AlunosjdbcDAO {
	
	private Connection conn;
	
	public AlunosjdbcDAO(Connection conn) {
		this.conn=conn;
	}
		public void salvar(Alunos c) throws SQLException {
			String sql = "insert into TB_Aluno (nome, Endereco, Telefone ,CursoCursados,IDCurso) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getTelefone()+"','"+c.getCursocursado()+"','"+c.getIdCurso()+"')";
			System.out.println(sql);
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
	        prepareStatement.close();
		}
	
	public void alterar (Alunos c ) {
	String sql = "update TB_Aluno set nome='"+c.getNome()+"',Endereco='"+c.getEndereco()+"',Telefone='"+c.getTelefone()+"',CursoCursados='"+c.getCursocursado()+"',IDCurso='"+c.getIdCurso()+"';";
	System.out.println(sql);
	PreparedStatement prepareStatement;
	try {
		prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}		
	
	}
	public void deletar (Alunos id) throws SQLException{
		String sql="DELETE FROM TB_Aluno WHERE id = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public List<Alunos> listar() {
		String sql = "select * from TB_Aluno";
        System.out.println(sql);		
        List<Alunos> alunos = new ArrayList<Alunos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			 	int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String Telefone = rs.getString("endereco");
				String CursoCursados = rs.getString("bairro");		
				Alunos aluno = new Alunos();
				System.out.println();
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	
	}
	
}
