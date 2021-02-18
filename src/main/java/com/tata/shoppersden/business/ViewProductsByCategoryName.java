package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.models.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ViewProductsByCategoryName {
    public void viewProductsByCategoryName() throws Exception {
        AdminDao adminDao = new AdminDaoImpl();
        System.out.println("Enter Category Name");
        String cname = new Scanner(System.in).nextLine();
        List<Product> productList = adminDao.getProductsByCategoryName(cname);
        for(Product product : productList)
        {
            System.out.println(product);
        }
    }
}
