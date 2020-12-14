package com.company;

import java.io.*;
import java.util.ArrayList;

public class Game {
    private int round;
    private ArrayList<Player> allPlayers;
    private Player primaryPlayer;
    private Player secondaryPlayer;
    private Store generalStore;
    private boolean attacked, moved;
    public Game(){
        allPlayers = new ArrayList<Player>();
        readCharacters("save.txt");
        //examples of magical and non magical playing characters for introductory purposes
        //allPlayers.add(new Druid ("Gnome", "Magical Player Example", 1));
        //allPlayers.add(new Barbarian("Dragonborn", "Non Magical Player Example", 1));
        round = 0;
        attacked = false;
        moved = false;
        generalStore = new Store(5,5,6);
        primaryPlayer = allPlayers.get(0);
        secondaryPlayer = allPlayers.get(1);
    }
    public void addPlayer(Player p){allPlayers.add(p);}
    public ArrayList<Player> getAllPlayers(){return allPlayers;}
    public Player getPrimaryPlayer(){return primaryPlayer;}
    public Player getSecondaryPlayer(){return secondaryPlayer;}

    public void makeStore(){
        generalStore = new Store(5,5,6);
    }
    public Store getGeneralStore(){
        return generalStore;
    }
    public void setAttacked(){attacked = true;}
    public boolean canAttack(){return attacked == false;}
    public void setMoved(){moved = true;}
    public boolean canMove(){return moved == false;}
    public void endRound(){round = 0;}
    public void endTurn(){
        attacked = false;
        moved = false;
        round++;
    }
    public boolean primeTurn(){
        if(round % 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void setPrimaryPlayer(Player p){
        primaryPlayer = p;
    }
    public void setSecondaryPlayer(Player p){
        secondaryPlayer = p;
    }

    public void readCharacters(String filename){
        //get saved characters
        try{
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String firstLine = in.readLine();
            boolean EOF = false;
            while(firstLine != null){
                String name = firstLine;
                String className = in.readLine();
                String raceName = in.readLine();
                int xp = Integer.parseInt(in.readLine());
                int hitDie = Integer.parseInt(in.readLine());
                int[] abilityScores = {Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine())};
                int gold = Integer.parseInt(in.readLine());

                Player p = makePlayer(name, raceName, className, xp, hitDie, abilityScores, gold);
                int numLines = Integer.parseInt(in.readLine());
                System.out.println(numLines);
                for(int i = 0; i < numLines; i++){
                    p.addToInventory(Store.getItemFromHashMap(in.readLine()));
                }
                addPlayer(p);
                firstLine = in.readLine();
            }
        }
        catch(FileNotFoundException e){
        }
        catch(IOException e){
        }

    }
    public void saveCharacters(String filename){
        //save characters
        try{
            PrintWriter out = new PrintWriter(new FileWriter(filename));
            for(Player p: allPlayers){
                out.println(p.getName());
                out.println(p.getClassName());
                out.println(p.getPlayerRace().getRaceName());
                out.println(p.getXP());
                out.println(p.getHitDie());

                out.println(p.getAbilityScores()[0]);
                out.println(p.getAbilityScores()[1]);
                out.println(p.getAbilityScores()[2]);
                out.println(p.getAbilityScores()[3]);
                out.println(p.getAbilityScores()[4]);
                out.println(p.getAbilityScores()[5]);

                out.println(p.getPurse());

                out.println(p.getInventory().size());
                for(Item item: p.getInventory()){
                    out.println(item.getName());
                }
                out.flush();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("test1");
        }
        catch (IOException e){
            System.out.println("test2");
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
