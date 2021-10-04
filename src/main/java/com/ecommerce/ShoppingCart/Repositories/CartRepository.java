package com.ecommerce.ShoppingCart.Repositories;

import com.ecommerce.ShoppingCart.Models.Cart;
import com.ecommerce.ShoppingCart.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserIdOrderByCreatedDateDesc(User user);
    List<Cart> deleteByUser(User user);
//    List<Cart> findAllBySessionId(String sessionId);
}
