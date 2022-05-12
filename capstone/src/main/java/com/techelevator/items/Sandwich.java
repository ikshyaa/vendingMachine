package com.techelevator.items;

import com.techelevator.Items;
import com.techelevator.VendingMachine;

public class Sandwich extends Items {

    public String type = "Sandwich";


    public Sandwich(String name, String slotId, String price, String type) {
        super(name, slotId, price, type);

    }
    @Override
    public String getMessage() {
        return "\tSandwich So Delicious, Yum!";
    }

}
