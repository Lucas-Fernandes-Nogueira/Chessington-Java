package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece {
    public Queen(PlayerColour colour) {
        super(PieceType.QUEEN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<Move>();
        Rook rook = new Rook(getColour());
        allowedMoves = rook.getAllowedMoves(from, board);
        Bishop bishop = new Bishop(getColour());
        allowedMoves.addAll(bishop.getAllowedMoves(from, board));
        return allowedMoves;
    }
}
