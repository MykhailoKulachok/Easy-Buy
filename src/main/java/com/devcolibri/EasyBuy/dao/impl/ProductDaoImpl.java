package com.devcolibri.EasyBuy.dao.impl;

import com.devcolibri.EasyBuy.dao.ProductDao;
import com.devcolibri.EasyBuy.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by misha on 04.06.2016.
 */
@SuppressWarnings("unchecked")
@Transactional
@Repository
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    @Override
    @Transactional
    public List<Product> getProducts() {
        return getSession().createCriteria(Product.class).list();
    }

    @Override
    @Transactional
    public Product getProduct(int id) {
        return (Product)getSession().get(Product.class, id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveProduct(Product product) {
        getSession().save(product);
    }
}
