package dao;

import jdbc.DatabaseConnection;
import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public void save(Customer c) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO customer(name, cpf) VALUES (?, ?)"
            );
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getCpf());
            stmt.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Customer c = new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("cpf"),
                        null
                );
                list.add(c);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
