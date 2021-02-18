package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.models.Customer;

import java.sql.SQLException;
import java.util.List;

public class ViewAllCustomerDetails {
    public void viewAllCustomer() throws SQLException {
        AdminDao adminDao = new AdminDaoImpl();
        List<Customer> customerList = adminDao.viewAllCustomerDetails();
        for(Customer customer:customerList)
        {
            System.out.println(customer);
        }

    }
}
