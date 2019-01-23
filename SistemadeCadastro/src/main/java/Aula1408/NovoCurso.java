package Aula1408;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Container;
import java.sql.Connection;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controler.CursoJdbcDao;
import Controler.JdbUtil;
import Model.Curso;

public class NovoCurso extends JFrame {
		
		JLabel lblnome = new  JLabel("Nome:");
		JLabel lblarea = new JLabel("Area do curso:");
		JLabel lblcargahoraria = new JLabel("Carga Horaria:");
		JLabel lblprofessor = new JLabel("Professor:");
		JLabel lblEdicoes = new JLabel("ID a ser alterado");
		
		JTextField txtnome = new JTextField();
		JTextField txtarea = new JTextField();
		JTextField txtcargahoraria = new JTextField();
		JTextField txtprofessor = new JTextField();	
		JTextField txtedicoes= new JTextField();
		
		JButton  btnSalvar = new JButton ("Gravar");
		JButton  btnEdicoes = new JButton ("Edicoes");
		JButton  btnDeletar = new JButton ("Deletar");	

		
		public NovoCurso() {                 
			super("Novo Curso");
			
			Container paine = this.getContentPane();
			paine.setLayout(null);	
			
			paine.add(lblnome);
			lblnome.setBounds(10, 15, 45, 30);
			paine.add(txtnome);
			txtnome.setBounds(100, 15, 255, 30);
			
			paine.add(lblarea);
			lblarea.setBounds(10, 50,45,30);
			paine.add(txtarea);
			txtarea.setBounds(100, 50, 255,30);
			
			
			paine.add(lblcargahoraria);
			lblcargahoraria.setBounds(10, 85, 90, 30);
			paine.add(txtcargahoraria);
			txtcargahoraria.setBounds(100, 85, 255,30);			

			paine.add(lblprofessor);
			lblprofessor.setBounds(10,120,110,30);
			paine.add(txtprofessor);
			txtprofessor.setBounds(100,120,255,30);
			paine.add(lblEdicoes);
			lblEdicoes.setBounds(400, 15, 200, 30);
			paine.add(txtedicoes);
			txtedicoes.setBounds(400,50, 200, 30);		
			
			paine.add(btnSalvar);
			btnSalvar.setBounds(10, 155, 130, 50);			
			
			paine.add(btnEdicoes);
			btnEdicoes.setBounds(400, 155, 130, 50);
			
			paine.add(btnDeletar);
			btnDeletar.setBounds(550, 155, 130, 50);
			
			btnDeletar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int id= Integer.parseInt(txtedicoes.getText());		
						Curso cursos = new Curso();
						
						cursos.setIdCurso(Integer.parseInt(txtedicoes.getText()));
						
						Connection connection = JdbUtil.getConnection();
						CursoJdbcDao CursoJdbcDao = new CursoJdbcDao(connection);
						CursoJdbcDao.deletar(id);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}
			});		
		
			
			
			btnEdicoes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int id= Integer.parseInt(txtedicoes.getText());		
						Curso cursos = new Curso();
						
						cursos.setIdCurso(Integer.parseInt(txtedicoes.getText()));
						cursos.setNome(txtnome.getText());
						cursos.setCargahoraria(txtcargahoraria.getText());
						cursos.setProfessor(txtprofessor.getText());
						cursos.setArea(txtarea.getText());
						
						
						Connection connection = JdbUtil.getConnection();
						CursoJdbcDao CursoJdbcDao = new CursoJdbcDao(connection);
						CursoJdbcDao.alterar(cursos);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}
			});		
		

			
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Curso cursos = new Curso();
						cursos.setNome(txtnome.getText());
						cursos.setCargahoraria(txtcargahoraria.getText());
						cursos.setProfessor(txtprofessor.getText());
						cursos.setArea(txtarea.getText());					
						
						Connection connection = JdbUtil.getConnection();
						CursoJdbcDao CursoJdbcDao = new CursoJdbcDao(connection);
						CursoJdbcDao.salvar(cursos);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}
			});		
		
		
	
		this.setResizable(true);               					 // Possivel redimensionar com o mouse
		this.setVisible(true);				 					 //  Se é visivel 
		this.setSize(700, 300);			    				 	 //  Tamanho da Janela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Corta a execusão até em 2°plano
	}
		
		public static void main( String[] args ) {
			NovoCurso novocurso = new NovoCurso();
		}
		  
	

}
