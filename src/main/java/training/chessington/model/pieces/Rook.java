package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> allowedMoves = new ArrayList<Move>();

       for(Direction direction : Direction.values()) addMovesInDirection(from, from, board, direction, allowedMoves);
       return allowedMoves;
    }

    public List<Move> addMovesInDirection(Coordinates from, Coordinates currentPosition, Board board, Direction direction, ArrayList<Move> allowedMoves){
        Piece nextSquare = null;
        int[] vector = new int[] {0,0};
        switch (direction){
            case UP:
                vector[0] = -1;
                break;
            case DOWN:
                vector[0] = 1;
                break;
            case LEFT:
                vector[1] = -1;
                break;
            case RIGHT:
                vector[1] = 1;
                break;
        }
        if(! currentPosition.plus(vector[0],vector[1]).isInBounds()) return allowedMoves;
        nextSquare = board.get(currentPosition.plus(vector[0],vector[1]));
        if (nextSquare==null){
            allowedMoves.add(new Move(from, currentPosition.plus(vector[0],vector[1])));
            return addMovesInDirection(from, currentPosition.plus(vector[0],vector[1]),board, direction,allowedMoves);
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
