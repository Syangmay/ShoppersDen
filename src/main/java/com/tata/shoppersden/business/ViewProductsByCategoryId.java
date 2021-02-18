package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.models.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ViewProductsByCategoryId {
    public void viewProductsByCategoryId() throws Exception {
        AdminDao adminDao = new AdminDaoImpl();
        System.out.println("Enter Category Id");
        long cid = new Scanner(System.in).nextLong();
        List<Product> productList = adminDao.getProductsByCategoryId(cid);
        for(Product product : productList)
        {
            System.out.println(product);
        }
    }
}
