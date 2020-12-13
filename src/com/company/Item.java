package com.company;

public abstract class Item {
    private double weight;
    private String name;
    public double getWeight(){
        return weight;
    }
    public int getPrice(){return goldPieces;}
    private int goldPieces;

    public Item(int cost, double weight, String name){
        this.name = name;
        goldPieces = cost;
        this.weight = weight;
    }

    public int getCost() { return goldPieces; }
    public String getName(){ return name; };
}
