package com.company;

public abstract class Item {
    private double weight;
    public double getWeight(){
        return weight;
    }
    private int cost;

    public Item(int cost, double weight){
        this.cost = cost;
        this.weight = weight;
    }

    public int getCost() { return cost; }
}
