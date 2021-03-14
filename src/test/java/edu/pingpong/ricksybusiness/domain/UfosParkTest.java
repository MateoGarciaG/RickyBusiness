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
        String[] ufosID = { "unx", "dox"};
        Arrays.asList(ufosID).forEach(ovni -> this.ufosPark.add(ovni));
    }

    @Test
    public void constructorTest() {
        assertNotNull(this.ufosPark);
    }

    @Test
    public void asignOvniTest() { 

        /* Asignar un Ufo ha está tarjeta */
        this.ufosPark.dispatch(this.abradolph);

        assertEquals(true, this.ufosPark.containsCard(this.abradolph.number()));

        /* Asignar un Ufo a gearHead */
        CreditCard gearHead = new CreditCard("Gearhead", "8854545465766");

        this.ufosPark.dispatch(gearHead);

        assertEquals(true, this.ufosPark.containsCard(gearHead.number()));
    }

    @Test
    public void getUfoOfTest() {

        /* Asignar un Ufo ha está tarjeta */
        /* Debido a que este método usa Stream(), se el asignará el ultimo Ufo de Map.Entry que no tenga aún no cardNumber asignado, y no desdeº el primero */
        this.ufosPark.dispatch(this.abradolph);

        assertEquals("dox", this.ufosPark.getUfoOf(this.abradolph.number()));


        CreditCard gearHead = new CreditCard("Gearhead", "8854545465766");

        /* No es el mismo número de la tarjeta, por lo cual no tiene ningún Ovni asignado*/
        assertEquals("There is not Ufo for this CardNumber", this.ufosPark.getUfoOf(gearHead.number()));

        /* Intento de asignar otro Ovni a Abradolph, pero al ver que ya tiene uno, ignora la petición */
        this.ufosPark.dispatch(this.abradolph);

        /* Como abradolph ya está registrado, el Ufo sigue siendo el mismo */
        assertEquals("dox", this.ufosPark.getUfoOf(this.abradolph.number()));

        /* Comprobar ahora con la CreditCard: gearHead */
        this.ufosPark.dispatch(gearHead);

        assertEquals("unx", this.ufosPark.getUfoOf(gearHead.number()));



    }

    @Test
    public void containsCardTest() {

        this.ufosPark.dispatch(this.abradolph);

        assertEquals(true, this.ufosPark.containsCard(this.abradolph.number()));

        CreditCard gearHead = new CreditCard("Gearhead", "8854545465766");

        assertEquals(false, this.ufosPark.containsCard(gearHead.number()));

        this.ufosPark.dispatch(gearHead);

        assertEquals(true, this.ufosPark.containsCard(gearHead.number()));
    }

    @Test
    public void cardNumbers() {

        this.ufosPark.dispatch(this.abradolph);

        CreditCard gearHead = new CreditCard("Gearhead", "8854545465766");

        this.ufosPark.dispatch(gearHead);

        assertEquals(2, this.ufosPark.cardNumbers().size());

        /* Array con el tamaño de la Collection<String> para despues pasarlo por el parametro toArray() con el fin de asegurar el tipo de Dato que retornará el método toArray(), es decir, antes: Object[], despues: String[] */
        String[] cardNumbers = new String[this.ufosPark.cardNumbers().size()];

        System.out.println(this.ufosPark.cardNumbers().toArray(cardNumbers));

        assertArrayEquals(new String[]{"4916119711304546", "8854545465766"}, this.ufosPark.cardNumbers().toArray(cardNumbers));
    }






}
