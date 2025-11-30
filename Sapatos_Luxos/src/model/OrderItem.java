package model;

public class OrderItem {
    private int id;
    private Shoe shoe;
    private int quantity;
    public OrderItem(int id,Shoe shoe,int quantity){
        this.id=id;
        this.shoe=shoe;
        this.quantity=quantity;
    }
    public int getId(){
        return id;
    }
    public Shoe getShoe(){
        return shoe;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getTotal(){
        return shoe.getPrice()*quantity;
    }
}
