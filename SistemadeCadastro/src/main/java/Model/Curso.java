package Model;

public class Curso {
	
	private Integer idCurso;
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	private String nome;
	private String Area;
	private String professor;
	private String cargahoraria;

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getCargahoraria() {
		return cargahoraria;
	}
	public void setCargahoraria(String cargahoraria) {
		this.cargahoraria = cargahoraria;
	}
	
	
}

