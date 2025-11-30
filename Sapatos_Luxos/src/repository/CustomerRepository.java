package repository;
import model.Address;
import model.Customer;
import util.DatabaseConnection;
import java.sql.*;
public class CustomerRepository {
    public void save(Customer c){
        try{
            Connection conn=DatabaseConnection.connect();
            PreparedStatement stmt=conn.prepareStatement(
                "INSERT INTO customer(name,cpf,cep,street,city,state) VALUES(?,?,?,?,?,?)"
            );
            stmt.setString(1,c.getName()); stmt.setString(2,c.getCpf());
            stmt.setString(3,c.getAddress().getCep());
            stmt.setString(4,c.getAddress().getStreet());
            stmt.setString(5,c.getAddress().getCity());
            stmt.setString(6,c.getAddress().getState());
            stmt.execute(); conn.close();
        }catch(Exception e){e.printStackTrace();}
    }
    public void findAll(){
        try{
            Connection conn=DatabaseConnection.connect();
            ResultSet rs=conn.prepareStatement("SELECT * FROM customer").executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id")+" - "+rs.getString("name")+" - "+rs.getString("cpf"));
            }
            conn.close();
        }catch(Exception e){e.printStackTrace();}
    }
    public Customer findById(int id){
        try{
            Connection conn=DatabaseConnection.connect();
            PreparedStatement stmt=conn.prepareStatement("SELECT * FROM customer WHERE id=?");
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                Address a=new Address(rs.getString("cep"),rs.getString("street"),
                                      rs.getString("city"),rs.getString("state"));
                return new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("cpf"),a);
            }
            conn.close();
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
}
