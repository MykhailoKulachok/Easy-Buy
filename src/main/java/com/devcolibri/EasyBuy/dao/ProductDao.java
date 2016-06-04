package com.devcolibri.EasyBuy.dao;

import com.devcolibri.EasyBuy.entity.Product;

import java.util.List;

/**
 * Created by misha on 04.06.2016.
 */
public interface ProductDao {

    List<Product> getProducts();
    Product getProduct(int id);
    void saveProduct(Product product);
}
