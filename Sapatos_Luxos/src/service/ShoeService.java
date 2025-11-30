package service;
import repository.ShoeRepository;
import model.Category;
import model.Shoe;

public class ShoeService {
    private ShoeRepository repo=new ShoeRepository();
    public void createShoe(String name, int size, double price, Category category){
        Shoe s=new Shoe(0,name,size,price,category);
        repo.save(s);
        System.out.println("Sapato cadastrado!");
    }
    public void listShoes(){repo.findAll();}
}
