package com.ecommerce.ShoppingCart.Services;

import com.ecommerce.ShoppingCart.Dto.CartItemDto;
import com.ecommerce.ShoppingCart.Exceptions.CartItemNotExistException;
import com.ecommerce.ShoppingCart.Dto.AddToCartDto;
import com.ecommerce.ShoppingCart.Dto.CartDto;
import com.ecommerce.ShoppingCart.Models.Cart;
import com.ecommerce.ShoppingCart.Models.CartCost;
import com.ecommerce.ShoppingCart.Models.Product;
import com.ecommerce.ShoppingCart.Repositories.CartRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Cache;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public void addToCart(AddToCartDto addToCartDto, Product product){
        Cart cart = new Cart(product, addToCartDto.getQuantity());
        cartRepository.save(cart);
    }


    public CartDto listCartItems() {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart: cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto : cartItems){
            totalCost += (cartItemDto.getProduct().getPrice() * cartItemDto.getQuantity());
        }
        CartDto cartDto = new CartDto(cartItems,totalCost);
        return cartDto;
    }


    public static CartItemDto getDtoFromCart(Cart cart) {
        CartItemDto cartItemDto = new CartItemDto(cart);
        return cartItemDto;
    }


    public void updateCartItem(AddToCartDto cartDto, Product product){
        Cart cart = cartRepository.getOne(cartDto.getId());
        cart.setQuantity(cartDto.getQuantity());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }

    public void deleteCartItem(int id) throws CartItemNotExistException {
        if (!cartRepository.existsById(id))
            throw new CartItemNotExistException("Cart id is invalid : " + id);
        cartRepository.deleteById(id);

    }

    public void deleteCartItems() {
        cartRepository.deleteAll();
    }


//    public void deleteUserCartItems(User user) {
//        cartRepository.deleteByUser(user);
//    }

}
