package com.ecommerce.ShoppingCart.Models;

import com.ecommerce.ShoppingCart.Dto.CartDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "product_id")
    private Integer productId;

    private Integer userId;
    private int quantity;
    @Column(name = "created_date")
    private Date createdDate;

//    private User user;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
    private Product product;


    public Cart() {
    }

    public Cart(CartDto cartDto, Product product, int userId) {
        this.userId = userId;
        this.productId = cartDto.getProductId();
        this.createdDate = new Date();
        this.product = product;
        this.quantity = quantity;
    }

    public Cart(Integer userId, Integer productId, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.createdDate = new Date();
        this.quantity = quantity;
    }

    public Cart(CartDto cartDto, Product product) {
        this.productId = cartDto.getProductId();
        this.quantity = cartDto.getQuantity();
        this.product = product;
        this.createdDate = new Date();
    }

//    public Cart(Product product, int quantity, Integer userId) {
//        this.userId = userId;
//        this.product = product;
//        this.quantity = quantity;
//        this.createdDate = new Date();
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
