package com.techelevator;

import com.techelevator.UI.UserOutput;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendingMachineTest {
    @Test
    public void getCurrentBalance_returns0_beforeFeedingMoney(){
        //arrange
        double expected = 0;

        //act
        double actual = VendingMachine.getCurrentBalance();

        //assert
        Assert.assertEquals(expected, actual, 0.02);
    }

    @Test
    public void feedMoney_shouldAddMoney() {
        VendingMachine vendingMachine = new VendingMachine();
        double currentBalance = 0;
        int cashAdded = 10;
        double newBalance = currentBalance + cashAdded;
        vendingMachine.setCurrentBalance(cashAdded);

        Assert.assertEquals(newBalance, vendingMachine.getCurrentBalance(), 0.02);

    }


    @Test
    public void processUserChoice_Test() {
        String choice = "F";
        double expectedBalance = 0;
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.processUserChoice(choice);

        assertEquals(expectedBalance, vendingMachine.getCurrentBalance(), 0.02);

    }

    @Test
    public void processChange_shouldReturnCorrectCoins() {
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachine.setCurrentBalance(7.69);

        String expected = "\nYour change is 7 dollars , 2 quarters, 1 dime, 1 nickles, 4 pennies.";
        String actual = vendingMachine.processChange();

        assertEquals(expected, actual);

    }
}
