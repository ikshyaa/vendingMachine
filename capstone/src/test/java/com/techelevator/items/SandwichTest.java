package com.techelevator.items;

import com.techelevator.Items;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SandwichTest {
    @Test
    public void getMessage_returnsSandwichMessage() {
        //arrange
        Items sandwich = new Sandwich("sub", "a1", "9.99", "sandwich");
        String expected = "\tSandwich So Delicious, Yum!";

        //act
        String actual = sandwich.getMessage();

        //assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCapacity_decreaseCapacityBy1() {
        //arrange
        Items sandwich = new Sandwich("sub", "a1", "9.99", "sandwich");
        int expected = 6;

        //act
        sandwich.setCapacity();
        int actual = sandwich.getCapacity();

        //assert
        Assert.assertEquals(expected, actual);
    }

}
