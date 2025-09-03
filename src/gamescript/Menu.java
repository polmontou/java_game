package gamescript;

import character.Character;
import character.Warrior;
import character.Wizard;
import db.CharacterTable;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private String[] classesAvailable;
    private ArrayList<Object[]> charactersAvailableDb;
    private ArrayList<Character> charactersAvailableScript;
    private CharacterTable characterTable;

    public Menu () {
        classesAvailable = new String[] {"Warrior", "Wizard"};
        charactersAvailableScript = new ArrayList<Character>();
        characterTable = new CharacterTable();
        charactersAvailableDb = this.characterTable.getCharacters();

        charactersFromDbToScript();
    }
    private void charactersFromDbToScript() {
        for (Object[] character : this.charactersAvailableDb) {
            Character newCharacter = getCharacter(character);
            charactersAvailableScript.add(newCharacter);
        }
    }
    /**
     * Displays a message in an easier way than System.out.println
     * @param message is the text you want to display
     */
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Uses Scanner to get user's answer and checks if it's a string
     * @return user's string answer
     */
    public String getUserString() {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String choice = "";

        while (!valid) {
            try {
                choice = input.nextLine();
                if (choice != "") {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                displayMessage("T'es pas la saucisse la plus grillée du paquet toi." +
                        "\nC'est un mot qu'on te demande!");
            }
        }
        return choice;
    }

    /**
     * Uses Scanner to get user's answer and checks if it's an int
     * @return user's int answer
     */
    public int getUserPosInt(int valueMax) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int choice = -1;

        while (!valid) {
            try {
                choice = input.nextInt();
                if (choice > 0 && choice <= valueMax) {
                    valid = true;
                } else {
                    displayMessage("Y'a que " + valueMax + " choix tête d'enclume.");
                }
            } catch (InputMismatchException e) {
                displayMessage("T'es pas la saucisse la plus grillée du paquet toi." +
                        "\nChoisis un nombre disponible");
                input.nextLine();
            }
        }

        return choice;
    }

    /**
     * Displays the game's title
     */
    public void displayTitle() {
        displayMessage(
                "************** Welcome in : **************" +
                "\nSAUSAGES AREN'T BURNT ENOUGH FOR HELL !!");
    }

    /**
     * Displays the game's beginning menu
     * @return an int which represents how many options are available
     */
    private int displayMenu() {
        displayMessage(
                "\nQue veux-tu faire?" +
                "\n1 - Créer ma saucisse" +
                "\n2 - Voir mes saucisses" +
                "\n3 - Démarrer la grillade" +
                "\n4 - Quitter le jeu");
        return 4;
    }

    /**
     * Parses user's choice in the beginning menu
     * @param choicesAvailable is how many options are available in the menu
     */
    private void parseUserMenuChoice(int choicesAvailable){
        int userChoice = getUserPosInt(choicesAvailable);
        Character player = null;
        int newId;

        switch (userChoice) {
            case 1 :
                displayMessage("Let's go créer ta future saucisse");

                // Name input
                displayMessage("Quel sera le nom de ta merguez?");
                String name = getUserString();

                // Type of character input
                displayMessage("Quelle classe veux-tu jouer?");
                for (int i = 0; i < this.classesAvailable.length; i++) {
                    displayMessage(i+1 + " - " + classesAvailable[i]);
                }
                int choice = getUserPosInt(this.classesAvailable.length);

                switch(choice) {
                    case 1:
                        player = new Warrior(name);
                        break;
                    case 2:
                        player = new Wizard(name);
                }
                charactersAvailableScript.add(player);
                displayMessage(player.toString());

                newId = characterTable.createCharacter(player);
                player.setId(newId);

                break;

            case 2 :
                displayCharacters();
                break;

            case 3 :
                if (!charactersAvailableScript.isEmpty()) {
                    if(charactersAvailableScript.size() == 1) {
                        Game game = new Game(charactersAvailableScript.get(0));
                    } else {
                        choice = displayCharacterChoice();
                        Game game = new Game(charactersAvailableScript.get(choice-1));
                    }
                }
                break;

            case 4 :
                displayMessage("A plus à barbeuc' land!");
                System.exit(0);
        }
    }

    private int displayCharacterChoice() {
        displayMessage("A qui c'est le tour de griller?");
        for  (int i = 0; i < this.charactersAvailableScript.size(); i++) {
            displayMessage((i+1) + " - " + this.charactersAvailableScript.get(i).getName()+ " le " +this.charactersAvailableScript.get(i).getFrenchType());
        }
        int choice = getUserPosInt(this.charactersAvailableScript.size());
        return choice;
    }
    /**
     * Displays the menu when user is checking a specific character in the menu
     * @param character is the character checked by user
     */
    private void displayCharacterMenu(Character character) {
        displayMessage("Que veux-tu faire sur "+ character.getName()+"?"+
                "\n1 - Le renommer"+
                "\n2 - Le supprimer"+
                "\n3 - I'm going, going back, back to Cali, Cali (retour au menu d'avant)");
        int choice = getUserPosInt(3);
        parseChoiceCharacterMenu(character, choice);
    }

    /**
     * Parses user's choice in the character menu
     * @param character is the character checked by user
     * @param choice is the choice done by user in character menu
     */
    private void parseChoiceCharacterMenu(Character character, int choice) {
        switch (choice) {
            case 1 :
                character.setName(getUserString());
                characterTable.updateCharacter(character);
                break;
            case 2 :
                charactersAvailableScript.remove(character);
                characterTable.deleteCharacter(character);
                break;
            case 3 :
                break;
        }
    }

    /**
     * Displays all the characters created
     */
    public void displayCharacters() {

        if (!charactersAvailableScript.isEmpty()) {
            displayMessage("Vos personnages :");
            for (int i = 0; i < charactersAvailableScript.size(); i++) {
                displayMessage((i + 1) + " - " + charactersAvailableScript.get(i).getName()+" le "+charactersAvailableScript.get(i).getFrenchType());
            }
            displayMessage("Lequel veux-tu voir?");

            int playerChoice = getUserPosInt(charactersAvailableScript.size());
            Character chosenCharacter = charactersAvailableScript.get(playerChoice - 1);

            displayMessage(chosenCharacter.toString());
            displayCharacterMenu(chosenCharacter);
        } else {
            displayMessage("Aucun de créé pour le moment!");
        }
    }

    private static Character getCharacter(Object[] character) {
        Character newCharacter = null ;
        int id = (int) character[0];
        String name = (String) character[1];
        String type = (String) character[2];

        switch (type) {
            case "Warrior":
                newCharacter = new Warrior(name);
                break;
            case "Wizard":
                newCharacter = new Wizard(name);
        }
        newCharacter.setId(id);
        return newCharacter;
    }

    public void displayMainMenu(){
        int choicesAvailable = displayMenu();
        parseUserMenuChoice(choicesAvailable);
    }

    public void updateCharacter(Character character) {
        characterTable.updateCharacter(character);
    }
}
