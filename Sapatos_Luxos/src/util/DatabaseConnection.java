package util;
import java.sql.*;
public class DatabaseConnection {
    public static Connection connect(){
        try{
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shoe_store","root","senha"
            );
        }catch(Exception e){System.out.println("Erro na conexão"); return null;}
    }
}
