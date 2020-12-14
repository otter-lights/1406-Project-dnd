package com.company;

public abstract class Item {
    private double weight;
    private int goldPieces;

    public Item(int cost, double weight){
        goldPieces = cost;
        this.weight = weight;
    }

    public int getCost() { return goldPieces; }
    public double getWeight(){ return weight; }
    public int getPrice(){return goldPieces;}
}
