package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        int multiplier = (this.getColour()==PlayerColour.WHITE)?-1:1;
        ArrayList<Move> allowedMoves = new ArrayList<Move>();
        //pawn moving forwards 1 square
        allowedMoves.add(new Move(from, new Coordinates(from.getRow()+multiplier, from.getCol())));
        return allowedMoves;
    }
}
