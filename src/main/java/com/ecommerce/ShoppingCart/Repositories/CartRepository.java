package com.ecommerce.ShoppingCart.Repositories;

import com.ecommerce.ShoppingCart.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserIdOrderByCreatedDateDesc(Integer userId);
}
