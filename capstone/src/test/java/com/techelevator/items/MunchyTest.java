package com.techelevator.items;

import com.techelevator.Items;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MunchyTest {
    @Test
    public void getMessage_returnsDrinksMessage() {
        //arrange
        Items crackers = new Munchy("Crackers", "a1", "1.99", "munchy");
        String expected = "\tMunchy, Munchy, so Good!";

        //act
        String actual = crackers.getMessage();

        //assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCapacity_decreaseCapacityBy1() {
        //arrange
        Items crackers = new Munchy("Crackers", "a1", "1.99", "munchy");
        int expected = 6;

        //act
        crackers.setCapacity();
        int actual = crackers.getCapacity();

        //assert
        Assert.assertEquals(expected, actual);
    }
}
