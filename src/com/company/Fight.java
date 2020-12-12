package com.company;

public class Fight {
    Player p1;
    Player p2;
    int rounds;
    public Fight(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
        Player winner = p1;
        Player loser = p2;
        winner.addXP(loser.getLevel()*100);
        loser.addXP(winner.getLevel()*50);
        p1.longRest();
        p2.longRest();
    }
}
