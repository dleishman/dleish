public class Pakuri {
    private String speciesName;
    private int attack;
    private int defense;
    private int speed;

    public Pakuri(String species){
        speciesName = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    public String getSpecies(){ return speciesName; } //returns the species name

    public int getAttack(){
        return attack;
    } //returns the assigned attack value

    public int getDefense(){
        return defense;
    } //returns the assigned defense value

    public int getSpeed(){
        return speed;
    } //returns the assigned speed value

    public int setAttack(int newAttack){ //assigns new attack value
        attack = newAttack;
        return attack;
    }

    public void evolve(){ //adjusts the Pakuri's attribute values when it evolves
        attack = attack * 2;
        defense = defense * 4;
        speed = speed * 3;
    }
}
