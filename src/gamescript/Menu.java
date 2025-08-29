package gamescript;

import character.Character;
import character.Warrior;
import character.Wizard;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Menu {

    private String[] classesAvailable;
    private List<Character> charactersAvailable;

    public Menu () {
        classesAvailable = new String[] {"Warrior", "Wizard"};
        charactersAvailable = new ArrayList<Character>();
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
    public static String getUserString() {
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
    public static int getUserPosInt(int valueMax) {
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

        switch (userChoice) {
            case 1 :
                Menu.displayMessage("Let's go créer ta future saucisse");

                // Name input
                Menu.displayMessage("Quel sera le nom de ta merguez?");
                String name = Menu.getUserString();

                // Type of character input
                Menu.displayMessage("Quelle classe veux-tu jouer?");
                for (int i = 0; i < this.classesAvailable.length; i++) {
                    Menu.displayMessage(i+1 + " - " + classesAvailable[i]);
                }
                int choice = Menu.getUserPosInt(this.classesAvailable.length);

                switch(choice) {
                    case 1:
                        player = new Warrior(name);
                        break;
                    case 2:
                        player = new Wizard(name);
                }
                charactersAvailable.add(player);
                displayMessage(player.toString());
                break;

            case 2 :
                displayCharacters();
                break;

            case 3 :
                if (!charactersAvailable.isEmpty()) {
                    if(charactersAvailable.size() == 1) {
                        Game game = new Game(charactersAvailable.get(0));
                    }
                }
                break;

            case 4 :
                displayMessage("A plus à barbeuc' land!");
                System.exit(0);
        }
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
                break;
            case 2 :
                charactersAvailable.remove(character);
                break;
            case 3 :
                break;
        }
    }

    /**
     * Displays all the characters created
     */
    public void displayCharacters() {
        if (!charactersAvailable.isEmpty()) {
            displayMessage("Vos personnages :");
            for (int i = 0; i < charactersAvailable.size(); i++) {
                displayMessage((i + 1) + " - " + charactersAvailable.get(i).getName());
            }
            displayMessage("Lequel veux-tu voir?");

            int playerChoice = getUserPosInt(charactersAvailable.size());
            Character chosenCharacter = charactersAvailable.get(playerChoice - 1);

            displayMessage(chosenCharacter.toString());
            displayCharacterMenu(chosenCharacter);
        } else {
            displayMessage("Aucun de créé pour le moment!");
        }
    }

    public void displayMainMenu(){
        int choicesAvailable = displayMenu();
        parseUserMenuChoice(choicesAvailable);
    }
}
