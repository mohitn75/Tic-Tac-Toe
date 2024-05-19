package Entity.Player;

import Entity.Piece.Piece;
import Entity.Piece.PieceType;

public class Player{

    public String playerName;
    public Piece piece;

    public Player(String name, PieceType pieceType){
        this.piece = new Piece(pieceType);
        this.playerName = name;
    }

    public String getPlayerName(){
        return this.playerName;
    }
    public Piece getPlayerPiece(){
        return this.piece;
    }

}
