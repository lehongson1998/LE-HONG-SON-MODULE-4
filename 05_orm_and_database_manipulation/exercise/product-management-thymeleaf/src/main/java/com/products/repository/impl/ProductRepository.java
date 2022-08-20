package com.products.repository.impl;

import com.products.model.Product;
import com.products.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> displayAll() {
        TypedQuery typedQuery = BaseRepository.entityManager.createQuery("select p from Product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void createNewProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void editProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void deleteProduct(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = BaseRepository.entityManager.find(Product.class, id);
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public Product findProduct(int id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public List<Product> findProductByName(String name) {
        TypedQuery typedQuery = BaseRepository.entityManager.createQuery("select p from Product p where p.name like :name", Product.class);
        return typedQuery.getResultList();
    }
}
