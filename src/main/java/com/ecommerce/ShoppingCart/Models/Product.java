package com.ecommerce.ShoppingCart.Models;

import com.ecommerce.ShoppingCart.Dto.ProductDto;

import java.util.List;

public class Product {

    private Integer id;
    private String name;
    private double price;
    private String description;
    private String imageURL;

    Category category;
    // private List<Cart> carts;
    public Product(){

    }

//    public Product(ProductDto productDto, Category category) {
//        this.name = productDto.getName();
//        this.imageURL = productDto.getImageURL();
//        this.description = productDto.getDescription();
//        this.price = productDto.getPrice();
//        this.category = category;
//    }

    public Product(String name, double price, String description, String imageURL, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.category = category;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }



}
