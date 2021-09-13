package com.ecommerce.ShoppingCart.Dto;

import com.ecommerce.ShoppingCart.Models.Cart;
import com.sun.istack.NotNull;

public class AddToCartDto {
    private Integer id;
    private @NotNull Integer userId;
    private @NotNull Long productId;
    private @NotNull Integer quantity;

    public AddToCartDto(){
    }

    public AddToCartDto(Integer id, @NotNull Integer userId, @NotNull Long productId, @NotNull Integer quantity) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public AddToCartDto(Cart cart) {
        this.setId(cart.getId());
        this.setProductId(cart.getProductId());
        this.setUserId(cart.getUserId());
        this.setQuantity(cart.getQuantity());
    }

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
