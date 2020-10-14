package com.pluralsight.candycoded;

public class Candy {
    public int id;
    public String name;
    public String image;
    public String price;
    public String description;

    public Candy(String name, String image, String price, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
    }
}
