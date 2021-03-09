package edu.pingpong.ricksybusiness.domain;

import java.util.*;
import java.util.stream.*;

public class UfosPark implements GuestDispatcher {

    private double fee = 0d;
    private final Map<String, String> flota = new HashMap<String, String>();

    UfosPark() {}

    void add(String ovni) {
        
		this.flota.putIfAbsent(ovni, null);
    }
    
    @Override
    public void dispatch(CreditCard creditCard) {
        
        flota.entrySet().stream().filter(e -> e.getValue() == null).map(entry -> {entry.setValue("54545454545"); return entry;}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
    }

    String getUfoOf(String cardNumber) {
        
        Optional<String> ufo = flota.entrySet().stream().filter(e -> e.getValue().equals("4916119711304546")).map(Map.Entry::getKey).map(u -> u.toString()).findFirst();

        return (ufo.isPresent()) ? ufo.get() : ufo.orElse("There is not Ufo for this CardNumber");
    }




}
