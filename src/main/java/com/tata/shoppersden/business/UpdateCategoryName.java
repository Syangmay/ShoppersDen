package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateCategoryName {
    void updateCategoryName() throws Exception {
        AdminDao adminDao = new AdminDaoImpl();
        System.out.println("Enter Category Id");
        long cid = new Scanner(System.in).nextLong();
        adminDao.updateCategoryName(cid);
    }
}
