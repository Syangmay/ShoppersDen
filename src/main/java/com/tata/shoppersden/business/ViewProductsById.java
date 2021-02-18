package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.ProductDao;
import com.tata.shoppersden.dao.ProductDaoImpl;
import com.tata.shoppersden.models.Product;

import java.sql.SQLException;

public class ViewProductsById {
    public void displayProductsByName(long id) {
        ProductDao productDao = new ProductDaoImpl();
        Product product = new Product();

        try {
            product = productDao.getProductById(id);
            System.out.println(product);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
