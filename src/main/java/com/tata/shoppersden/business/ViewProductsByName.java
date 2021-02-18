package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.ProductDao;
import com.tata.shoppersden.dao.ProductDaoImpl;
import com.tata.shoppersden.models.Product;

import java.sql.SQLException;
import java.util.List;

public class ViewProductsByName {
    public void displayProductsByName(String name) {
        ProductDao productDao = new ProductDaoImpl();
        Product product = new Product();

        try {
                product = productDao.getProductByName(name);
                System.out.println(product);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

    }

}