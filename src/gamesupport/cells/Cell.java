package gamesupport.cells;

abstract public class Cell {
    protected boolean isEmpty;

     public Cell() {
        this.isEmpty = false;
    }

    public String toString() {
        return "Tu tombes sur : ";
    }
}
