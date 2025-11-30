package dao;

import jdbc.DatabaseConnection;
import model.OrderItem;
import java.sql.*;
import java.util.List;

public class OrderItemDao {

    public void saveItems(List<OrderItem> items, int orderId) {
        try {
            Connection conn = DatabaseConnection.connect();

            for (OrderItem i : items) {
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO order_item(order_id, shoe_id, quantity) VALUES (?, ?, ?)"
                );

                stmt.setInt(1, orderId);
                stmt.setInt(2, i.getShoe().getId());
                stmt.setInt(3, i.getQuantity());
                stmt.execute();
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
