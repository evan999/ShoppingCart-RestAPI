package com.ecommerce.ShoppingCart.Models;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "Cart")
public class Cart {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column(name = "product_id")
    private Long productId;
    private int quantity;
//    @Column(name = "created_date")
    private Date createdDate;

    private User user;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
    private Product product;

    public Cart() {
    }

    public Cart(Product product, int quantity, User user) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.createdDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
