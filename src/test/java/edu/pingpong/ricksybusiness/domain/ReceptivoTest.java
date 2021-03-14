package edu.pingpong.ricksybusiness.domain;

import static org.junit.Assert.*;

import org.junit.*;

public class ReceptivoTest {

    private Receptivo receptivo = null;
    private CreditCard abradolph = null;
    private CrystalExpender crystalExpender = null;
    private UfosPark ufosPark = null;

    @Before
    public void setup() {

        /* Objeto Receptivo */
        this.receptivo = new Receptivo();

        /* UfosPark Componente*/
        this.ufosPark = new UfosPark();

        /* CrystalExpender Componente */
        int stock = 3;
        double itemCost = 50;
        this.crystalExpender = new CrystalExpender(stock, itemCost);

        /* Tarjeta de Credito de Abradolph */
        this.abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");

    }

    @Test
    public void constructorTest() {
        assertNotNull(this.receptivo);
    }

    // @Test
    // public void dispatcherTest() { 

    // }
}
