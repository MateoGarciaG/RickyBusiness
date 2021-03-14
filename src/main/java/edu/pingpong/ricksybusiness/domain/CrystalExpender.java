package edu.pingpong.ricksybusiness.domain;

public class CrystalExpender implements GuestDispatcher{

    private int stock = 0;
    private double itemCost = 0d;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }


    @Override
    public void dispatch(CreditCard creditCard) {
        System.out.println("");
    }

    /* Cambia a public a diferencia del UML debido a que no usado en el MAIN y la clase CrystalExpender está en otro paquete domain */
    public int stock() {
        return this.stock;
    }

    @Override
    public String toString() {
        return String.format("%d %d", this.stock(), this.itemCost);
    }
}
