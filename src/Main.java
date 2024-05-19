import Entity.Board.Board;
import Entity.Judge.Judge;
import Entity.Piece.PieceType;
import Entity.Player.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();

        Player player1 = new Player("Player 1", PieceType.O);
        Player player2 = new Player("Player 2", PieceType.X);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        Judge judge = new Judge(players, board);

    }
}