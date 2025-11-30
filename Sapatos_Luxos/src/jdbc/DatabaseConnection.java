package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/sapatos_luxos";
    private static final String USER = "root";

    private static final String PASSWORD = "Gabriel10";

    public static Connection connect() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Conectado ao banco com sucesso!");
            return conn;

        } catch (Exception e) {
            System.out.println(" Erro ao conectar ao banco:");
            e.printStackTrace();
            return null;
        }
    }
}

