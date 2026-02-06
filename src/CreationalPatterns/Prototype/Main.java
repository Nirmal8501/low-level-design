package CreationalPatterns.Prototype;

import java.util.ArrayList;
import java.util.List;

interface Prototype<T> {
    T copy();
}

class Gamepiece implements Prototype<Gamepiece> {
    private String color;
    private int position;

    public Gamepiece(String color, int position) {
        this.color = color;
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public int getPosition() {
        return position;
    }

    public Gamepiece copy() {
        return new Gamepiece(this.color, this.position);
    }

    @Override
    public String toString() {
        return "Gamepiece{" +
                "color='" + color + '\'' +
                ", position=" + position +
                '}';
    }
}

class Gameboard implements Prototype<Gameboard> {
    private List<Gamepiece> gamepieces = new ArrayList<>();

    public void addPiece(Gamepiece gamepiece){
        gamepieces.add(gamepiece);
    }

    public List<Gamepiece> showAllPieces(){
        return gamepieces;
    }

    public void showBoardState(){
        for(Gamepiece gamepiece: gamepieces){
            System.out.println(gamepiece);
        }
    }

    @Override
    public Gameboard copy() {
        Gameboard newBoard = new Gameboard();
        for (Gamepiece gamepiece: gamepieces){
            newBoard.addPiece(gamepiece.copy());  // This creates deep copy
        }
        return newBoard;
    }
}

public class Main {

    public static void main(String[] args) {
        Gameboard gameboard = new Gameboard();
        gameboard.addPiece(new Gamepiece("Blue", 1));
        gameboard.addPiece(new Gamepiece("Red", 2));

        gameboard.showBoardState();
        System.out.println("\n\n");

        Gameboard copiedBoard = gameboard.copy();
        copiedBoard.showBoardState();

    }

}
