package com.example.shopping_cart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    //Kiểm tra sản phẩm có trong giỏ hay chưa
    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }


    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    //Thêm sản phẩm vào giỏ hàng
    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else  {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    //Đếm số lượng sản phẩm đó hiện có trong giỏ hàng.
    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }
    //Để đếm số lượng sản phẩm có trong giỏ hàng.
    public Integer countItemQuantity() {
        return products.size();
    }

    //dùng để tính tổng số tiền cần phải thanh toán.
    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
