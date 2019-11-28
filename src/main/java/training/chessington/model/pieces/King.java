package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> allowedMoves = new ArrayList<Move>();
        for(Direction direction : Direction.values()) addMovesInDirection(from, board, direction, allowedMoves);
        for(Diagonal diagonal : Diagonal.values()) addMovesInDiagonal(from, board, diagonal, allowedMoves);
        return allowedMoves;
    }

    public List<Move> addMovesInDiagonal(Coordinates from, Board board, Diagonal diagonal, ArrayList<Move> allowedMoves){
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
        if(! from.plus(vector[0],vector[1]).isInBounds()) return allowedMoves;
        nextSquare = board.get(from.plus(vector[0],vector[1]));
        if (nextSquare==null||nextSquare.getColour() != getColour()){
            allowedMoves.add(new Move(from, from.plus(vector[0],vector[1])));
        }
        return allowedMoves;
    }

    public List<Move> addMovesInDirection(Coordinates from, Board board, Direction direction, ArrayList<Move> allowedMoves){
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
        if(! from.plus(vector[0],vector[1]).isInBounds()) return allowedMoves;
        nextSquare = board.get(from.plus(vector[0],vector[1]));
        if (nextSquare==null||nextSquare.getColour() != getColour()){
            allowedMoves.add(new Move(from, from.plus(vector[0],vector[1])));
        }
        return allowedMoves;
    }

}
