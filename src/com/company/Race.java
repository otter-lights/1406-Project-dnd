package com.company;
import java.util.Random;
import java.util.ArrayList;


abstract public class Race {
    String size;
    int baseSpeed;
    //this will be a 6 int array containing the base ability score increases for each race.
    // Order is {Strength, Dex, Con, Int, Wis, Charisma}
    int[] abilityIncrease = new int[6];
    boolean darkvision;
    public Race(String chosenRace){
        if(chosenRace.equals("Gnome")){
            //Rock Gnome Stats
            size = "Small";
            baseSpeed = 25;
            darkvision = true;

            //intelligence increase
            abilityIncrease[3] = 2;
            //con increase
            abilityIncrease[2] = 1;
        }
        else if(chosenRace.equals("Halfling")){
            size = "Small";
            baseSpeed = 25;
            darkvision = false;
            // sets the dex increase to +2
            abilityIncrease[1] = 2;
            // sets the con increase to +1
            abilityIncrease[2] = 1;
        }
        else if(chosenRace.equals("Dwarf")){
            //Hill Dwarf
            size = "Medium";
            baseSpeed = 25;
            darkvision = true;

            //con increase
            abilityIncrease[2] = 2;
            //wis increase
            abilityIncrease[4] = 1;
        }
        else if(chosenRace.equals("Dragonborn")){
            size = "Medium";
            baseSpeed = 30;
            darkvision = false;

            //strength increase
            abilityIncrease[0] = 2;
            //charisma increase
            abilityIncrease[5] = 1;
        }
        else if(chosenRace.equals("Elf")){
            //wood elf
            size = "Medium";
            baseSpeed = 30;
            darkvision = true;

            //dex increase
            abilityIncrease[1] = 2;
            //wis increase
            abilityIncrease[4] = 1;
        }
        else if(chosenRace.equals("HalfElf")){
            size = "Medium";
            baseSpeed = 30;
            darkvision = true;

            //charisma increase
            abilityIncrease[5] = 2;

            Random rand = new Random();
            ArrayList<Integer> options = new ArrayList<>();
            int firstIncrease = rand.nextInt(5);
            int secondIncrease = rand.nextInt(5);

            while(secondIncrease == firstIncrease){
                secondIncrease = rand.nextInt(5);
                if(secondIncrease != firstIncrease){
                    break;
                }
            }
            abilityIncrease[firstIncrease] = 1;
            abilityIncrease[secondIncrease] = 1;
        }
        else if(chosenRace.equals("HalfOrc")){
            size = "Medium";
            baseSpeed = 30;
            darkvision = true;

            //strength increase
            abilityIncrease[0] = 2;
            //con increase
            abilityIncrease[2] = 1;
        }
        else if(chosenRace.equals("Human")){
            size = "Medium";
            baseSpeed = 30;
            darkvision = false;

            //+1 to all scores
            abilityIncrease[0] = 1;
            abilityIncrease[1] = 1;
            abilityIncrease[2] = 1;
            abilityIncrease[3] = 1;
            abilityIncrease[4] = 1;
            abilityIncrease[5] = 1;
        }
        else if(chosenRace.equals("Tiefling")){
            size = "Medium";
            baseSpeed = 30;
            darkvision = true;

            //intelligence increase
            abilityIncrease[3] = 1;
            //charisma increase
            abilityIncrease[5] = 2;
        }
        else{
            System.out.println("Invaild Race");
        }
    }
    public String getSize(){
        return size;
    }
    public int[] getAbilityIncrease() { return abilityIncrease; }
}
