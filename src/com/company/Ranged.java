package com.company;

public class Ranged extends Weapon{
    private int range;

    public Ranged(String name, int cost, double weight, int damage, String type, boolean twoHanded, int range){
        super(name, cost, weight, damage, type, twoHanded, range);
    }

    public String toString(){
        if (this.getCost() < 10){
            return "A relatively cheap (compared to other stuff) " + getDamageType()  + " ranged weapon with a range of " + range + " ft. It weighs " + getWeight() + " lbs, costs " + getCost() + " gold piece(s), and does 1d" + getDamage() + " damage. " + getTwoHanded();
        } else if (this.getCost() < 25){
            return "An expensive " + getDamageType()  + " ranged weapon with a range of " + range + " ft. It weighs " + getWeight() + " lbs, costs " + getCost() + " gold piece(s), and does 1d" + getDamage() + " damage. " + getTwoHanded();
        } else {
            return "A VERY EXPENSIVE  " + getDamageType()  + " ranged weapon with a range of " + range + " ft. It weighs " + getWeight() + " lbs, costs " + getCost() + " gold piece(s), and does 1d" + getDamage() + " damage. " + getTwoHanded();
        }
    }
}
