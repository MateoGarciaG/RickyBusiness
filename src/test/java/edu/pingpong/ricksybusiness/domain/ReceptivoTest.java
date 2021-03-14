package edu.pingpong.ricksybusiness.domain;

import static org.junit.Assert.*;

import java.util.*;

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
        // Da de alta en la flota de ovnis 2 UFOS.
        String[] ufosID = { "unx", "dox", "trex"};
        Arrays.asList(ufosID).forEach(ovni -> this.ufosPark.add(ovni));

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

    @Test
    public void dispatcherTest() { 
        
        /* Registro de los componentes: ufosPark y CrystalExpender */
        this.receptivo.registra(this.ufosPark);

        this.receptivo.registra(this.crystalExpender);

        /* Implementa el metodo receptivo.dispatch()
        para que invoque a UfosPark.dispatch()
        y a CrystalExpender.dispatch()*/
        this.receptivo.dispatch(this.abradolph);

        /* Comprovamos mediante el componente ufosPark que efectivamente:
        receptivo.dispatch invoco ufosPark.dispatch, donde abradolph debería tener asignado a un ovni */
        assertEquals(true, this.ufosPark.containsCard(this.abradolph.number()));

        /* Comprovamos que se asignado un pack de CrystalExpender a abradolph */
        assertEquals(2, this.crystalExpender.stock());

        assertEquals("trex", this.ufosPark.getUfoOf(this.abradolph.number()));

        /* Asignar un Ufo a gearHead */
        CreditCard gearHead = new CreditCard("Gearhead", "8854545465766");

        this.receptivo.dispatch(gearHead);

        assertEquals(true, this.ufosPark.containsCard(gearHead.number()));

        assertEquals(1, this.crystalExpender.stock());

        assertEquals("dox", this.ufosPark.getUfoOf(gearHead.number()));

        CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");

        this.receptivo.dispatch(squanchy);

        assertEquals(true, this.ufosPark.containsCard(squanchy.number()));

        assertEquals(0, this.crystalExpender.stock());

        assertEquals("unx", this.ufosPark.getUfoOf(squanchy.number()));

    }

    @Test
    public void costeDispatcherTest() {

        /* Registro de los componentes: ufosPark y CrystalExpender */
        this.receptivo.registra(this.ufosPark);

        this.receptivo.registra(this.crystalExpender);

        this.receptivo.dispatch(this.abradolph);


        assertEquals(true, this.ufosPark.containsCard(this.abradolph.number()));

        /* Comprovamos que se asignado un pack de CrystalExpender a abradolph */
        assertEquals(2, this.crystalExpender.stock());

        /* Comprovar si se realizó los gastos de ufosPark y CrystalExpender sobre la tarjeta de credito de abradolph */
        assertEquals(2450.0, this.abradolph.credit(), 0);
    }
}
