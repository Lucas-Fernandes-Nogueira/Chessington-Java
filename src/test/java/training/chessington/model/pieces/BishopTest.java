package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {
    @Test
    public void bishopCanMoveNE() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 2)));
    }

    @Test
    public void bishopCanMoveSE() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
    }

    @Test
    public void bishopCanMoveSW() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
    }

    @Test
    public void bishopCanMoveNW() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void bishopCannotMoveOntoAllies() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates coordsAlly = new Coordinates(4, 2);
        board.placePiece(coordsAlly, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coordsAlly));
    }

    @Test
    public void rookCannotMovePastAllies() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates coordsAlly = new Coordinates(4, 2);
        board.placePiece(coordsAlly, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coordsAlly.plus(-1,-1)));
    }
}
