package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> allowedMoves = new ArrayList<Move>();

        for(Diagonal diagonal : Diagonal.values()) addMovesInDiagonal(from, from, board, diagonal, allowedMoves);
        return allowedMoves;
    }

    public List<Move> addMovesInDiagonal(Coordinates from, Coordinates currentPosition, Board board, Diagonal diagonal, ArrayList<Move> allowedMoves){
        Piece nextSquare = null;
        int[] vector = new int[] {0,0};
        switch (diagonal){
            case NE:
                vector[0] = -1;
                vector[1] = 1;
                break;
            case SE:
                vector[0] = 1;
                vector[1] = 1;
                break;
            case SW:
                vector[0] = 1;
                vector[1] = -1;
                break;
            case NW:
                vector[0] = -1;
                vector[1] = -1;
                break;
        }
        if(! currentPosition.plus(vector[0],vector[1]).isInBounds()) return allowedMoves;
        nextSquare = board.get(currentPosition.plus(vector[0],vector[1]));
        if (nextSquare==null){
            allowedMoves.add(new Move(from, currentPosition.plus(vector[0],vector[1])));
            return addMovesInDiagonal(from, currentPosition.plus(vector[0],vector[1]),board, diagonal,allowedMoves);
        }
        if (nextSquare.getColour() == getColour()) {
            return allowedMoves;
        }
        else {
            allowedMoves.add(new Move(from, currentPosition.plus(vector[0],vector[1])));
            return allowedMoves;
        }
    }
}
