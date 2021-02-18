package com.tata.shoppersden.utility;

import java.util.Scanner;

public class ShoppersDenApp {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Shopper's Den!!!!!!!");
        System.out.println("If you are Admin Enter 1 ");
        System.out.println("If you are Customer Enter 2");
        System.out.println("If you want to exit Enter any key");
        int choose = scan.nextInt();
        switch(choose)
        {
            case 1:
                new ShoppersDenAdmin().shoppersDenAdmin();

                break;
            case 2:
                new ShoppersDenCustomer().shopperDenCustomer();
                break;
            default:
                break;

        }


    }
}
