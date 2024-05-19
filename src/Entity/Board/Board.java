package Entity.Board;

import Entity.Piece.Piece;
import Entity.Piece.PieceType;
import Entity.Player.Player;


import java.util.ArrayList;

public class Board {

    int size = 3;
    Piece[][] board = new Piece[3][3];

    public Board(){
        for(int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Piece(PieceType.EMPTY);
            }
        }
    }

    public Piece[][] getBoard(){
        return this.board;
    }

    public void addPiece(Piece[][] board, int row, int col, Piece piece, Player player){
        if(isSpotFree(board, row, col)){
            board[row][col] = piece;
            System.out.printf("%s added %s successfully at position (%d, %d) \n", player.getPlayerName(), piece.getPieceType().toString(), row, col);
            displayBoard(board);
        }
    }

    public boolean isSpotFree(Piece[][] board, int row, int col){
        return board[row][col].pieceType != PieceType.O || board[row][col].pieceType != PieceType.X;
    }

    public ArrayList<int[]> getFreeSpots(Piece[][] board){
        ArrayList<int[]> freeSpots = new ArrayList<>();
        for(int i = 0; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j].pieceType != PieceType.O && board[i][j].pieceType != PieceType.X){
                    int[] free = new int[2];
                    free[0] = i;
                    free[1] = j;
                    freeSpots.add(free);
                }
            }
        }
        return freeSpots;
    }

    public void displayBoard(Piece[][] board){
        for (Piece[] pieces : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("| %s |", pieces[j].getPieceType().toString());
            }
            System.out.println();
        }
    }

}
