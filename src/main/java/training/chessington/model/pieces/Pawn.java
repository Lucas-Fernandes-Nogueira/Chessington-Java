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
        int multiplier = (getColour()==PlayerColour.WHITE)?-1:1;
        ArrayList<Move> allowedMoves = new ArrayList<Move>();
        if(from.getRow()==0||from.getRow()==7) return allowedMoves;
        //pawn moving forwards 1 square
        if(!isTherePieceInFront(from, board, 1)){
            allowedMoves.add(new Move(from, new Coordinates(from.getRow()+multiplier, from.getCol())));
            //pawn moving forwards 2 squares
            if(!isTherePieceInFront(from, board, 2) && isOnStartRow(from)){
                allowedMoves.add(new Move(from, new Coordinates(from.getRow()+multiplier*2, from.getCol())));
            }
        }
        if(canCaptureLeft(from, board)){
            allowedMoves.add(new Move(from, new Coordinates(from.getRow() + multiplier, from.getCol() + multiplier)));
        }
        if(canCaptureRight(from, board)){
            allowedMoves.add(new Move(from, new Coordinates(from.getRow() + multiplier, from.getCol() - multiplier)));
        }
        return allowedMoves;
    }

    private boolean isTherePieceInFront(Coordinates from, Board board, int num){
        int multiplier = (getColour()==PlayerColour.WHITE)?-1:1;
        return (board.get(new Coordinates(from.getRow() + multiplier*num, from.getCol())) != null);
    }

    private boolean isOnStartRow(Coordinates from){
        return ((getColour() == PlayerColour.WHITE && from.getRow() == 6) ||
                (getColour() == PlayerColour.BLACK && from.getRow() == 1));
    }

    private boolean canCaptureRight(Coordinates from, Board board){
        int multiplier = (getColour()==PlayerColour.WHITE)?-1:1;
        Coordinates captureCoords = new Coordinates(from.getRow() + multiplier, from.getCol() - multiplier);
        if(!captureCoords.isInBounds()) return false;
        Piece diagPiece = board.get(captureCoords);
        if( diagPiece != null){
            return (diagPiece.getColour() != getColour());
        }
        return false;
    }

    private boolean canCaptureLeft(Coordinates from, Board board){
        int multiplier = (getColour()==PlayerColour.WHITE)?-1:1;
        Coordinates captureCoords = new Coordinates(from.getRow() + multiplier, from.getCol() + multiplier);
        if(!captureCoords.isInBounds()) return false;
        Piece diagPiece = board.get(captureCoords);
        if( diagPiece != null){
            return (diagPiece.getColour() != getColour());
        }
        return false;
    }

}
