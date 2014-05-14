package conexao;
import java.sql.*;
public class ConexaoFactory {
    private static final String URL = "jdbc:postgresql://localhost:5433/tutorialjdbc";
    private static final String USER = "postgres";
    private static final String PASS = "erick";
 
    public static Connection open() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectou");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
 
    public static void close(Connection conn,
                             PreparedStatement pstm, ResultSet rs)
    {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
               rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
