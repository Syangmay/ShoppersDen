package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProductName {
    public void updateProductName() throws Exception {
        System.out.println("Enter the product Id");
        long pid = new Scanner(System.in).nextLong();
        AdminDao adminDao = new AdminDaoImpl();
        adminDao.updateProductName(pid);
    }
}
