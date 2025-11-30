package dao;

import jdbc.DatabaseConnection;
import model.Shoe;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShoeDao {

    public List<Shoe> findAll() {
        List<Shoe> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM shoe");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Shoe s = new Shoe(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("size"),
                        rs.getDouble("price"),
                        Category.valueOf(rs.getString("category"))
                );

                list.add(s);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
