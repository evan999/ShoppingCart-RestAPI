package com.ecommerce.ShoppingCart.Controllers;

import com.ecommerce.ShoppingCart.Common.ApiResponse;
import com.ecommerce.ShoppingCart.Dto.AddToCartDto;
import com.ecommerce.ShoppingCart.Dto.CartDto;
import com.ecommerce.ShoppingCart.Exceptions.AuthenticationFailException;
import com.ecommerce.ShoppingCart.Exceptions.CartItemNotExistException;
import com.ecommerce.ShoppingCart.Exceptions.ProductNotExistException;
import com.ecommerce.ShoppingCart.Models.Product;
import com.ecommerce.ShoppingCart.Models.User;
import com.ecommerce.ShoppingCart.Services.AuthService;
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

    @Autowired
    private AuthService authService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException{
        authService.authenticate(token);
        User user = authService.getUser(token);
        Product product = productService.getProductById(addToCartDto.getProductId());
        System.out.println("product to add"+  product.getName());
        cartService.addToCart(addToCartDto, product, user);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems (@RequestParam("token") String token) throws AuthenticationFailException  {
        authService.authenticate(token);
        User user = authService.getUser(token);
        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    }
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody AddToCartDto cartDto,
                                                      @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException {
        authService.authenticate(token);
        User user = authService.getUser(token);
        Product product = productService.getProductById(cartDto.getProductId());
        cartService.updateCartItem(cartDto, user, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token)
            throws AuthenticationFailException, CartItemNotExistException {
        authService.authenticate(token);
        int userId = authService.getUser(token).getId();
        cartService.deleteCartItem(itemID, userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
}
