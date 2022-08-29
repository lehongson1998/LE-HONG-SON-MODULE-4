package com.shopping_cart.repository;

import com.shopping_cart.model.Cart;
import com.shopping_cart.model.Product;

public interface ICartRepository {
    void addProduct(Product product, Cart cart);
    void subProduct(Product product, Cart cart);
    Integer countProductQuantity(Cart cart);
    Integer countItemQuantity(Cart cart);
    Float countTotalPayment(Cart cart);
}

