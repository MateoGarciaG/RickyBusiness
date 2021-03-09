package edu.pingpong.ricksybusiness.domain;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class UfosParkTest {
    
    private UfosPark ufosPark = null;
    private CreditCard abradolph = null;

    @Before
    public void setup() {
        this.ufosPark = new UfosPark();
        this.abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");

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

        assertEquals("unx", this.ufosPark.getUfoOf(this.abradolph.getNumber());

    }

    @Test
    public void containsCardTest() {

        assertEquals(true, this.ufosPark.containsCard(this.abradolph.getNumber()));
    }


}
