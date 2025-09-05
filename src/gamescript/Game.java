package gamescript;

import character.Character;
import exceptions.CharacterOutOfBoardException;
import exceptions.DeadCharacter;
import gamescript.Menu;
import gamesupport.Board;
import gamesupport.Dice;


public class Game {
    private Menu menu;
    private Dice dice6;
    private Board board;
    private int playerPosition;

    public Game(Character character) {
        menu = new Menu();
        dice6 = new Dice(6);
        board = new Board(4,10,10,5,4,5,2,6,2, 64);
        playerPosition = 0;
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
                int choice = menu.getUserPosInt(2);
                int result = parseUserTurnChoice(choice);
                if (result == -1) {
                    break;
                } else {
                    playerPosition += result;
                    playerIsOnCase64 = parseCharacterPosition(playerPosition);

                    Menu.displayMessage("Tu es donc en case " + playerPosition);
                    String currentCellContent = board.getCellsContent(playerPosition);
                    Menu.displayMessage(currentCellContent);
                    board.interactWithCell(playerPosition, character, this);
                    menu.updateCharacter(character);
                }

            } catch (CharacterOutOfBoardException e) {
                Menu.displayMessage(e.getMessage());
                playerPosition = 0;
                Menu.displayMessage("Retour case 0! EHEHEHE");

            } catch (DeadCharacter deadCharacter) {
                Menu.displayMessage(deadCharacter.getMessage());
            }

        }
        if(playerPosition == 64){
            Menu.displayMessage("Félicitations, tu es assez grillé pour être mangé!!");
        }
        playerPosition = 0;

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
                int throwResult = dice6.roll();
                Menu.displayMessage("Tu as fait un " + throwResult);
                return throwResult;
            case 2 :
                return -1;
        }
        return 0;
    }
    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
    public int getPlayerPosition() {
        return playerPosition;
    }
}
