package com.shopping_cart.service;

import com.shopping_cart.model.Cart;
import com.shopping_cart.model.Product;

import java.util.Map;

public interface ICartService {
    void addProduct(Product product, Cart cart);
    void subProduct(Product product, Cart cart);
    Integer countProductQuantity(Cart cart);
    Integer countItemQuantity(Cart cart);
    Float countTotalPayment(Cart cart);
}
