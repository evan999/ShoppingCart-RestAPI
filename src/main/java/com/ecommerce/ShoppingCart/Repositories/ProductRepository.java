package com.ecommerce.ShoppingCart.Repositories;

import com.ecommerce.ShoppingCart.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
