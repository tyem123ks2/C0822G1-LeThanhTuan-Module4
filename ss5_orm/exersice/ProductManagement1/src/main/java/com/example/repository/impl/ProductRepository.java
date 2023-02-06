package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
//private static final Map<Integer, Product> productList;
//
//    static {
//        productList = new HashMap<>();
//        productList.put(1, new Product(1, "AirBlade", 43000000, "Xe máy", "Honda"));
//        productList.put(2, new Product(2, "Sh-mode", 70000000, "Xe máy", "Honda"));
//        productList.put(3, new Product(3, "Jupiter", 18000000, "Xe máy", "Yamaha"));
//    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        productList = entityManager.createQuery("FROM Product ").getResultList();
        return productList;
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
      return entityManager.find(Product.class,id);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(int id) {
        entityManager.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
//        List<Product> products = new ArrayList<>();
//        for (Product item: productList.values()){
//            if (item.getName().contains(name)){
//                products.add(item);
//            }
//        }
        return null;
    }
}
