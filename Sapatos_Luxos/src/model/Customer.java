package model;

public class Customer extends Person {
    private Address address;
    public Customer(){
    }
    public Customer(int id,String name,String cpf,Address address){
        super(id,name,cpf);
        this.address=address;
    }
    public Address getAddress(){
        return address;
    }
    public void setAddress(Address address){
        this.address=address;
    }
}
