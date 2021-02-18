package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;
import com.tata.shoppersden.models.Customer;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;


public class RegistrationAction {

    public Customer createCustomer()
    {
        Customer customer = new Customer();
        customer.setCustomerId(new Random().nextInt(100000));
        customer.setCustomerName(RandomStringUtils.randomAlphabetic(10,20));
        customer.setAddress(RandomStringUtils.randomAlphabetic(10,20));
        customer.setEmailId(RandomStringUtils.randomAlphabetic(5,10)+ "@gmail.com");
        customer.setPassword(RandomStringUtils.randomAlphabetic(8,15));
        customer.setPhone(Long.parseLong(RandomStringUtils.randomNumeric(10)));
        customer.setSecurityQuestion(RandomStringUtils.randomAlphabetic(30,40));
        customer.setSecurityAnswer(RandomStringUtils.randomAlphabetic(5,20));
        return customer;
    }

    public void registrationAction() throws Exception {
        Customer customer = createCustomer();
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.registerUser(customer);
    }

}
