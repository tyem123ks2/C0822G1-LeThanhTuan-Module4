package com.example.shopping_cart.service;
import com.example.shopping_cart.model.Product;
import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}

//    public Map<Product, Integer> getProducts()
//
//    boolean checkItemInCart(Product product);
//
//    Map.Entry<Product, Integer> selectItemInCart(Product product);
//    void addProduct(Product product);
//
//    Integer countProductQuantity();
//
//    Integer countItemQuantity();
//
//    public Float countTotalPayment();
//}
