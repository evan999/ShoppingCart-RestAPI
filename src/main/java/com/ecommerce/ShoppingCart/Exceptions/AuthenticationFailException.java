package com.ecommerce.ShoppingCart.Exceptions;

public class AuthenticationFailException extends IllegalArgumentException {
    public AuthenticationFailException(String message) {
        super(message);
    }
}
