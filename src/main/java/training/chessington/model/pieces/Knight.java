package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board){
        List<Move> allowedMoves = new ArrayList<Move>();
        int[][] vectors = {{-2,1}, {-1,2}, {1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        for(int[] vector : vectors){
            Coordinates target = from.plus(vector[0],vector[1]);
            if(target.isInBounds()){
                if(board.get(target) == null || board.get(target).getColour() != getColour()){
                    allowedMoves.add(new Move(from, target));
                }
            }
        }
        return allowedMoves;
    }
}
