package com.ecommerce.ShoppingCart;

public class CartItemNotExistException extends IllegalArgumentException {
    public CartItemNotExistException(String message) {
        super(message);
    }
}
