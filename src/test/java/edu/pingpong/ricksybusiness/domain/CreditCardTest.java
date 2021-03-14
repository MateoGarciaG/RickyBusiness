package edu.pingpong.ricksybusiness.domain;

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
    public void cardOwnerTest() {

        assertEquals("Rick", this.card.cardOwner());
    }
    @Test
    public void numberTest() {

        assertEquals("123456789", this.card.number());
    }

    @Test
    public void creditTest() {
        /* al usar toString no es el toString() que usamos con polimorfismo
        sino de la clase Double, para convertir ese Double a un String*/
        // assertEquals("3000.0", this.card.credit().toString());
        assertEquals(3000.0d, this.card.credit(), 0);
    }

    @Test
    public void payTest() {

        /* Aún tiene credito, ya que por defecto el credito que tiene una nueva tarjeta es de: 3000.0d, por lo cual: 3000.0 - 2000.0 = 1000.0 */

        assertEquals(true, this.card.pay(2000));

        /* Ya no tiene credito, ya que por defecto el credito que tiene una nueva tarjeta es de: 3000.0d, por lo cual: 1000.0 - 1000.0 = 0 */

        assertEquals(false, this.card.pay(1000));
    }

}