package com.techelevator;

public class Items {
    private String name;
    private String slotId;
    private String price;
    private String type;



    public int capacity;

    public Items(String name, String slotId, String price, String type) {
        this.name = name;
        this.slotId = slotId;
        this.price = price;
        this.capacity = 7;
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity() {
        capacity--;

    }
    public String getMessage() {
        return "I am an item";
    }
}
