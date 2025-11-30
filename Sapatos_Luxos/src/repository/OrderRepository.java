package repository;
import model.Order;
import model.OrderItem;
import util.DatabaseConnection;
import java.sql.*;
public class OrderRepository {
    public void save(Order o){
        try{
            Connection conn=DatabaseConnection.connect();
            PreparedStatement stmt=conn.prepareStatement(
                "INSERT INTO orders(customer_id,total) VALUES(?,?)",
                Statement.RETURN_GENERATED_KEYS
            );
            stmt.setInt(1,o.getCustomer().getId());
            stmt.setDouble(2,o.getTotal());
            stmt.execute();
            ResultSet keys=stmt.getGeneratedKeys();
            int orderId=0;
            if(keys.next()) orderId=keys.getInt(1);

            for(OrderItem it:o.getItems()){
                PreparedStatement itemStmt=conn.prepareStatement(
                    "INSERT INTO order_item(order_id,shoe_id,quantity) VALUES(?,?,?)"
                );
                itemStmt.setInt(1,orderId);
                itemStmt.setInt(2,it.getShoe().getId());
                itemStmt.setInt(3,it.getQuantity());
                itemStmt.execute();
            }

            conn.close();
        }catch(Exception e){e.printStackTrace();}
    }

    public void findAll(){
        try{
            Connection conn=DatabaseConnection.connect();
            ResultSet rs=conn.prepareStatement("SELECT * FROM orders").executeQuery();
            while(rs.next()){
                System.out.println("Pedido "+rs.getInt("id")+" - Total: R$"+rs.getDouble("total"));
            }
            conn.close();
        }catch(Exception e){e.printStackTrace();}
    }
}
