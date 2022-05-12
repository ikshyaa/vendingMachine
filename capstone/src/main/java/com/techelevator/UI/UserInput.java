package com.techelevator.UI;

import com.techelevator.VendingMachine;

import java.util.Scanner;

public class UserInput {
    public static Scanner scanner = new Scanner(System.in);

    public static String getChoice() {
        System.out.println("Please make a Choice! ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public static String displayHomePage() {
        System.out.println();
        System.out.println("Welcome to the Vending Machine! ");
        System.out.println("(D) Display caTEring Items\n" +
                "(P) Purchase\n" +
                "(E) Exit");
        System.out.println();
        return getChoice();

    }

    public static String purchaseChoice() {
        System.out.println();
        System.out.println("(M) Feed Money\n" +
                "(S) Select Item\n" +
                "(F) Finish Transaction");
        System.out.println();
        System.out.printf("Current Balance: $%.2f", VendingMachine.getCurrentBalance());
        System.out.println();
        return getChoice();
    }
}
