package gamesupport;

import java.util.ArrayList;

public class Board {
    private ArrayList<Cell> cells;

    public Board (int cellNumber) {
        cells = new ArrayList<Cell>();
        String content = "empty";
        for (int i = 1; i <= cellNumber; i++) {
            switch (i) {
                case 1 :
                    content = "empty";
                    break;
                case 2:
                    content = "Potion";
                    break;
                case 3 :
                    content = "Weapon";
                    break;
                case 4 :
                    content = "Enemy";
            }
            Cell cell = new Cell(cellNumber, content);
            cells.add(cell);
        }
    }

    public String getCellsContent(int playerPosition) {
        return this.cells.get(playerPosition-1).toString();
    }
}
