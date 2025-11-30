package dao;

import jdbc.DatabaseConnection;
import model.Order;
import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public void save(Order o) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO orders(customer_id, total) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            stmt.setInt(1, o.getCustomer().getId());
            stmt.setDouble(2, o.getTotal());
            stmt.execute();

            ResultSet keys = stmt.getGeneratedKeys();
            int orderId = 0;
            if (keys.next()) orderId = keys.getInt(1);

            OrderItemDao itemDao = new OrderItemDao();
            itemDao.saveItems(o.getItems(), orderId);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Order> findAll() {
        List<Order> lista = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Order o = new Order(
                        rs.getInt("id"),
                        new Customer(rs.getInt("customer_id"), null, null, null)
                );
                lista.add(o);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
