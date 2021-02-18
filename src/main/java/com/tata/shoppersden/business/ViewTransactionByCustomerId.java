package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.TransactionDao;
import com.tata.shoppersden.dao.TransactionDaoImpl;
import com.tata.shoppersden.models.Transactions;

import java.sql.SQLException;
import java.util.List;

public class ViewTransactionByCustomerId {
    public void displayTransactionByCustomerId(long id) throws SQLException {

    TransactionDao transactionDao = new TransactionDaoImpl();
    List<Transactions> transactionsList = transactionDao.viewTransactionByCustomerId(id);
    for(Transactions transactions:transactionsList) {
        System.out.println(transactions);
    }
    }


}
