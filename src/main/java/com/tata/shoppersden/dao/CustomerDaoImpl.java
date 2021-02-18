package com.tata.shoppersden.dao;

import com.tata.shoppersden.business.LoginAction;
import com.tata.shoppersden.business.RegistrationAction;
import com.tata.shoppersden.helper.PostgresConnHelper;
import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;
import com.tata.shoppersden.models.ShoppingCart;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerDaoImpl implements CustomerDao{

    private Connection conn;
    private PreparedStatement pre,addPre,getPre,preRandom,preRegister,preCart;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;
    private Customer customer = null;
    public CustomerDaoImpl()
    {
        conn = PostgresConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");
    }
    @Override
    public void registerUser(Customer customer) throws Exception {
        registerNewUser(customer);
    }

    @Override
    public void loginUser(long  userId ,String password) throws Exception {
        loginPage(userId,password);
    }

    @Override
    public void addToCart(Product product,Customer customer) throws SQLException {
        addCart(product,customer);

    }

    @Override
    public List<ShoppingCart> viewCart(long userId) throws SQLException {
        return viewCarts(userId);
    }

    private List<ShoppingCart> viewCarts(long userId) throws SQLException {
        List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
        ShoppingCart shoppingCart = null;
        String getCart = resourceBundle.getString("viewCart");
        preCart = conn.prepareStatement(getCart);
        preCart.setLong(1,userId);
        resultSet = preCart.executeQuery();
        while(resultSet.next())
        {
            shoppingCart = new ShoppingCart();
            shoppingCart.setCustomer(new CustomerDaoImpl().getCustomerById(resultSet.getLong(6)));
            shoppingCart.setTempItemId(resultSet.getLong(5));
            shoppingCart.setQuantity(resultSet.getInt(4));
            shoppingCart.setProduct(new ProductDaoImpl().getProductById(resultSet.getLong(1)));
            shoppingCartList.add(shoppingCart);
        }
        return shoppingCartList;
    }

    @Override
    public Customer getCustomerById(long id) throws SQLException {
        return getCustomerId(id);
    }

    @Override
    public long getRandomCustomerId() throws SQLException {
        return getRandomCustomer();
    }

    private long getRandomCustomer() throws SQLException {
        String randomCustomer = resourceBundle.getString("getRandomCustomerID");
        preRandom = conn.prepareStatement(randomCustomer);
        resultSet = preRandom.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getLong(1);
        }
        return 0;
    }

    private Customer getCustomerId(long id) throws SQLException {
        String getCustomer = resourceBundle.getString("getCustomerById");
        Customer customer = new Customer();
        getPre = conn.prepareStatement(getCustomer);
        getPre.setLong(1,id);
        resultSet = getPre.executeQuery();
        if(resultSet.next())
        {
            customer.setCustomerId(resultSet.getLong(1));

        }
        return customer;

    }


    public void addCart(Product product, Customer customer) throws SQLException {
        String addCart = resourceBundle.getString("addToCart");
        addPre = conn.prepareStatement(addCart);
        addPre.setLong(1,product.getProductId());
        addPre.setString(2, product.getProductName());
        addPre.setDouble(3,product.getPrice());
        addPre.setInt(4,new Random().nextInt(100));
        addPre.setLong(5,new Random().nextInt(100000000));
        addPre.setLong(6,customer.getCustomerId());
        addPre.executeUpdate();
    }


    private void loginPage(long userId,String password) throws Exception {
        if(password == "" || userId == 0)
        {
            throw new Exception("Credential Not Valid");
        }
        else {
            if (checkIfValid(userId, password)) {
                System.out.println("Login Successful.  Enjoy your Shopping");
            } else {
                System.out.println("Please Register First");
                new RegistrationAction().registrationAction();

            }
        }
    }

    public boolean checkIfValid(long userId,String password) throws SQLException {
        if(userId ==0 || password == "")
        {
            return false;
        }
        String check = resourceBundle.getString("checkIfValid");
        pre = conn.prepareStatement(check);
        pre.setLong(1,userId);
        pre.setString(2,password);
        resultSet = pre.executeQuery();
        if(resultSet.next())
        {
            System.out.println("Welcome " + resultSet.getString(1));
            return true;
        }
        return false;
    }



    private void registerNewUser(Customer customer) throws Exception {

        if(customer==null)
        {
            throw new NullPointerException("Customer is Null");
        }

        if(checkIfUserExists(customer.getCustomerId()))
        {
            System.out.println("User Already Exists.Please Login!!!");
            new LoginAction().loginAction();
        }
        else
        {
            addUser(customer);
        }
    }
    public boolean checkIfUserExists(long id) throws SQLException {

        String check = resourceBundle.getString("checkIfUserExists");
        pre = conn.prepareStatement(check);
        pre.setLong(1,id);
        resultSet = pre.executeQuery();
        if(resultSet.next())
        {
            return true;
        }
        return false;
    }
    public void addUser(Customer customer) throws SQLException {
        if(customer == null)
        {
            throw  new NullPointerException("Customer is Null");
        }
        String registerNewUser = resourceBundle.getString("registerNewUser");
        preRegister = conn.prepareStatement(registerNewUser);
        preRegister.setLong(1,customer.getCustomerId());
        preRegister.setString(2,customer.getCustomerName());
        preRegister.setString(3,customer.getAddress());
        preRegister.setString(4, (customer.getEmailId()));
        preRegister.setString(5,customer.getPassword());
        preRegister.setLong(6,customer.getPhone());
        preRegister.setString(7,customer.getSecurityQuestion());
        preRegister.setString(8,customer.getSecurityAnswer());
        preRegister.executeUpdate();

    }




}
