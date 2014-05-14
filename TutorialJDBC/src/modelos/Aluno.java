package modelos;

public class Aluno {
	
	
	private Integer matricula;
	private String nome;
	private String sexo;
	
	
	
	public Aluno(){
		
	}
	
	
	public Aluno(Integer matricula, String nome, String sexo){
		this.matricula=matricula;
		this.nome=nome;
		this.sexo=sexo;
	}


	public Integer getMatricula() {
		return matricula;
	}


	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", sexo="
				+ sexo + "]";
	}
	
	
}
