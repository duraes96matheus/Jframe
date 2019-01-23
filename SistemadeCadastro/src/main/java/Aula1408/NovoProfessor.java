package Aula1408;

import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.sql.Connection;


import Controler.JdbUtil;
import Controler.ProfessoresjdbcDAO;
import Model.Professor;


public class NovoProfessor extends JFrame {
	
		
		JLabel lblnome = new  JLabel("Nome:");
		JLabel lblCursoMinistrado = new JLabel("Curso Ministrado :");
		JLabel lblIDCurso  = new JLabel("ID Curso");
		JLabel lblEdicoes = new JLabel("ID a ser Alterado");
		
		JTextField  txtnome = new JTextField();
		JTextField  txtCursoMinistrado = new JTextField();
		JTextField  txtIDcurso = new JTextField();
		TextField txtediceos = new TextField();
		
		JButton  btnSalvar = new JButton ("Gravar");
		JButton  btnEditar = new JButton ("Editar");
		JButton  btnDeletar = new JButton ("Deletar");
		
		
		public NovoProfessor()  {                  // Definindo parametros da Classe
			super("Novo Professor");		
		
		Container paine = this.getContentPane();
		paine.setLayout(null);	
		
		paine.add(lblnome);
		lblnome.setBounds(50, 15, 80, 30);
		paine.add(txtnome);
		txtnome.setBounds(130, 15, 255, 30);	
		
		paine.add(lblCursoMinistrado);
		lblCursoMinistrado.setBounds(10, 50, 120, 30);
		paine.add(txtCursoMinistrado);
		txtCursoMinistrado.setBounds(130, 50, 255, 30);	
		
		paine.add(lblIDCurso);
		lblIDCurso.setBounds(50, 85,120, 30);
		paine.add(txtIDcurso);
		txtIDcurso.setBounds(130, 85, 255, 30);
		paine.add(lblEdicoes);
		lblEdicoes.setBounds(500, 15, 200, 30);
		paine.add(txtediceos);
		txtediceos.setBounds(450,50, 200, 30);
		
		paine.add(btnEditar);
		btnEditar.setBounds(400, 120, 130, 50);
		
		paine.add(btnDeletar);
		btnDeletar.setBounds(550, 120, 130, 50);
		
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(90, 120, 130, 50);
		
		btnDeletar.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				try {
					int id= Integer.parseInt(txtediceos.getText());	
					
					Professor professor = new Professor();
					
					professor.setID(Integer.parseInt(txtediceos.getText()));
					
					Connection connection = JdbUtil.getConnection();
					ProfessoresjdbcDAO professoresjdbcDAO = new ProfessoresjdbcDAO(connection);
					professoresjdbcDAO.deletar(id);				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		btnEditar.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				try {
					int id= Integer.parseInt(txtediceos.getText());	
					
					Professor professor = new Professor();
					
					professor.setID(Integer.parseInt(txtediceos.getText()));
					
					professor.setNome(txtnome.getText());
					professor.setIDCurso(txtCursoMinistrado.getText());
					professor.setIDCurso(txtIDcurso.getText());
					
					Connection connection = JdbUtil.getConnection();
					ProfessoresjdbcDAO professoresjdbcDAO = new ProfessoresjdbcDAO(connection);
					professoresjdbcDAO.alterar(professor);					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnSalvar.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				try {
					Professor professor = new Professor();
					
					professor.setNome(txtnome.getText());
					professor.setIDCurso(txtCursoMinistrado.getText());
					professor.setIDCurso(txtIDcurso.getText());
					
					Connection connection = JdbUtil.getConnection();
					ProfessoresjdbcDAO professoresjdbcDAO = new ProfessoresjdbcDAO(connection);
					professoresjdbcDAO.salvar(professor);					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
				this.setResizable(true);               					 // Possivel redimensionar com o mouse
				this.setVisible(true);				 					 //  Se é visivel 
				this.setSize(700, 250);			    				 	 //  Tamanho da Janela5
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Corta a execusão até em 2°plano	
			}

		    public static void main( String[] args )
		    {
		       NovoProfessor novoprofessor = new NovoProfessor();
		       
		    }
	
}
		