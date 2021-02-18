package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProductDom {
    public void updateProductDom() throws Exception {
        AdminDao adminDao = new AdminDaoImpl();
        System.out.println("Enter Product Id:");
        long pid = new Scanner(System.in).nextLong();
        adminDao.updateProductDom(pid);
    }
}
