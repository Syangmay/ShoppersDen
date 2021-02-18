package com.tata.shoppersden.utility;


import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.models.Category;
import com.tata.shoppersden.models.Product;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class ShoppersDenAdmin {
    private AdminDao adminDao;
    private Category category;
    private Product product;
    Scanner scan = new Scanner(System.in);
    public void shoppersDenAdmin() throws SQLException {

        adminDao = new AdminDaoImpl();
        System.out.println("Enter AdminId");
        long adminId = scan.nextLong();
        System.out.println("Enter your password");
        String password = scan.next();
        if(adminDao.adminLogin(adminId,password))
        {
            System.out.println("Welcome to Admin Page");
            adminFunctions();

        }
        else
        {
            System.out.println("Invalid Credentials");
        }

    }

    public void adminFunctions() throws SQLException {
        System.out.println("*************************Menu*********************");
        System.out.println("Select any one Functionality");
        System.out.println("Add Category-1 \t Add Product-2 \t Delete Product-3");
        System.out.println("Display Cart-4 \t Display Cart By CustomerId-5");
        System.out.println("Update Category Name-6 \t Update Product Name-7");
        System.out.println("Update Product Image-8 \t Update Product Desc-9");
        System.out.println("Update Product DOM-10 \t Update Product Price-11");
        System.out.println("View All Categories-12 \t View All Customer-13");
        System.out.println("View All Transactions-14 \t View Products By Id-15");
        System.out.println("View Products By CategoryId-16 \t View Products By CategoryName-17");
        System.out.println("View Products By Name-18 \t View Transactions by Customer Id-19");
        System.out.println("View Transactions by Product ID -20");
        int choice = scan.nextInt();
        switch (choice)
        {
            case 1:
                category = new Category();
                System.out.println("Enter category Id");
                long cid = scan.nextLong();
                System.out.println("Enter category Name");
                String cname = scan.next();
                category.setCategoryId(cid);
                category.setCategoryName(cname);
                adminDao.addCategory(category);
                break;
            case 2:
                product = new Product();
                System.out.println("Enter Product ID");
                product.setProductId(scan.nextLong());
                System.out.println("Enter Product Name");
                product.setProductImage(scan.next());
                System.out.println("Enter Product Desc");
                product.setDescription(scan.next());
                System.out.println("Enter Product Price");
                product.setPrice(scan.nextDouble());
                System.out.println("Enter Product Image");
                product.setProductImage(scan.next());
                System.out.println("Enter Product DOM");
                product.setDom(Date.valueOf(scan.next()));
                adminDao.addProduct(product);


        }


    }


}
