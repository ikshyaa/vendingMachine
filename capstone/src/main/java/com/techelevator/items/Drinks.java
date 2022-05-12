package com.techelevator.items;

import com.techelevator.Items;
import com.techelevator.VendingMachine;

public class Drinks extends Items {

    public String type = "Drinks";

    public Drinks(String name, String slotId, String price, String type) {
        super(name, slotId, price, type);

    }
    @Override
    public String getMessage() {
        return "\tDrinky, Drinky, Slurp Slurp!";
    }

}
