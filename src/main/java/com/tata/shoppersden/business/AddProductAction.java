package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.dao.ProductDaoImpl;
import com.tata.shoppersden.models.Product;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

public class AddProductAction {
    public void addProduct(Product product) throws SQLException {
        new AdminDaoImpl().addProduct(product);
    }
}
