package com.techelevator.items;

import com.techelevator.Items;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DessertTest {
    @Test
    public void getMessage_returnsDessertMessage() {
        //arrange
        Items profiterole = new Dessert("Profiterole", "a1", "9.99", "dessert");
        String expected = "\tSugar, Sugar, so Sweet!";

        //act
        String actual = profiterole.getMessage();

        //assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCapacity_decreaseCapacityBy1() {
        //arrange
        Items profiterole = new Dessert("Profiterole", "a1", "9.99", "dessert");
        int expected = 6;

        //act
        profiterole.setCapacity();
        int actual = profiterole.getCapacity();

        //assert
        Assert.assertEquals(expected, actual);
    }
}
