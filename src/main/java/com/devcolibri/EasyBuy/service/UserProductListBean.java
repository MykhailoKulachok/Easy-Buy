package com.devcolibri.EasyBuy.service;

import com.devcolibri.EasyBuy.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by misha on 04.06.2016.
 */

@Scope("session")
@Service
public class UserProductListBean {


    List<Product> selectedProducts;

    @PostConstruct
    public void postConstruct(){
        selectedProducts = new LinkedList<>();
    }

    public void addProduct(Product product) throws ProductEndedException{
        selectedProducts.add(product);
    }

    public void deleteProduct(Product product){
        selectedProducts.remove(product);
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }
}
