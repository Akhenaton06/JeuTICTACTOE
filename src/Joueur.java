import java.util.*;

public class Joueur {

    private final String name;
    private final char symbol;
    private final List<Integer> moves;

    public Joueur(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.moves = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public List<Integer> getMoves() {
        return moves;
    }

    public void addMove(int move){
       this.moves.add(move);
    }


}
