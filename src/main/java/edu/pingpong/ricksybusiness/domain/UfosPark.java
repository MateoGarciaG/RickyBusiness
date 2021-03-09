package edu.pingpong.ricksybusiness.domain;

import java.util.*;

public class UfosPark implements GuestDispatcher {

    private double fee = 0d;
    private final Map<String, String> flota = new HashMap<String, String>();

    UfosPark() {}

    void add(String ovni) {
        
		this.flota.putIfAbsent(ovni, null);
    }
    
    @Override
    public void dispatch(CreditCard creditCard) {
        System.out.println("dispatched");
        
    }

    String getUfoOf(String cardNumber) {
        
        String ufo = this.flota.entrySet().stream().map(Map.Entry::getKey );
        
    }


}
