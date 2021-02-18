package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.sql.SQLException;

public class DisplayCartByCustomer {
    public void displayCart(long userId) throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.viewCart(userId);
    }
}
