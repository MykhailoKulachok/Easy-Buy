package com.devcolibri.EasyBuy.controller;

import com.devcolibri.EasyBuy.dao.ProductDao;
import com.devcolibri.EasyBuy.entity.Product;
import com.devcolibri.EasyBuy.service.ProductEndedException;
import com.devcolibri.EasyBuy.service.UserProductListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by misha on 04.06.2016.
 */

@RestController
@RequestMapping("/users/products")
public class UserProductListController {

    @Autowired
    private UserProductListBean userProductListBean;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getListOfSelectedProducts() {
        return userProductListBean.getSelectedProducts();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public void addProductToList(@PathVariable int id) throws ProductEndedException {
        userProductListBean.addProduct(
                productDao.getProduct(id));
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteProductFromList(@PathVariable int id){
        userProductListBean.deleteProduct(
                productDao.getProduct(id)
        );
    }
}
