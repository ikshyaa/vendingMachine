package com.techelevator;

import com.techelevator.Reports.Logger;
import com.techelevator.Reports.SalesReport;
import com.techelevator.items.Dessert;
import com.techelevator.items.Drinks;
import com.techelevator.items.Munchy;
import com.techelevator.items.Sandwich;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    public static Map<String, Items> inventory= new HashMap<>();
    public static String currentItem;

    public static void stockInventory() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a valid CSV file for inventory: ");
        File file = new File(scanner.nextLine());

        try(Scanner readingFile = new Scanner(file)) {
            while(readingFile.hasNextLine()){
                String line = readingFile.nextLine();
                String[] itemInfo= line.split(",");
                if (itemInfo[2].equals("Sandwich")) {
                    Items items = new Sandwich(itemInfo[1],itemInfo[0], itemInfo[3], itemInfo[2]);
                    inventory.put(itemInfo[0], items);
                }
                else if (itemInfo[2].equals("Munchy")) {
                    Items items = new Munchy(itemInfo[1],itemInfo[0], itemInfo[3], itemInfo[2]);
                    inventory.put(itemInfo[0], items);
                }
                else if (itemInfo[2].equals("Drink")) {
                    Items items = new Drinks(itemInfo[1],itemInfo[0], itemInfo[3], itemInfo[2]);
                    inventory.put(itemInfo[0], items);
                }
                if (itemInfo[2].equals("Dessert")) {
                    Items items = new Dessert(itemInfo[1],itemInfo[0], itemInfo[3], itemInfo[2]);
                    inventory.put(itemInfo[0], items);
                }
            }
        }
    }


    public static Map<String, Items> getInventory() {
        return inventory;
    }

    public static void displayInventory() {
        System.out.println();
        System.out.println("**********Items Available**********");
        for(String item: inventory.keySet()) {
            System.out.println("slotId= " + item + "\t " + inventory.get(item).getName()
                    + ": " + inventory.get(item).getCapacity() + "Left for "
                    + inventory.get(item).getPrice()+" each.");
        }
    }

    public void setInventory(Map<String, Items> inventory) {
        this.inventory = inventory;
    }

    public static void processItemSale(String itemChoice) {
        if(inventory.containsKey(itemChoice)) {
            for(String slotId: inventory.keySet()) {
                Items item = inventory.get(slotId);
                if(itemChoice.equals(slotId)) {
                    if(item.getCapacity() <=0) {
                        System.out.println("NO LONGER AVAILABLE");
                        return;
                    }
                    if (VendingMachine.getCurrentBalance() < Double.parseDouble(item.getPrice())) {
                        System.out.println("Not enough money.");
                        return;
                    }
                    currentItem = item.getName();
                    System.out.println("Dispensing "+ item.getName() + ": "
                            + item.getPrice() + "\n" + item.getMessage());
                    inventory.get(slotId).setCapacity();
                    VendingMachine.setCurrentBalance(VendingMachine.getCurrentBalance()-Double.parseDouble(inventory.get(slotId).getPrice()));
                    String salesLine = String.format("%s, %s, %s, %s" , item.getSlotId(), item.getName()
                            , item.getPrice(), item.getType());
                    SalesReport.reportSale(salesLine);
                    String line = item.getName() + " \t\t" + slotId + " $" + item.getPrice() + "\t" +
                            String.format("%.2f", VendingMachine.getCurrentBalance());
                    Logger.writeAudit(line);

                }
            }

        } else {
            System.out.println("The Item you selected doesn't Exist!");
        }
    }
}


