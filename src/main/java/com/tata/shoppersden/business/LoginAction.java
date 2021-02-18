package com.tata.shoppersden.business;


import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.util.Scanner;

public class LoginAction {

    public void loginAction() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your UserName");
        long userId = scan.nextLong();
        System.out.println("Enter your Password");
        String password = scan.next();
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.loginUser(userId,password);
    }

}
