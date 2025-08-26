package gamescript;

import character.Character;
import gamescript.Menu;
import gamesupport.Board;
import gamesupport.Dice;

public class Game {
    Dice dice =  new Dice(6);
    Board board = new Board();

    public Game(Character character) {
        play(character);
    }

    /**
     * Runs the menu and parse user's choice during the game
     * @param character is the character used for the current game
     */
    private void play(Character character) {
        Menu.displayMessage("Bon chance en enfer!"+
                "\nTu es sur la case " + character.getBoardPosition());
        while (character.getBoardPosition() < 64) {
            Menu.displayMessage(
                    "\nQue veux-tu faire?" +
                    "\n1 - Lancer le dé" +
                    "\n2 - Quitter la partie");
            int choice = Menu.getUserPosInt(2);
            int result = parseUserTurnChoice(choice);
            if (result == -1) {
                break;
            } else {
                character.moveCharacter(result);
                Menu.displayMessage("Tu es donc en case "+character.getBoardPosition());
            }
        }
        character.setBoardPosition(0);
        Menu.displayMessage("Félicitations, tu es assez grillé pour être mangé!!");
    }

    /**
     * Parses user choice during play
     * @param choice is choice made by user while he's playing
     * @return -1 if the player want to exit game
     */
    private int parseUserTurnChoice(int choice) {
        switch (choice) {
            case 1 :
                int throwResult = dice.roll();
                Menu.displayMessage("Tu as fait un " + throwResult);
                return throwResult;
            case 2 :
                return -1;
        }
        return 0;
    }

}
