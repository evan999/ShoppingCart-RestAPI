package com.ecommerce.ShoppingCart.Repositories;

import com.ecommerce.ShoppingCart.Models.AuthToken;
import com.ecommerce.ShoppingCart.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthToken, Integer> {

    AuthToken findTokenByUser(User user);
    AuthToken findTokenByToken(String token);
}
