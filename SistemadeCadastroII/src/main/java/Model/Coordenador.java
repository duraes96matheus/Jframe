package Model;

public class Coordenador {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCursosCoordenados() {
		return CursosCoordenados;
	}
	public void setCursosCoordenados(String cursosCoordenados) {
		CursosCoordenados = cursosCoordenados;
	}
	public String getIDcurosCoordenados() {
		return IDcurosCoordenados;
	}
	public void setIDcurosCoordenados(String iDcurosCoordenados) {
		IDcurosCoordenados = iDcurosCoordenados;
	}
	private String nome;
	private String CursosCoordenados;
	private String IDcurosCoordenados;

	
}