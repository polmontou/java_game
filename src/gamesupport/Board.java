package gamesupport;

import exceptions.DeadCharacter;
import gamescript.Game;
import gamesupport.cells.*;
import character.Character;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private ArrayList<Cell> cells;
    final String[] typeOfCells = {"empty","enemy","equipment"};

    public Board (int dragon, int goblin, int sorcerer, int club, int sword, int thunder, int fireball, int smallpotion, int bigpotion, int totalCells) {
        cells = new ArrayList<Cell>();
        int freeCells = totalCells - dragon - goblin - sorcerer - club - sword - thunder - fireball - smallpotion - bigpotion;

        for (int i = 0; i < dragon; i++) {
            cells.add(new EnemyCell("dragon"));
        }
        for (int i = 0; i < goblin; i++) {
            cells.add(new EnemyCell("goblin"));
        }
        for (int i = 0; i < sorcerer; i++) {
            cells.add(new EnemyCell("sorcerer"));
        }
        for (int i = 0; i < club; i++) {
            cells.add(new OffensiveEquipmentCell("club"));
        }
        for (int i = 0; i < sword; i++) {
            cells.add(new OffensiveEquipmentCell("sword"));
        }
        for (int i = 0; i < thunder; i++) {
            cells.add(new OffensiveEquipmentCell("thunder"));
        }
        for (int i = 0; i < fireball; i++) {
            cells.add(new OffensiveEquipmentCell("fireball"));
        }
        for (int i = 0; i < club; i++) {
            cells.add(new OffensiveEquipmentCell("club"));
        }
        for (int i = 0; i < smallpotion; i++) {
            cells.add(new DefensiveEquipmentCell("smallpotion"));
        }
        for (int i = 0; i < bigpotion; i++) {
            cells.add(new DefensiveEquipmentCell("bigpotion"));
        }
        for (int i = 0; i < freeCells; i++) {
            cells.add(new EmptyCell());
        }
        Collections.shuffle(cells);
    }


    public void interactWithCell(int playerPosition, Character character, Game game) throws DeadCharacter {
        Cell cell = cells.get(playerPosition-1);
        cell.interact(character, game);
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
