package com.ecommerce.ShoppingCart.Dto;

import com.ecommerce.ShoppingCart.Models.Cart;
import com.sun.istack.NotNull;

public class AddToCartDto {
    private Integer id;
    private @NotNull Integer productId;
    private @NotNull Integer quantity;

    public AddToCartDto(){
    }

    public AddToCartDto(Integer id, @NotNull Integer productId, @NotNull Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public AddToCartDto(Cart cart) {
        this.setId(cart.getId());
        this.setProductId(cart.getProductId());
//        this.setUserId(cart.getUserId());
        this.setQuantity(cart.getQuantity());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
