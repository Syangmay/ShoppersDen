package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDaoImpl;
import com.tata.shoppersden.dao.ProductDaoImpl;
import com.tata.shoppersden.dao.TransactionDao;
import com.tata.shoppersden.dao.TransactionDaoImpl;

import java.sql.SQLException;

public class AddTransaction {

    public void addTransaction() throws Exception {
        long productId = new ProductDaoImpl().getRandomProductId();
        long customerId = new CustomerDaoImpl().getRandomCustomerId();
        TransactionDao transactionDao = new TransactionDaoImpl();
        transactionDao.addTransaction(productId,customerId);
    }

}
