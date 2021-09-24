package com.ecommerce.ShoppingCart.Controllers;

import com.ecommerce.ShoppingCart.Common.ApiResponse;
import com.ecommerce.ShoppingCart.Dto.AddToCartDto;
import com.ecommerce.ShoppingCart.Dto.CartDto;
import com.ecommerce.ShoppingCart.Exceptions.CartItemNotExistException;
import com.ecommerce.ShoppingCart.Exceptions.ProductNotExistException;
import com.ecommerce.ShoppingCart.Models.Product;
import com.ecommerce.ShoppingCart.Services.CartService;
import com.ecommerce.ShoppingCart.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto) throws ProductNotExistException {
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
        Product product = productService.getProductById(addToCartDto.getProductId());
        System.out.println("product to add"+  product.getName());
        cartService.addToCart(addToCartDto, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems()  {
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
        CartDto cartDto = cartService.listCartItems();
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    }
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody AddToCartDto cartDto) throws ProductNotExistException {
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
        Product product = productService.getProductById(cartDto.getProductId());
        cartService.updateCartItem(cartDto, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws CartItemNotExistException {
//        authenticationService.authenticate(token);
//        int userId = authenticationService.getUser(token).getId();
        cartService.deleteCartItem(itemID);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }



}
