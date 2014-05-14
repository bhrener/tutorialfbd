package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Aluno;
import modelos.Nota;
import conexao.ConexaoFactory;

public class ControleNota {
	ConexaoFactory cf;
	public ControleNota(){
		cf= new ConexaoFactory();
	}
	
	public void salvarNota(Integer matricula, Float nota, String disciplina){
		Connection con = cf.open();
		PreparedStatement ps = null;
		String sql = "INSERT INTO nota " + "(matriculaAluno, nota, disciplina)"
				+ "VALUES( ?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, matricula);
			ps.setFloat(2, nota);
			ps.setString(3, disciplina);
			ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			cf.close(con, ps, null);
		}
		
	}
	public ArrayList<Nota> listarNotasPorAluno(Integer matricula){
		Connection con = cf.open();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Nota> notas = new ArrayList<Nota>();
		try{
			String sql = "SELECT * FROM Nota where matriculaAluno = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, matricula);
			rs = ps.executeQuery();
			System.out.println(rs.wasNull());
			while(rs.next()){
				Nota nota = new Nota();
				System.out.println(rs.getInt("matriculaAluno"));
				nota.setMatriculaAluno(rs.getInt("matriculaAluno"));
				nota.setNota(rs.getFloat("nota"));
				nota.setDisciplina(rs.getString("disciplina"));
			}
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			cf.close(con, ps, rs);
		}
		return notas;
	}
	public Nota buscarNota(Integer matricula, String disciplina){
		Connection con = cf.open();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Nota nota = new Nota();
		try{
			String sql = "SELECT * FROM Nota where matriculaAluno = ? AND disciplina = ? ";
			ps = con.prepareStatement(sql);
			ps.setInt(1, matricula);
			ps.setString(2, disciplina);
			rs = ps.executeQuery();
			while(rs.next()){
				nota.setMatriculaAluno(rs.getInt("matriculaAluno"));
				nota.setNota(rs.getFloat("nota"));
				nota.setDisciplina(rs.getString("disciplina"));
			}
			return nota;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			cf.close(con, ps, rs);
		}
		return null;
	}
	public void atualizarNota(Integer matricula,String disciplina, Float novaNota){
		Nota nota = buscarNota(matricula,disciplina);
		Connection con = cf.open();
		PreparedStatement ps = null;
		System.out.println(nota.toString());
		if(nota	!= null){
			try{
				String sql = "Update Nota set nota = ? where matriculaAluno = ? AND disciplina = ? ";
				ps = con.prepareStatement(sql);
				ps.setFloat(1, novaNota);
				ps.setInt(2, matricula);
				ps.setString(3, disciplina);
				System.out.println(ps.executeUpdate());
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				cf.close(con, ps, null);
			}
		}
	}
}
