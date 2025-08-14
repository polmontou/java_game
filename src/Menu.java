import java.util.Scanner;

public class Menu {
    public static void displayMessage(String message) {
        System.out.println(message);
    }
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
            } catch (java.util.InputMismatchException e) {
                displayMessage("T'es pas la saucisse la plus grillée du paquet toi." +
                        "\n C'est un mot qu'on te demande!");
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
            } catch (java.util.InputMismatchException e) {
                displayMessage("T'es pas la saucisse la plus grillée du paquet toi." +
                        "\n Choisis un nombre disponible");
            }
            if (choice > 0 && choice <= valueMax) {
                valid = true;
            } else {
                displayMessage("Y'a que " + valueMax + " choix tête d'enclume.");
            }
        }

        return choice;
    }

    private static int displayMenu() {
        displayMessage("************** Welcome in : **************" +
                "\nSAUSAGES AREN'T BURNT ENOUGH FOR HELL !!" +
                "\n\nQue voulez-vous faire?" +
                "\n1 - Créer votre personnage" +
                "\n2 - Quitter le jeu");
        return 2;
    }

    private static void parseUserMenuChoice(int possibleChoices) {
        int userChoice = getUserPosInt(possibleChoices);
        String name = "";
        String type = "";

        switch (userChoice) {
            case 1 :
                displayMessage("Let's go créer ta future saucisse");
                try {
                    // Name input
                    displayMessage("Quel sera le nom de ta merguez?");
                    name = getUserString();
                    // Type of character input
                    displayMessage("Quelle classe tu veux jouer?" +
                            "\n1 - Warrior" +
                            "\n2 - Wizard");
                    int choice = getUserPosInt(2);
                    switch (choice) {
                        case 1:
                            type = "warrior";
                            break;
                        case 2:
                            type = "wizard";
                            break;
                    }
                    Character player1 = new Character(type, name);
                    displayMessage(player1.toString());

                } catch (java.util.InputMismatchException e) {
                    displayMessage("Réfléchis, ton cerveau a pas encore trop cuit.");
                }
                break;
            case 2 :
                displayMessage("A plus à barbeuc' land!");
                System.exit(0);
        }
    }

    public static void displayMainMenu() {
        int possibleChoices = displayMenu();
        parseUserMenuChoice(possibleChoices);
    }
}
