package service;
import repository.CustomerRepository;
import model.Address;
import model.Customer;

public class CustomerService {
    private CustomerRepository repo=new CustomerRepository();
    private ApiService api=new ApiService();
    public void createCustomer(String name,String cpf,String cep){
        Address address=api.getAddressByCep(cep);
        Customer c=new Customer(0,name,cpf,address);
        repo.save(c);
        System.out.println("Cliente cadastrado com sucesso!");
    }
    public void listCustomers(){repo.findAll();}
}
