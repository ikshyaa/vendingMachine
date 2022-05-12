package com.techelevator;

import com.techelevator.Reports.SalesReport;
import com.techelevator.UI.UserInput;
import com.techelevator.Reports.Logger;
import com.techelevator.UI.UserOutput;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class VendingMachine {
    public static double currentBalance;

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            Inventory.stockInventory();
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.run();
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not load an inventory.");
        }
    }

    public void run() {
        while(true) {
            String choice = UserInput.displayHomePage();
            if (choice.equals("D")) {
                Inventory.displayInventory();

            }
            else if (choice.equals("P")) {
                choice = UserInput.purchaseChoice();
                processUserChoice(choice);
            }
            else if (choice.equals("E")) {
                return;
            }
            else if (choice.equals("S")) {
                SalesReport.processReport();
            }
            else {
                System.out.println("Invalid Input: Try again! ");
            }
        }
    }

    public void processUserChoice(String choice) {
        while(true) {
            if (choice.equals("M")) {
                feedMoney();
                choice = UserInput.purchaseChoice();
            }else if (choice.equals("S")) {
                Inventory.displayInventory();
                System.out.println();
                if(currentBalance <= 0) {
                    System.out.println("Please Feed Some Money Into the Machine First!");
                } else {
                    System.out.println("Enter slotId for desired Item");
                    String itemChoice = scanner.nextLine().trim().toUpperCase();
                    Inventory.processItemSale(itemChoice);
                }
                choice = UserInput.purchaseChoice();
            } else if (choice.equals("F")) {
                System.out.println("Don't Forget your Change!");
                processChange();
                Logger.writeAudit(String.format("CHANGE GIVEN: \t $%.2f \t$0.00", getCurrentBalance()));
                currentBalance = 0;
                return;
            } else {
                System.out.println("Invalid Input");
                choice = UserInput.purchaseChoice();
            }
        }

    }

    public String processChange() {
        BigDecimal quarters, dimes, nickles, pennies;

        int dollarAmt = (int)(getCurrentBalance());
        double decimalValue = (getCurrentBalance() - dollarAmt) ;

        pennies = BigDecimal.valueOf(decimalValue).multiply(BigDecimal.valueOf(100)).setScale(0,RoundingMode.FLOOR);

        quarters = pennies.divide(BigDecimal.valueOf(25), RoundingMode.DOWN);
        pennies = pennies.remainder(BigDecimal.valueOf(25));

        dimes = pennies.divide(BigDecimal.valueOf(10), RoundingMode.DOWN);
        pennies = pennies.remainder(BigDecimal.valueOf(10));

        nickles = pennies.divide(BigDecimal.valueOf(5), RoundingMode.DOWN);
        pennies = pennies.remainder(BigDecimal.valueOf(5));

        return UserOutput.displayChange( dollarAmt, quarters, dimes, nickles, pennies );
    }


    private static void feedMoney() {
        try {
            System.out.println("Insert Cash: \n Accepted bills $1, $5, $10, $20.");

            int cashAdded = Integer.parseInt(scanner.nextLine().trim());
            if (cashAdded != 1 && cashAdded != 5 && cashAdded != 10 && cashAdded != 20) {
                System.out.println("Insert a valid bill");
            } else  {

                setCurrentBalance(getCurrentBalance() + cashAdded);
                Logger.writeAudit(String.format("MONEY FED: \t $%d  \t$%.2f", cashAdded, currentBalance));
            }

        }
        catch (NumberFormatException e) {
            System.out.println("Please enter cash.");
        }

    }


    public static double getCurrentBalance() {
        return currentBalance;
    }
    public  static void setCurrentBalance(double newCurrentBalance) {
        currentBalance = newCurrentBalance;
    }

}
