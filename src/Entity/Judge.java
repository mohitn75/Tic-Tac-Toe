package Entity;

import Entity.Board.Board;
import Entity.Piece.Piece;
import Entity.Piece.PieceType;
import Entity.Player.Player;
import Entity.Utils.JudgeOperations;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Judge {

    public Deque<Player> players = new LinkedList<>();
    public Board board;

    public Judge(List<Player> players, Board board){
        if(!players.isEmpty()) {
            this.players.addAll(players);
            players.forEach(player -> {System.out.println(player.getPlayerName());});
        }
        this.board = board;
        JudgeOperations.allowTurns(this.players, board);
    }

}
