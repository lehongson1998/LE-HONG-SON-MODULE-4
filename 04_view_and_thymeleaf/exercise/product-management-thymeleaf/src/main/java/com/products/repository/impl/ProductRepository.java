package com.products.repository.impl;

import com.products.model.Product;
import com.products.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1, "Iphone 12", 1200, "New 100%", "Apple"));
        productList.add(new Product(2,"Iphone 12 Pro", 1400, "New 100%", "Apple"));
        productList.add(new Product(3,"Asus Zenfone 5", 600,"Like New", "Asus"));
        productList.add(new Product(4, "Samsung Galaxy S22", 1300, "New 100%", "Samsung"));
        productList.add(new Product(5, "Lenovo Idea PadSlim 5", 2000, "New 100%", "Lenovo"));
    }

    @Override
    public List<Product> displayAll() {
        return productList;
    }

    @Override
    public void createNewProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void editProduct(Product product) {
        for(int i = 0; i < productList.size(); i++){
            if (product.getId() == productList.get(i).getId()){
                productList.get(i).setName(product.getName());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setDescription(product.getDescription());
                productList.get(i).setProduce(product.getProduce());
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        for(int i = 0; i < productList.size(); i++){
            if (id == productList.get(i).getId()){
                productList.remove(productList.get(i));
            }
        }
    }

    @Override
    public Product findProduct(int id) {
        for (Product p: productList){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (Product p: productList){
            if (p.getName().contains(name)){
                productList1.add(p);
            }
        }
        return productList1;
    }
}
