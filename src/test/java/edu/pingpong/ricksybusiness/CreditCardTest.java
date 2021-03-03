package edu.pingpong.ricksybusiness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

    /* Inicializamos la variable que referenciará al objeto 
    CreditCard */
    private CreditCard card = null;

    
    @Before
    public void setup_card() {
        /* Tenemos que colocarle el THIS
        debido a que sino no puede ser usada en el resto
        de métodos u otras partes de la clase.*/
        this.card = new CreditCard("Rick", "123456789");
    }

    @Test
    public void constructorTest() {

        assertNotNull(this.card);
    }
    @Test
    public void getOwnerTest() {

        assertEquals("Rick", this.card.getOwner());
    }
    @Test
    public void getNumbeTestr() {

        assertEquals("123456789", this.card.getNumber());
    }

    @Test
    public void getCreditTest() {
        /* al usar toString no es el toString() que usamos con polimorfismo
        sino de la clase Double, para convertir ese Double a un String*/
        assertEquals("3000.0", this.card.getCredit().toString());
    }
}