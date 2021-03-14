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
        
        this.flota.entrySet().stream().filter(e -> e.getValue() == null).map(entry -> {entry.setValue(creditCard.number()); creditCard.pay(fee); return entry;}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        // this.flota.entrySet().stream().filter(e -> e.getValue().equals(creditCard.number()) && )
    }

    public String getUfoOf(String cardNumber) {
        
        Optional<String> ufo = flota.entrySet().stream().filter(e -> e.getValue().equals(cardNumber)).map(Map.Entry::getKey).map(u -> u.toString()).findFirst();

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
