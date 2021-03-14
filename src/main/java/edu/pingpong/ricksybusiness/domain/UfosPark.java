package edu.pingpong.ricksybusiness.domain;

import java.util.*;
import java.util.stream.*;


public class UfosPark implements GuestDispatcher {

    private double fee = 0d;
    private final Map<String, String> flota = new HashMap<String, String>();

    
    public UfosPark() {
        /* Está vacío debido al ser un observador */
    }

    public void add(String ovni) {
        
		this.flota.putIfAbsent(ovni, null);
    }
    
    @Override
    public void dispatch(CreditCard creditCard) {
        
        /* Al ser un Stream, el flujo de entrada de los elementos ya sea de una colección o mapa(Entry:llave, valor) son desde el ultimo agrego hasta el primero secuencialmente hasta llegar al primero */
        this.flota.entrySet().stream().filter(e -> !this.flota.containsValue(creditCard.number()) && e.getValue() == null).findFirst().stream().map(entry -> {entry.setValue(creditCard.number()); creditCard.pay(fee); return entry;}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // creditCard.pay(fee);

    }

    public String getUfoOf(String cardNumber) {
        
        Optional<String> ufo = flota.entrySet().stream().filter(e -> e.getValue() == cardNumber).map(Map.Entry::getKey).findFirst();


        return (ufo.isPresent()) ? ufo.get() : ufo.orElse("There is not Ufo for this CardNumber");
    }

    /* Permanece package debido a que no es usado en el MAIN */
    boolean containsCard(String cardNumber) {
        return this.flota.containsValue(cardNumber);
    }

    /* Permanece package debido a que no es usado en el MAIN */
    Collection<String> cardNumbers() {

        return this.flota.values();
    }

    @Override
    public String toString() {
        /* %n == \n */
        return String.format("UFOS: %n %s", flota.keySet().toString());
    }




}
