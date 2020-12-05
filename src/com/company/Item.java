package com.company;

public abstract class Item {
    private double weight;
    public double getWeight(){
        return weight;
    }
    private int goldPieces;

    public Item(int cost, double weight){
        goldPieces = cost;
        this.weight = weight;
    }
}
