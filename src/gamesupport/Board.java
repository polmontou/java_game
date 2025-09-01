package gamesupport;

import gamesupport.cells.*;

import java.util.ArrayList;

public class Board {
    private ArrayList<Cell> cells;
    final String[] typeOfCells = {"empty","enemy","equipment"};

    public Board (int cellNumber) {
        cells = new ArrayList<Cell>();
        String content = "empty";
        for (int i = 0; i < cellNumber; i++) {
            Cell cell = generateRandomCell();
            cells.add(cell);
        }
    }

    public String getCellsContent(int playerPosition) {
        return this.cells.get(playerPosition-1).toString();
    }
     private Cell generateRandomCell() {
        Cell newCell = null;
        int i = (int) (Math.random() * typeOfCells.length);
        switch (i) {
            case 0 :
                newCell = new EmptyCell();
                break;
            case 1 :
                newCell = new EnemyCell();
                break;
            case 2 :
                newCell = chooseRandomEquipmentCell();
                break;
        }
        return newCell;
     }

     private Cell chooseRandomEquipmentCell() {
        Cell newCell = null;

        int i = (int) (Math.random() * 2);
        switch (i) {
            case 0 :
                newCell = new OffensiveEquipmentCell();
                break;
            case 1 :
                newCell = new DefensiveEquipmentCell();
                break;
        }
        return newCell;
     }
}
