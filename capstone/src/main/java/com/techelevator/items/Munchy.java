package com.techelevator.items;

import com.techelevator.Items;
import com.techelevator.VendingMachine;

public class Munchy extends Items {

    public String type = "Munchy";

    public Munchy(String name, String slotId, String price, String type) {
        super(name, slotId, price, type);

    }

    @Override
    public String getMessage() {
        return "\tMunchy, Munchy, so Good!";
    }
}
