package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.ProductDao;
import com.tata.shoppersden.dao.ProductDaoImpl;
import com.tata.shoppersden.models.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewProducts {
    public void viewAllProducts() {
        ProductDao productDao = new ProductDaoImpl();
        List<Product> productList;
            try {
                productList = productDao.viewProducts();
                for (Product product : productList) {
                    System.out.println(product);
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

    }

}
