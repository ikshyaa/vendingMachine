package com.techelevator.items;

import com.techelevator.Items;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinksTest {
    @Test
    public void getMessage_returnsDrinksMessage() {
        //arrange
        Items grandMarnier = new Drinks("Grand Marnier", "a1", "99.99", "drinks");
        String expected = "\tDrinky, Drinky, Slurp Slurp!";

        //act
        String actual = grandMarnier.getMessage();

        //assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCapacity_decreaseCapacityBy1() {
        //arrange
        Items grandMarnier = new Drinks("Grand Marnier", "a1", "99.99", "drinks");
        int expected = 6;

        //act
        grandMarnier.setCapacity();
        int actual = grandMarnier.getCapacity();

        //assert
        Assert.assertEquals(expected, actual);
    }
}
