package edu.pingpong.ricksybusiness.domain;

public class CrystalExpender implements GuestDispatcher{

    private int stock = 0;
    private double itemCost = 0.0d;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(CreditCard creditCard) {
        
        if(this.stock() > 0 && creditCard.pay(this.itemCost)) {
            this.stock -= 1;
        }
    }

    /* Cambia a public a diferencia del UML debido a que no usado en el MAIN y la clase CrystalExpender está en otro paquete domain */
    public int stock() {
        return this.stock;
    }

    @Override
    public String toString() {
        return String.format("stock: %d \ncost: %.1f", this.stock(), this.itemCost);
    }
}
