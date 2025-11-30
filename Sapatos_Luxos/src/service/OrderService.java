package service;
import model.Customer;
import model.Order;
import model.OrderItem;
import model.Shoe;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.ShoeRepository;

public class OrderService {
    private OrderRepository orderRepo=new OrderRepository();
    private CustomerRepository custRepo=new CustomerRepository();
    private ShoeRepository shoeRepo=new ShoeRepository();
    public void createOrder(int custId,int shoeId,int qty){
        Customer c=custRepo.findById(custId);
        Shoe s=shoeRepo.findById(shoeId);
        Order o=new Order(0,c);
        OrderItem item=new OrderItem(0,s,qty);
        o.addItem(item);
        orderRepo.save(o);
        System.out.println("Pedido criado!");
    }
    public void listOrders(){orderRepo.findAll();}
}
