package edu.pingpong.ricksybusiness.domain;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class UfosParkTest {
    
    private UfosPark ufosPark = null;
    private CreditCard abradolph = null;
    private CreditCard gearHead;

    @Before
    public void setup() {
        this.ufosPark = new UfosPark();
        this.abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
        this.gearHead = new CreditCard("Gearhead", "8888888888888888");

        // Da de alta en la flota de ovnis 2 UFOS.
        String[] ufosID = { "unx", "dox" };
        Arrays.asList(ufosID).forEach(ovni -> this.ufosPark.add(ovni));
    }

    @Test
    public void constructorTest() {
        assertNotNull(this.ufosPark);
    }

    @Test
    public void asignOvniTest() {

        this.ufosPark.dispatch(this.abradolph);

        assertEquals("unx", this.ufosPark.getUfoOf(this.abradolph.getNumber()));

        /* No es el mismo número de la tarjeta, por lo cual no tiene ningún Ovni asignado*/
        assertEquals("There is not Ufo for this CardNumber", this.ufosPark.getUfoOf(this.gearHead.getNumber()));

    }

    @Test
    public void containsCardTest() {

        assertEquals(true, this.ufosPark.containsCard(this.abradolph.getNumber()));
    }


}
