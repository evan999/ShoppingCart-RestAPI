package com.ecommerce.ShoppingCart.Models;

import com.ecommerce.ShoppingCart.Dto.CartDto;

import java.util.List;

public class CartCost {
    private List<CartDto> cartItems;
    private double totalCost;

    public CartCost(List<CartDto> cartDtoList, double totalCost) {
        this.cartItems = cartDtoList;
        this.totalCost = totalCost;
    }

    public List<CartDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartDto> cartDtoList) {
        this.cartItems = cartDtoList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
