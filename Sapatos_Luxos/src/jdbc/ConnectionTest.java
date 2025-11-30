package jdbc;

import java.sql.Connection;
import jdbc.DatabaseConnection;

public class ConnectionTest {

    public static void main(String[] args) {

        Connection conn = DatabaseConnection.connect();

        if (conn != null) {
            System.out.println("Teste de conexão concluído com sucesso!");
        } else {
            System.out.println("Falha no teste de conexão.");
        }
    }
}

