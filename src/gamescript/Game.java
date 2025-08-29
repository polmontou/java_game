package gamescript;

import character.Character;
import exceptions.CharacterOutOfBoardException;
import gamescript.Menu;
import gamesupport.Board;
import gamesupport.Dice;

public class Game {
    Dice dice =  new Dice(1);
    Board board = new Board(4);
    int playerPosition = 0;

    public Game(Character character) {
        play(character);
    }

    /**
     * Runs the menu and parse user's choice during the game
     * @param character is the character used for the current game
     *
     */
    private void play(Character character) {
        boolean playerIsOnCase64 = false;

        Menu.displayMessage("Bon chance en enfer!"+
                "\nTu es sur la case " + playerPosition);

        while (!playerIsOnCase64) {
            try {
                Menu.displayMessage(
                        "\nQue veux-tu faire?" +
                                "\n1 - Lancer le dé" +
                                "\n2 - Quitter la partie");
                int choice = Menu.getUserPosInt(2);
                int result = parseUserTurnChoice(choice);
                if (result == -1) {
                    break;
                } else {
                    playerPosition += result;
                    playerIsOnCase64 = parseCharacterPosition(playerPosition);

                    Menu.displayMessage("Tu es donc en case " + playerPosition);
                    String currentCellContent = board.getCellsContent(playerPosition);
                    Menu.displayMessage(currentCellContent);
                }

            } catch (CharacterOutOfBoardException e) {
               e.getMessage();
               character.setBoardPosition(0);
               Menu.displayMessage("Retour case 0! EHEHEHE");

            }

        }
            character.setBoardPosition(0);
            Menu.displayMessage("Félicitations, tu es assez grillé pour être mangé!!");
    }

    private boolean parseCharacterPosition(int characterPosition) throws CharacterOutOfBoardException {
        if (characterPosition == 64) {
            return true;
        } else if (characterPosition > 64) {
            throw new CharacterOutOfBoardException();
        } else {
            return false;
        }
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
