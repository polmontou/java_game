package gamesupport.cells;

import character.Character;
import exceptions.DeadCharacter;
import gamescript.Game;

abstract public class Cell {
    protected boolean isEmpty;

     public Cell() {
        this.isEmpty = false;
    }

    public String toString() {
        return "Tu tombes sur : ";
    }

    public abstract void interact(Character character, Game game) throws DeadCharacter;
}
