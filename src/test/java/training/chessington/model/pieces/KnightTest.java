package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {
    @Test
    public void knightCanMove() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -1)));
    }

    @Test
    public void knightCannotMoveOntoAllies() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, knight);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates coordsAlly = new Coordinates(4, 5);
        board.placePiece(coordsAlly, pawn);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coordsAlly));
    }
    
}
