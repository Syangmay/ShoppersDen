package com.tata.shoppersden.utility;

import com.tata.shoppersden.business.LoginAction;
import com.tata.shoppersden.business.RegistrationAction;

import java.util.Scanner;

public class ShoppersDenCustomer {
    public void shopperDenCustomer() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Shopper's Den!!!!!!!");
        System.out.println("If you are new user Enter 1 ");
        System.out.println("If you are returning user Enter 2");
        System.out.println("If you want to exit Enter any key");
        int choose = scan.nextInt();
        switch(choose)
        {
            case 1:
                new LoginAction().loginAction();

                break;
            case 2:
                new RegistrationAction().registrationAction();
                break;
            default:
                break;

        }
    }
}
