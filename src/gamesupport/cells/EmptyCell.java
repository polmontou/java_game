package gamesupport.cells;

public class EmptyCell extends Cell {

    public EmptyCell() {
        super();
        this.isEmpty = true;
    }

    @Override
    public String toString() {
        return super.toString() + " rien du tout, c'est aussi vide qu'entre tes deux oreilles! Tu peux continuer tout droit.";
    }
}
