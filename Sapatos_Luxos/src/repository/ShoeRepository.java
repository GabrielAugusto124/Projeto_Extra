package repository;
import model.Category;
import model.Shoe;
import jdbc.DatabaseConnection;

import java.sql.*;
public class ShoeRepository {
    public void save(Shoe s){
        try{
            Connection conn=DatabaseConnection.connect();
            PreparedStatement stmt=conn.prepareStatement(
                "INSERT INTO shoe(name,size,price,category) VALUES(?,?,?,?)"
            );
            stmt.setString(1,s.getName());
            stmt.setInt(2,s.getSize());
            stmt.setDouble(3,s.getPrice());
            stmt.setString(4,s.getCategory().name());
            stmt.execute(); conn.close();
        }catch(Exception e){e.printStackTrace();}
    }
    public void findAll(){
        try{
            Connection conn=DatabaseConnection.connect();
            ResultSet rs=conn.prepareStatement("SELECT * FROM shoe").executeQuery();
            while(rs.next()){
                System.out.println(
                    rs.getInt("id")+" - "+rs.getString("name")+
                    " - R$"+rs.getDouble("price")
                );
            }
            conn.close();
        }catch(Exception e){e.printStackTrace();}
    }
    public Shoe findById(int id){
        try{
            Connection conn=DatabaseConnection.connect();
            PreparedStatement stmt=conn.prepareStatement("SELECT * FROM shoe WHERE id=?");
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                return new Shoe(
                    rs.getInt("id"),rs.getString("name"),
                    rs.getInt("size"),rs.getDouble("price"),
                    Category.valueOf(rs.getString("category"))
                );
            }
            conn.close();
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
}
