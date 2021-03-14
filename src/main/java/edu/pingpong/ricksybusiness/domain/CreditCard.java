package edu.pingpong.ricksybusiness.domain;

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

    /* En mi caso deben como las clases están distribuidas en el paquete damain y no en el de ricksybusiness. Por eso no funciona colocandoles packages, debido a que no están en el mismo paquete, y aunque en el diagrama UML, aparece que CreditCard debe estar dentro del paquete ricksyBusiness, he decidido tenerla en el paquete domain para separar el tipo de paquete al cual deberían pertenecer, CreditCard hace parte del dominio debido al DDD por eso lo he colocado en el paquete domain */
    public String cardOwner() {
        return this.owner;
    }
    public String number() {
        return this.number;
    }

    public Double credit() {
        return this.credit;
    }

    public boolean pay(double quantity) {

        this.credit -= quantity;

        return (this.credit <= 0d) ? false : true;
    }
    
    @Override
    public String toString() {
        return "Owner: " + this.cardOwner() + "number: " + this.number() + "Credit: " + this.credit() + this.SYMBOL;
    }
}
