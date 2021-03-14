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

    @Test
    public void dispatcherTest() {

        this.crystalExpender.dispatch(this.abradolph);

        assertEquals(2, this.crystalExpender.stock());

        /* Asignar un Pack a gearHead */
        CreditCard gearHead = new CreditCard("Gearhead", "8854545465766");

        this.crystalExpender.dispatch(gearHead);

        assertEquals(1, this.crystalExpender.stock());

        /* Le vacían la tarjeta de credito a gearHead, por lo cual ya no podría comprar otro pack */
        gearHead.pay(2950);

        /* Intento de compar otro pack para gearHead pero al ver que no tiene más creditos, no puede comprarlo*/
        this.crystalExpender.dispatch(gearHead);

        /* Debería mantenerse este ultimo pack del stock*/
        assertEquals(1, this.crystalExpender.stock());
    }

    @Test
    public void toStringTest() {

        assertEquals("stock: 3 \ncost: 50,0", this.crystalExpender.toString());
    }
}
