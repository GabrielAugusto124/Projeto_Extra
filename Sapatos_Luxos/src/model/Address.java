package model;
public class Address {
    private String cep, street, city, state;
    public Address(){
    }
    public Address(String cep,String street,String city,String state){
        this.cep=cep;
        this.street=street;
        this.city=city;
        this.state=state;
    }
    public String getCep(){
        return cep;}
    public String getStreet(){
        return street;
    }
    public String getCity(){
        return city;
    } public String getState(){
        return state;
    }
}
