package com.ecommerce.ShoppingCart.Exceptions;

public class CartItemNotExistException extends IllegalArgumentException {
    public CartItemNotExistException(String message) {
        super(message);
    }
}
