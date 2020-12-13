package com.company;

import java.io.*;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> allPlayers;
    private Player primaryPlayer;
    private Player secondaryPlayer;
    public Game(){
        allPlayers = new ArrayList<Player>();
        allPlayers.add(new Druid ("Gnome", "Player 1"));
        primaryPlayer = allPlayers.get(0);
    }
    public void addPlayer(Player p){allPlayers.add(p);}
    public ArrayList<Player> getAllPlayers(){return allPlayers;}
    public Player getPrimaryPlayer(){return primaryPlayer;}
    public Player getSecondaryPlayer(){return secondaryPlayer;}

    public void setPrimaryPlayer(Player p){
        primaryPlayer = p;
    }
    public void setSecondaryPlayer(Player p){
        secondaryPlayer = p;
    }

    public void readCharacters(String filename){
        try{
            DataInputStream in = new DataInputStream(new FileInputStream(filename));
            boolean EOF = false;
            while(!EOF){
                try {
                    String name = in.readUTF();
                    String className = in.readUTF();
                    String raceName = in.readUTF();
                    int xp = in.readInt();
                    int hitDie = in.readInt();
                    int[] abilityScores = {in.readInt(), in.readInt(), in.readInt(), in.readInt(), in.readInt(), in.readInt()};
                    int gold = in.readInt();

                    addPlayer(makePlayer(name, raceName, className, xp, hitDie, abilityScores, gold));
                }
                catch(EOFException e){
                    EOF = true;
                }
            }
        }
        catch(FileNotFoundException e){
        }
        catch(IOException e){
        }

    }
    public void saveCharacters(String filename){
        try{
            DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
            for(Player p: allPlayers){
                out.writeUTF(p.getName());
                out.writeUTF(p.getClassName());
                out.writeUTF(p.getPlayerRace().getRaceName());
                out.writeInt(p.getXP());
                out.writeInt(p.getHitDie());

                out.writeInt(p.getAbilityScores()[0]);
                out.writeInt(p.getAbilityScores()[1]);
                out.writeInt(p.getAbilityScores()[2]);
                out.writeInt(p.getAbilityScores()[3]);
                out.writeInt(p.getAbilityScores()[4]);
                out.writeInt(p.getAbilityScores()[5]);

                out.writeInt(p.getPurse());
            }
        }
        catch(FileNotFoundException e){
        }
        catch (IOException e){
        }
    }
    public static Player makePlayer(String name, String raceName, String className, int xp, int hitDie, int[] abilityScores, int gold){
        if(className.equals("Barbarian")){
            return new Barbarian(raceName, name, gold, xp, hitDie, abilityScores);
        }
        else if(className.equals("Bard")){
            return new Bard(raceName, name, gold, xp, hitDie, abilityScores);
        }
        else if(className.equals("Cleric")){
            return new Cleric(raceName, name, gold, xp, hitDie, abilityScores);
        }
        else if(className.equals("Druid")){
            return new Druid(raceName, name, gold, xp, hitDie, abilityScores);
        }
        else if(className.equals("Fighter")){
            return new Fighter(raceName, name, gold, xp, hitDie, abilityScores);
        }
        else if(className.equals("Monk")){
            return new Monk(raceName, name, gold, xp, hitDie, abilityScores);
        }
        else if(className.equals("Rouge")){
            return new Rogue(raceName, name, gold, xp, hitDie, abilityScores);
        }
        else if(className.equals("Sorcerer")){
            return new Sorcerer(raceName, name, gold, xp, hitDie, abilityScores);
        }
        else if(className.equals("Wizard")){
            return new Wizard(raceName, name, gold, xp, hitDie, abilityScores);
        }
        return null;
    }
}
