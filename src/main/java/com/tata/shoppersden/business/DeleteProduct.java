package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteProduct {
    public void deleteProduct() throws Exception {
        AdminDao adminDao = new AdminDaoImpl();
        System.out.println("Enter the product Id");
        long productId = new Scanner(System.in).nextLong();
        adminDao.deleteProduct(productId);
    }
}
