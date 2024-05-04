/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

/**
 *
 * @author italo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.ClassNotFoundException;


public class ConectorBD {
    
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=Loja;encrypt=true;trustServerCertificate=true;user=sa;password=floresta2";
    private static final String usuario = "user=loja;";
    private static final String senha = "password=loja;";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro. Classe não encontrada: ");
            e.printStackTrace();
        }
        return DriverManager.getConnection(url);
    }

    public static PreparedStatement getPrepared(String sql) throws SQLException {
        Connection conn = getConnection();
        return conn.prepareStatement(sql);
    }

    public static ResultSet getSelect(String sql) throws SQLException {
        PreparedStatement ps = getPrepared(sql);
        return ps.executeQuery();
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
