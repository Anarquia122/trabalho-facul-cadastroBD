/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

/**
 *
 * @author italo
 */
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class BookDAO {

    private Connection connection;

    public BookDAO() {
        String url = "jdbc:sqlserver://ALENOTE;DatabaseName=Loja;IntegratedSecurity=true;user=loja;password=loja;encrypt=true;trustServerCertificate=true;";

        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco de dados:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BookDAO();
    }
}
