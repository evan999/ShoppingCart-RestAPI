package com.ecommerce.ShoppingCart.Controllers;

import com.ecommerce.ShoppingCart.Dto.AddToCartDto;
import com.ecommerce.ShoppingCart.Exceptions.AuthenticationFailException;
import com.ecommerce.ShoppingCart.Models.Cart;
import com.ecommerce.ShoppingCart.Repositories.CartRepository;
import com.ecommerce.ShoppingCart.Services.CartService;
import com.ecommerce.ShoppingCart.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException)  {

    }


=
}
