package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;
import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;

import java.sql.SQLException;

public class AddToCart {
    public void addToCart(Product product,Customer customer) throws Exception {
        CustomerDao customerDao = new CustomerDaoImpl();
        if(product==null || customer==null)
        {
            throw new NullPointerException();
        }
        else {
            customerDao.addToCart(product, customer);
        }
    }
}
