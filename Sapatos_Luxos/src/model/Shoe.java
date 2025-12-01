package model;

public class Shoe {
    private int id;
    private String name;
    private int size;        
    private double price;
    private Category category;

    public Shoe() {}

    public Shoe(int id, String name, int size, double price, Category category) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSize() {           
        return size;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
