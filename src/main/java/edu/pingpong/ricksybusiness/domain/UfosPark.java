package edu.pingpong.ricksybusiness.domain;

public class UfosPark implements GuestDispatcher {
    
    @Override
    public void dispatch(CreditCard creditCard) {
        System.out.println("dispatched");
        
    }
}
