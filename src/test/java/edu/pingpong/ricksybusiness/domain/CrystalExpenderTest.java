package edu.pingpong.ricksybusiness.domain;

import static org.junit.Assert.*;

import org.junit.*;

public class CrystalExpenderTest {


    private CrystalExpender crystalExpender = null;
    private CreditCard abradolph = null;

    @Before
    public void setup() {
        int stock = 3;
        double itemCost = 50;
        this.crystalExpender = new CrystalExpender(stock, itemCost);
        this.abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");

    }

    @Test
    public void constructorTest() {
        assertNotNull(this.crystalExpender);
    }
}
