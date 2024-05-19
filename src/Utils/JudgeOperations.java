package Utils;

import Entity.Board.Board;
import Entity.Piece.Piece;
import Entity.Piece.PieceType;
import Entity.Player.Player;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class JudgeOperations {
    static boolean winner = false;

    public static void allowTurns(Deque<Player> players, Board board){
        while(!winner){
            Player current = players.poll();
            players.add(current);
            assert current != null;
            System.out.printf("Hi! Player %s, enter row and column \n", current.getPlayerName());
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            while(!checkIfValidSpot(row, col, board)){
                System.out.printf("Hi! Player %s, enter row and column again \n", current.getPlayerName());
                row = scanner.nextInt();
                col = scanner.nextInt();
            }
            board.addPiece(board.getBoard(), row, col, current.getPlayerPiece(), current);
            winner = checkIfWinner(board.getBoard());
            if(winner){
                System.out.printf("Game Over !! Winner is %s", current.getPlayerName());
            }
        }
    }

    public static boolean checkIfValidSpot(int row, int col, Board board){
        ArrayList<int[]> freeSpots = board.getFreeSpots(board.getBoard());
        AtomicBoolean allowed = new AtomicBoolean(false);
        freeSpots.forEach(spot -> {
            if(spot[0] == row && spot[1] == col){
                allowed.set(true);
            }
        });
        return allowed.get();
    }

    public static boolean checkIfWinner(Piece[][] board){
        for (Piece[] pieces : board) {
            if (pieces[0] == pieces[1] && pieces[0] == pieces[2] && pieces[0].getPieceType() != PieceType.EMPTY) {
                return true;
            }
        }
        for(int i = 0 ; i < board[0].length ; i++){
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i].getPieceType() != PieceType.EMPTY){
                return true;
            }
        }
        if(board[0][0] == board[1][1] && board[0][0] == board [2][2] && board[0][0].getPieceType() != PieceType.EMPTY){
            return true;
        }
        return board[0][2] == board[1][1] && board[0][0] == board[0][2] && board[2][0].getPieceType() != PieceType.EMPTY;
    }
}
