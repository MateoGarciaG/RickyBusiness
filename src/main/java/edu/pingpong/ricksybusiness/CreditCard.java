package edu.pingpong.ricksybusiness;

public class CreditCard {

    private String owner = "";
    private String number = "";

    public CreditCard(String owner, String number) {
        this.number = number;
        this.owner = owner;
    }
    public String getOwner() {
        return this.owner;
    }
    public String getNumber() {
        return this.number;
    }
    @Override
    public String toString() {
        return "Owner: " + this.getOwner() + "number: " + this.getNumber();
    }
}