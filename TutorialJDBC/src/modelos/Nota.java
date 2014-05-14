package modelos;

public class Nota {
	private Integer matriculaAluno;
	private Float nota;
	private String disciplina;
	
	public Nota(){
		
	}
	public Nota(Integer matriculaAluno, Float nota, String disciplina){
		this.matriculaAluno=matriculaAluno;
		this.nota=nota;
		this.disciplina=disciplina;
	}
	public Integer getMatriculaAluno() {
		return matriculaAluno;
	}
	public void setMatriculaAluno(Integer matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	public Float getNota() {
		return nota;
	}
	public void setNota(Float nota) {
		this.nota = nota;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	@Override
	public String toString() {
		return "Nota [matriculaAluno=" + matriculaAluno + ", nota=" + nota
				+ ", disciplina=" + disciplina + "]";
	}
	
}
