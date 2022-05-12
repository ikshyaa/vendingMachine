package com.techelevator.UI;

import com.techelevator.Inventory;
import com.techelevator.Items;

import java.math.BigDecimal;
import java.util.Map;

    public class UserOutput {

        public static String displayChange(int dollarAmt, BigDecimal quarters, BigDecimal dime, BigDecimal nickles, BigDecimal pennies) {
            System.out.printf("\nYour change is %d dollars , %s quarters, %s dime, %s nickles, %s pennies.",
                    dollarAmt, quarters, dime, nickles, pennies );
            return String.format("\nYour change is %d dollars , %s quarters, %s dime, %s nickles, %s pennies.",
                    dollarAmt, quarters, dime, nickles, pennies );
        }


        public static Map<String, Items> displayInventory(){
            return Inventory.getInventory();
        }
    }


