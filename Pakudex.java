public class Pakudex {
    Pakuri[] array;
    int arraySize = 0;

    public Pakudex(){ //default length for the Pakudex array
        array = new Pakuri[20];
    }

    public Pakudex(int capacity){ //makes a Pakudex array with a specified length
        array = new Pakuri[capacity];
    }

    public int getSize(){
        return arraySize;
    }

    public int getCapacity(){
        int arrayCapacity = array.length;
        return arrayCapacity;
    }

    public String[] getSpeciesArray(){
        if(getSize() == 0){
            return null;
        }else {
            String[] speciesArray = new String[getSize()];
            for(int i = 0; i < arraySize; i++){
                speciesArray[i] = array[i].getSpecies();
            }
            return speciesArray;
        }
    }

    public int[] getStats(String species){
        int[] pakuriStats = new int[3];
        boolean exists = false;
        for(int i = 0; i < arraySize; i++){
            if(array[i].getSpecies().equals(species)){
                pakuriStats[0]= array[i].getAttack();
                pakuriStats[1]= array[i].getDefense();
                pakuriStats[2]= array[i].getSpeed();
                exists = true;
            }
        }
        if(exists == false){
            return null;
        }else{
            return pakuriStats;
        }
    }

    public void sortPakuri(){
        Pakuri[] temp = new Pakuri[1];
        for(int z = 0; z < arraySize; z++) {
            for (int i = 0; i < getSize() - 1; i++) {
                if (array[i].getSpecies().compareTo(array[i + 1].getSpecies()) > 0) {
                    temp[0] = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp[0];
                }
            }
        }
    }

    //this adds a Pakuri
    public boolean addPakuri(String species){
        boolean doesntExist = false;
        int placement = getSize();
        for(int i = 0; i < arraySize; i++){
            if(array[i].getSpecies().equals(species)){
                doesntExist = true;
            }
        }
        if(getCapacity() > placement && doesntExist == false){
            array[placement] = new Pakuri(species);
            arraySize++;
             return true;
        }
        return false;
    }

    public boolean evolveSpecies(String species){
        boolean evolved = false;
        for(int i = 0; i < arraySize; i++){
            if(array[i].getSpecies().equals(species)){
                array[i].evolve();
                evolved = true;
            }
        }
        return evolved;
    }


}
