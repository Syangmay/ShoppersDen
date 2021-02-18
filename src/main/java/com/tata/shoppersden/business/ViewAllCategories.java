package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.models.Category;

import java.sql.SQLException;

public class ViewAllCategories {
    public void viewAllCategories() throws SQLException {
        AdminDao adminDao = new AdminDaoImpl();
        for(Category category : adminDao.getCategories())
        {
            System.out.println(category);
        }
    }
}
