package com.ecommerce.ShoppingCart.Controllers;

import com.ecommerce.ShoppingCart.Dto.AddToCartDto;
import com.ecommerce.ShoppingCart.Models.Cart;
import com.ecommerce.ShoppingCart.Repositories.CartRepository;
import com.ecommerce.ShoppingCart.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class CartController {
    @RestController
    @RequestMapping("/cart")

    public class CartController {
        @Autowired
        private CartService cartService;

        @Autowired
        private ProductService productService;
    }
}
