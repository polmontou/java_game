package gamescript;

import character.Character;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Menu {

    private String[] classesAvailable;
    private List<Character> charactersAvailable;

    public Menu () {
        classesAvailable = new String[] {"Warrior", "Wizard"};
        charactersAvailable = new ArrayList<Character>();
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }
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
            } catch (java.util.InputMismatchException e) {
                displayMessage("T'es pas la saucisse la plus grillée du paquet toi." +
                        "\nC'est un mot qu'on te demande!");
            }
        }
        return choice;
    }

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
            } catch (java.util.InputMismatchException e) {
                displayMessage("T'es pas la saucisse la plus grillée du paquet toi." +
                        "\nChoisis un nombre disponible");
                input.nextLine();
            }
        }

        return choice;
    }
    public void displayTitle() {
        displayMessage(
                "************** Welcome in : **************" +
                "\nSAUSAGES AREN'T BURNT ENOUGH FOR HELL !!");
    }
    private int displayMenu() {
        displayMessage(
                "\nQue veux-tu faire?" +
                "\n1 - Créer ma saucisse" +
                "\n2 - Voir mes saucisses" +
                "\n3 - Démarrer la grillade" +
                "\n4 - Quitter le jeu");
        return 4;
    }

    private void parseUserMenuChoice(int choicesAvailable) {
        int userChoice = getUserPosInt(choicesAvailable);
        String name = "";
        String type = "";

        switch (userChoice) {
            case 1 :
                displayMessage("Let's go créer ta future saucisse");
                // Name input
                displayMessage("Quel sera le nom de ta merguez?");
                name = getUserString();
                // Type of character input
                displayMessage("Quelle classe veux-tu jouer?");
                for (int i = 0; i < this.classesAvailable.length; i++) {
                    displayMessage(i+1 + " - " + classesAvailable[i]);
                }
                int choice = getUserPosInt(this.classesAvailable.length);
                type = classesAvailable[choice-1];

                Character player1 = new Character(type, name);
                charactersAvailable.add(player1);
                displayMessage(player1.toString());

                break;
            case 2 :
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

    private void displayCharacterMenu(Character character) {
        displayMessage("Que veux-tu faire sur "+ character.getName()+"?"+
                "\n1 - Le renommer"+
                "\n2 - Le supprimer"+
                "\n3 - I'm going, going back, back to Cali, Cali (retour au menu d'avant)");
        int choice = getUserPosInt(3);
        parseChoiceCharacterMenu(character, choice);
    }

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


    public void displayMainMenu() {
        int choicesAvailable = displayMenu();
        parseUserMenuChoice(choicesAvailable);
    }
}
