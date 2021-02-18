package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.ShoppingCartDao;
import com.tata.shoppersden.dao.ShoppingCartImpl;
import com.tata.shoppersden.models.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public class DisplayAllCartItems {
    public void displayCart() throws Exception {

        ShoppingCartDao shoppingCartDao = new ShoppingCartImpl();
        List<ShoppingCart> shoppingCartList;

        {
            try {
                shoppingCartList = shoppingCartDao.displayCart();
                for (ShoppingCart shoppingCart : shoppingCartList) {
                    System.out.println("Product ID: " + shoppingCart.getProduct().getProductId());
                    System.out.println("Product Name: " + shoppingCart.getProduct().getProductName());
                    System.out.println("Product Price: " + shoppingCart.getProduct().getPrice());
                    System.out.println("Product Quantity: " + shoppingCart.getQuantity());
                    System.out.println("Product Temp ID: " + shoppingCart.getTempItemId());
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

}
