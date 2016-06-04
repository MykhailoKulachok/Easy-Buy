package com.devcolibri.EasyBuy.controller;

import com.devcolibri.EasyBuy.dao.ProductDao;
import com.devcolibri.EasyBuy.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by misha on 04.06.2016.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDao productDao;


    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getListOfProducts(){
        return productDao.getProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewProduct(@RequestParam Product product){
        productDao.saveProduct(product);
    }

}
