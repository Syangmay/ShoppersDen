package com.tata.shoppersden.dao;

import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;
import com.tata.shoppersden.models.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    public void loginUser(long userId,String Password) throws Exception;
    public void registerUser(Customer customer) throws Exception;
    public void addToCart(Product product, Customer customer) throws SQLException;
    public List<ShoppingCart> viewCart(long userId) throws SQLException;
    public Customer getCustomerById(long id) throws SQLException;
    public long getRandomCustomerId() throws SQLException;

}
