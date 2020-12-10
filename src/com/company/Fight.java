package com.company;

public class Fight {
    public Fight(Player p1, Player p2){

    }
    public static void main(String[] args){
        Player p1 = new Cleric("Dragonborn", "Player 1");
        Player p2 = new Druid("Gnome", "Player 2");


        while(p1.isAlive() && p2.isAlive()){
            p1.turn(p2);
            p2.turn(p1);
        }
        Player winner = p1;
        Player loser = p2;

        winner.addXP(loser.getLevel()*100);
        loser.addXP(winner.getLevel()*50);
        p1.longRest();
        p2.longRest();
    }


}
