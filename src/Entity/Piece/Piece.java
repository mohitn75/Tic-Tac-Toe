package Entity.Piece;


public class Piece {

    public PieceType pieceType;

    public Piece(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
