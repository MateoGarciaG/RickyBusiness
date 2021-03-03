package edu.pingpong.ricksybusiness;

public class CreditCard {

    private String owner = "";
    private String number = "";
    private Double credit = 0d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.number = number;
        this.owner = owner;
        /* La D recordemos es para señalarle que esun tipo
        double, pero como la variable "credit" es de tipo
        Double(que es una clase recordemos), entonces convierte este núero primitivo double en tipo Double*/
        this.credit = 3000.0d; 
    }
    public String getOwner() {
        return this.owner;
    }
    public String getNumber() {
        return this.number;
    }

    public Double getCredit() {
        return this.credit;
    }
    @Override
    public String toString() {
        return "Owner: " + this.getOwner() + "number: " + this.getNumber() + "Credit: " + this.getCredit() + this.SYMBOL;
    }
}
