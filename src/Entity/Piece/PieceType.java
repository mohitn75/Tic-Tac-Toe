package Entity.Piece;

public enum PieceType {
    X("X"),
    O("O"),
    EMPTY("_");

    private final String pieceType;

    PieceType(String pieceType) {
        this.pieceType = pieceType;
    }

    @Override
    public String toString(){
        return this.pieceType;
    }
}
