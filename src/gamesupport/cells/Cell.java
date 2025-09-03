package gamesupport.cells;

import character.Character;

abstract public class Cell {
    protected boolean isEmpty;

     public Cell() {
        this.isEmpty = false;
    }

    public String toString() {
        return "Tu tombes sur : ";
    }

    public abstract void interact(Character character);
}
