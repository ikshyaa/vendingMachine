package com.techelevator.items;

import com.techelevator.Items;
import com.techelevator.VendingMachine;

public class Dessert extends Items {


    public String type = "Dessert";

    public Dessert(String name, String slotId, String price, String type) {
        super(name, slotId, price, type);

    }
    @Override
    public String getMessage() {
        return "\tSugar, Sugar, so Sweet!";
    }
}
