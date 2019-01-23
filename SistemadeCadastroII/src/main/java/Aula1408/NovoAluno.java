package Aula1408;

import java.awt.Container;
import java.awt.TextField;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controler.AlunosjdbcDAO;
import Controler.JdbUtil;
import Model.Alunos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


	public class NovoAluno extends JFrame {
		
		JLabel lblnome = new JLabel ("Nome:");
		JLabel lblendereco = new JLabel("Endereço:");
		JLabel lbltelefone = new JLabel("Telefone:");
		JLabel lblcursoscursados = new JLabel("Cursos Cursados:");
		JLabel lblidcursos= new JLabel("ID Curso");
		JLabel lblEdicoes = new JLabel("ID a ser Alterado");
		
		TextField txtnome = new TextField(); 
		TextField txtendereco= new TextField();
		TextField txttelefone = new TextField();
		TextField txtcursoscursados = new TextField();
		TextField txtidcurso = new TextField();
		TextField txtediceos = new TextField();
		
		
		JButton btnGravar = new JButton("Gravar");
		JButton btnedicoes = new JButton("Editar");
		JButton btnDeletar = new JButton("Deletar");		
		
		public NovoAluno() {                  // Definindo parametros da Classe
			super("Novo Aluno ");	
		
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		
		paine.add(lblEdicoes);
		lblEdicoes.setBounds(400, 15, 200, 30);
		paine.add(txtediceos);
		txtediceos.setBounds(400,50, 200, 30);		
		
		paine.add(lblnome);
		lblnome.setBounds(10, 15, 45, 30);
		paine.add(txtnome);
		txtnome.setBounds(90, 15, 255, 30);
		
		paine.add(lblendereco);
		lblendereco.setBounds(10, 50, 70, 30);
		paine.add(txtendereco);
		txtendereco.setBounds(90, 50, 255,30);
		
		paine.add(lbltelefone);
		lbltelefone.setBounds(10, 85, 70,30);
		paine.add(txttelefone);
		txttelefone.setBounds(90, 85, 255,30);
		
		paine.add(lblcursoscursados);
		lblcursoscursados.setBounds(10,120,70,30);
		paine.add(txtcursoscursados);
		txtcursoscursados.setBounds(90,120,255,30);
		
		paine.add(lblidcursos);
		lblidcursos.setBounds(10,155,70,30);
		paine.add(txtidcurso);
		txtidcurso.setBounds(90,155,255,30);
		
		paine.add(btnGravar);
		btnGravar.setBounds(10, 200, 130, 50);		

		paine.add(btnedicoes);
		btnedicoes.setBounds(400, 200, 130, 50);
		
		paine.add(btnDeletar);
		btnDeletar.setBounds(550, 200, 130, 50);
		
		btnedicoes.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				try {
					Alunos aluno = new Alunos();
					aluno.setId(txtediceos.getText());
					
										
					Connection connection = JdbUtil.getConnection();
					AlunosjdbcDAO alunosjdbcDAO = new AlunosjdbcDAO(connection);
					aluno.setId(txtediceos.getText());					
			//		alunosjdbcDAO.deletar(id);

				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			
		}});
		
		
		
		btnedicoes.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				try {
					Alunos aluno = new Alunos();
					aluno.setId(txtediceos.getText());
					aluno.setNome(txtnome.getText());
					aluno.setEndereco(txtendereco.getText());
					aluno.setTelefone(txttelefone.getText());
					aluno.setCursocursado(txtcursoscursados.getText());
					aluno.setIdCurso(txtidcurso.getText());
					
					Connection connection = JdbUtil.getConnection();
					AlunosjdbcDAO alunosjdbcDAO = new AlunosjdbcDAO(connection);
					alunosjdbcDAO.alterar(aluno);
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			
		}});
		
		
		
		btnGravar.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				try {
					Alunos aluno = new Alunos();
					aluno.setNome(txtnome.getText());
					aluno.setEndereco(txtendereco.getText());
					aluno.setTelefone(txttelefone.getText());
					aluno.setCursocursado(txtcursoscursados.getText());
					aluno.setIdCurso(txtidcurso.getText());
										
					Connection connection = JdbUtil.getConnection();
					AlunosjdbcDAO alunosjdbcDAO = new AlunosjdbcDAO(connection);
					alunosjdbcDAO.salvar(aluno);
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			
		}});
		
		
		
		
		this.setResizable(true);               					 // Possivel redimensionar com o mouse
		this.setVisible(true);				 					 //  Se é visivel 
		this.setSize(700, 300);			    				 	 //  Tamanho da Janela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Corta a execusão até em 2°plano
		
		
		}
		 public static void main( String[] args ) {
			 
			NovoAluno novoaluno = new NovoAluno();
			
		}
	

}
