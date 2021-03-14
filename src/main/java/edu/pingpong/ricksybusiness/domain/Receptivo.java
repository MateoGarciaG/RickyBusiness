package edu.pingpong.ricksybusiness.domain;

import java.util.*;

public class Receptivo implements GuestDispatcher{
    
    List<GuestDispatcher> observers = new ArrayList<GuestDispatcher>();

    public Receptivo() {
        /* Está vacío debido a que Receptivo es el Sujeto del cual observar otros componentes de tipo GuestDispatcher*/
    }

    /* Cambia a public a diferencia del UML debido a que no usado en el MAIN y la clase Receptivo está en otro paquete domain */
    public void registra(GuestDispatcher componente) {
        this.observers.add(componente);
    }

    /* Cambia a public a diferencia del UML debido a que no usado en el MAIN y la clase Receptivo está en otro paquete domain */
    @Override
    public void dispatch(CreditCard creditCard) {
        
        this.observers.stream().forEach(o -> o.dispatch(creditCard));
    }
}
