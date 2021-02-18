package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.models.Transactions;

import java.sql.SQLException;
import java.util.List;

public class ViewAllTransactions {
    public void viewAllTransactions() throws SQLException {
        AdminDao adminDao = new AdminDaoImpl();
        List<Transactions> transactionsList = adminDao.viewAllTransactionDetails();
        for(Transactions transactions : transactionsList)
        {
            System.out.println(transactions);
        }
    }
}
