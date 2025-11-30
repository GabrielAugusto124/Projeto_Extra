package model;

import java.util.ArrayList;
import java.util.List;
public class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> items=new ArrayList<>();
    private double total;
    public Order(int id,Customer customer){
        this.id=id; this.customer=customer;
    }
    public void addItem(OrderItem item){
        items.add(item); calculateTotal();
    }
    private void calculateTotal(){
        total=0; for(OrderItem i:items){
            total+=i.getTotal();
        }
    }
    public int getId(){
        return id;
    }
    public Customer getCustomer(){
        return customer;
    }
    public double getTotal(){
        return total;
    } public List<OrderItem> getItems(){
        return items;
    }
}
