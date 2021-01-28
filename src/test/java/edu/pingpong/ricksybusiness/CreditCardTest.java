package edu.pingpong.ricksybusiness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CreditCardTest {
    @Test
    public void constructorTest() {
        CreditCard card = new CreditCard("Rick", "123456789");
        assertNotNull(card);
    }
    @Test
    public void getOwnerTest() {
        CreditCard card = new CreditCard("Rick", "123456789");
        assertEquals("Rick", card.getOwner());
    }
    @Test
    public void getNumbeTestr() {
        CreditCard card = new CreditCard("Rick", "123456789");
        assertEquals("123456789", card.getNumber());
    }
}