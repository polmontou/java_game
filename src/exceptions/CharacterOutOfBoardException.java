package exceptions;

public class CharacterOutOfBoardException extends Exception {
    private String detailMessage = "T'es plus sur le barbeuc', tu grilles DANS les braises là!";
    public CharacterOutOfBoardException () {

    }
}
