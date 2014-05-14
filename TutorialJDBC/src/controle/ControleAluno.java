package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Aluno;
import conexao.ConexaoFactory;

public class ControleAluno {
	
	ConexaoFactory cf;
	
	public ControleAluno(){
		cf = new ConexaoFactory();
	}
	
	public void salvar(Integer matricula, String nome, String sexo){
		Connection con = cf.open();
		PreparedStatement ps = null;
		String sql = "INSERT INTO aluno " + "(matricula, nome, sexo)"
				+ "VALUES( ?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, matricula);
			ps.setString(2, nome);
			ps.setString(3, sexo);
			ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			cf.close(con, ps, null);
		}
		
	}
	public ArrayList<Aluno> listarALunos(){
		Connection con = cf.open();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		try{
			String sql = "SELECT * FROM Aluno";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Aluno aluno = new Aluno();
				
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				
				System.out.println((aluno.toString()));
				
				
				alunos.add(aluno);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			cf.close(con, ps, rs);
		}
		return alunos;
	}
	public Aluno buscarAluno(Integer matricula){
		Connection con = cf.open();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Aluno aluno = new Aluno();
		try{
			String sql = "SELECT * FROM Aluno where matricula = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, matricula);
			rs = ps.executeQuery();
			while(rs.next()){
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				System.out.println(aluno.toString());
			}
			return aluno;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			cf.close(con, ps, rs);
		}
		return null;
	}
	public boolean deletarAluno(Integer matricula){
		Aluno aluno = buscarAluno(matricula);
		Connection con = cf.open();
		PreparedStatement ps = null;
		if(aluno != null){
			try{
				String sql = "DELETE FROM Aluno where matricula = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, matricula);
				ps.executeUpdate();
				return true;
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public void atualizarAluno(Integer matricula,String nome){
		Aluno aluno = buscarAluno(matricula);
		Connection con = cf.open();
		PreparedStatement ps = null;
		if(aluno != null){
			try{
				String sql = "Update Aluno set nome= ? where matricula = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, nome);
				ps.setInt(2, matricula);
				System.out.println(ps.executeUpdate());
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				cf.close(con, ps, null);
			}
		}
	}
}
