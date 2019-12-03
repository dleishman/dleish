import java.util.Scanner;

public class PakuriProgram {

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        String input;
        int capacity;
        int userChoice = 0;


        //main menu welcome message
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.println("Enter max capacity of the Pakudex:");

        while (true) {
            try {
                capacity = scn.nextInt();//sets the capacity of the Pakudex to the users input
                if (capacity <= 0) {
                    System.out.println("Please enter a valid size.");
                    System.out.println("Enter max capacity of the Pakudex:");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid size.");
                System.out.println("Enter max capacity of the Pakudex:");
                scn.next();
            }
        }

        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri. \n");
        Pakudex pakudex = new Pakudex(capacity);


        while (userChoice != 6) {
            //main menu choices
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit \n");
            System.out.print("What would you like to do? ");

            while (true) {
                try {
                    userChoice = scn.nextInt(); //sets the variable userChoice to the user input value for the menu
                    break;
                } catch (Exception e) {
                    System.out.println("Unrecognized menu selection!\n");
                    System.out.println("Pakudex Main Menu");
                    System.out.println("-----------------");
                    System.out.println("1. List Pakuri");
                    System.out.println("2. Show Pakuri");
                    System.out.println("3. Add Pakuri");
                    System.out.println("4. Evolve Pakuri");
                    System.out.println("5. Sort Pakuri");
                    System.out.println("6. Exit \n");
                    System.out.print("What would you like to do? ");
                    scn.next();
                }
            }

            switch (userChoice) {
                case 1: //list the Pakuri already in the Pakudex
                    if (pakudex.arraySize == 0) {
                        System.out.println("No Pakuri in Pakudex yet!\n");
                    } else {
                        System.out.println("Pakuri In Pakudex:");
                        pakudex.getSpeciesArray();
                        for (int i = 0; i < pakudex.getSize(); i++) {
                            System.out.println((i + 1) + ". " + pakudex.array[i].getSpecies());
                        }
                        System.out.println();
                    }
                    break;
                case 2: //show the attribute values for a specified Pakuri
                    System.out.println("Enter the name of the species to display:");
                    String speciesStat = scn.next();
                    int[] stats = pakudex.getStats(speciesStat);
                    boolean cont = true;
                    while (cont) {
                        for (int i = 0; i < pakudex.arraySize; i++) {
                            if (pakudex.array[i].getSpecies().equals(speciesStat)) {
                                System.out.println("Species: " + speciesStat);
                                System.out.println("Attack: " + stats[0]);
                                System.out.println("Defense: " + stats[1]);
                                System.out.println("Speed: " + stats[2] + "\n");
                                cont = false;
                            }
                        }
                        if (cont) {
                            System.out.println("Error: No such Pakuri!\n");
                            cont = false;
                        }
                    }
                    break;
                case 3: //add a new Pakuri to the Pakudex array
                    if (pakudex.getSize() == pakudex.getCapacity()) {
                        System.out.println("Error: Pakudex is full!\n");
                        break;
                    }
                    System.out.println("Enter the name of the species to add: ");
                    String newSpecies = scn.next();
                    if (pakudex.addPakuri(newSpecies)) {
                        System.out.println("Pakuri species " + newSpecies + " successfully added!\n");
                    } else {
                        if(pakudex.getSpeciesArray() != null) {
                            for (int i = 0; i < pakudex.getSpeciesArray().length; i++) {
                                if (pakudex.array[i].getSpecies().equals(newSpecies)) {
                                    System.out.println("Error: Pakudex already contains this species!\n");
                                }
                            }
                        }

                    }

                    break;
                case 4: //evolves a specified Pakuri
                    System.out.println("Enter the name of the species to evolve: ");
                    String speciesEvolve = scn.next();
                    if (pakudex.evolveSpecies(speciesEvolve)) {
                        System.out.println(speciesEvolve + " has been evolved!");
                    } else {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;
                case 5: //sorts the Pakuri in lexicographical order
                    pakudex.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                    break;
                case 6: //quits the program
                    System.out.println("Thanks for using Pakudex! Bye!\n");
                    break;
                default:
                    System.out.println("Unrecognized menu selection!");
            }

        }
    }

}

