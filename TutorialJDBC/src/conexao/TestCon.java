package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import controle.ControleAluno;
import controle.ControleNota;

public class TestCon {
	private static ControleAluno ca;
	private static ControleNota cn;
	
	public TestCon(){
		ca= new ControleAluno();
		cn = new ControleNota();
	}
	public static void main(String[] args) {
		int opcao = -1;
		//Façam aqui suas opções...
//		Scanner sc = new Scanner(System.in);
//		opcao = sc.nextInt();
//		
//		while(opcao != 0){
//			switch (opcao) {
//			case 1:
//				System.out.println("++++++    Salvar Aluno ++++++");
//				ca = new ControleAluno();
//				ca.salvar(1234, "Erick", "Masculino");
//				break;
//			case 2:
//				break;
//			case 3:
//				break;
//			case 4:
//				break;
//			case 5:
//				
//				break;
//			default:
//				break;
//			}
//		}
		
	}
	public static void listarOpcoes(){
		System.out.println("1- Salvar aluno");
		System.out.println("2- Listar alunos");
		System.out.println("3- Atualizar aluno");
		System.out.println("4- Deletar aluno");
		System.out.println("5- Inserir nota");
		System.out.println("6- Listar notas para um usuario");
		System.out.println("7- Atualizar nota");
		System.out.println("Para sair: 0 ");
	}

}
