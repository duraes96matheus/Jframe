package Aula1408;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controler.CoordenadorjdbcDAO;
import Controler.JdbUtil;
import Controler.ProfessoresjdbcDAO;
import Model.Coordenador;
import Model.Professor;

public class NovoCoordenador extends JFrame {

	JLabel lblnome = new  JLabel("Nome:");
	JLabel lblCursosCoordenados = new JLabel("Cursos Coordenados:");
	JLabel lblIDcurosCoordenados = new JLabel("ID Cursos Coordenados:");
	JLabel lblEdicoes = new JLabel("ID a ser alterado");
	JTextField txtedicoes= new JTextField();
	
	JTextField  txtnome = new JTextField();
	JTextField  txtCursosCoordenado = new JTextField();
	JTextField  txtIDcurosCoordenados = new JTextField();		
	
	JButton  btnSalvar = new JButton ("Gravar");
	JButton  btnEditar = new JButton ("Editar");
	JButton  btnDeletar = new JButton ("Deletar");
	
	
	public NovoCoordenador()  {                  // Definindo parametros da Classe
		super("Cadastro de Coordenadores");		
	
	Container paine = this.getContentPane();
	paine.setLayout(null);	
	
	paine.add(lblnome);
	lblnome.setBounds(70, 15, 70, 30);
	paine.add(txtnome);
	txtnome.setBounds(150, 15, 255, 30);
	
	paine.add(lblCursosCoordenados);
	lblCursosCoordenados.setBounds(15, 50, 140, 30);
	paine.add(txtCursosCoordenado);
	txtCursosCoordenado.setBounds(150, 50, 255,30);	

	paine.add(lblIDcurosCoordenados);
	lblIDcurosCoordenados.setBounds(10,85,140,30);
	paine.add(txtIDcurosCoordenados);
	txtIDcurosCoordenados.setBounds(150,85,255,30);
	
	paine.add(lblEdicoes);
	lblEdicoes.setBounds(500, 15, 200, 30);
	paine.add(txtedicoes);
	txtedicoes.setBounds(500,50, 70, 30);	
	
	paine.add(btnEditar);
	btnEditar.setBounds(400, 155, 130, 50);
	
	paine.add(btnDeletar);
	btnDeletar.setBounds(550, 155, 130, 50);
	paine.add(btnSalvar);
	
	btnSalvar.setBounds(10, 120, 130, 50);
	
	btnDeletar.addActionListener(new ActionListener (){
		public void actionPerformed(ActionEvent e) {
			try {
				Coordenador Coordenador = new Coordenador();
				Coordenador.setId(txtedicoes.getText());	
				
				Connection connection = JdbUtil.getConnection();
				CoordenadorjdbcDAO coordenadorjdbcDAO = new CoordenadorjdbcDAO(connection);
				coordenadorjdbcDAO.deletar(Coordenador);					
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
	});
	
	
	btnEditar.addActionListener(new ActionListener (){
		public void actionPerformed(ActionEvent e) {
			try {
				Coordenador Coordenador = new Coordenador();
				Coordenador.setId(txtedicoes.getText());
				Coordenador.setNome(txtnome.getText());
				Coordenador.setCursosCoordenados(txtCursosCoordenado.getText());
				Coordenador.setIDcurosCoordenados(txtIDcurosCoordenados.getText());
			
				
				Connection connection = JdbUtil.getConnection();
				CoordenadorjdbcDAO coordenadorjdbcDAO = new CoordenadorjdbcDAO(connection);
				coordenadorjdbcDAO.alterar(Coordenador);					
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
	});	
	
	btnSalvar.addActionListener(new ActionListener (){
		public void actionPerformed(ActionEvent e) {
			try {
				Coordenador Coordenador = new Coordenador();
				Coordenador.setNome(txtnome.getText());
				Coordenador.setCursosCoordenados(txtCursosCoordenado.getText());
				Coordenador.setIDcurosCoordenados(txtIDcurosCoordenados.getText());
			
				
				Connection connection = JdbUtil.getConnection();
				CoordenadorjdbcDAO coordenadorjdbcDAO = new CoordenadorjdbcDAO(connection);
				coordenadorjdbcDAO.salvar(Coordenador);					
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
	    	NovoCoordenador NovoCoordenador = new NovoCoordenador();
	       
	    }

}
