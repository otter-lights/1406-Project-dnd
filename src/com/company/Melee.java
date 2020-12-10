package com.company;

public class Melee extends Weapon{
    public Melee(String name, int cost, double weight, int damage, String type, boolean twoHanded){
        super(name, cost, weight, damage, type, twoHanded);
    }

    public Melee(String name, int cost, double weight, int damage){
        super(name, cost, weight, damage);
    }

    public String toString(){
        if (this.getCost() < 10){
            return "A relatively cheap (compared to other stuff) " + getDamageType()  + " melee weapon. It weighs " + getWeight() + " lbs, costs " + getCost() + " gold piece(s), and does 1d" + getDamage() + " damage. " + getTwoHanded();
        } else if (this.getCost() < 25){
            return "An expensive " + getDamageType()  + " melee weapon. It weighs " + getWeight() + " lbs, costs " + getCost() + " gold piece(s), and does 1d" + getDamage() + " damage. " + getTwoHanded();
        } else {
            return "A VERY EXPENSIVE  " + getDamageType()  + " melee weapon. It weighs " + getWeight() + " lbs, costs " + getCost() + " gold piece(s), and does 1d" + getDamage() + " damage. " + getTwoHanded();
        }
    }
}
