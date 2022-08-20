package com.products.repository;

import com.products.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> displayAll();

    void createNewProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(int id);

    Product findProduct(int id);

    List<Product> findProductByName(String name);
}
