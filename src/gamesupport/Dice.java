package gamesupport;

public class Dice {
    private int faces;

    public Dice(int faces) {
        this.faces = faces;
    }

    public int roll(){
        return (int)(Math.random() * faces)+1;
    }
}
