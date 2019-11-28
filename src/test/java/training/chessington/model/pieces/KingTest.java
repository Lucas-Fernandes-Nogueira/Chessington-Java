package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {
    @Test
    public void kingCanMoveStraightUp() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0))); //Up
    }

    @Test
    public void kingCanMoveStraightDown() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(1, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0))); //Down
    }

    @Test
    public void kingCanMoveStraightLeft() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1))); //Left
    }

    @Test
    public void kingCanMoveStraightRight() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1))); //Right
    }

    @Test
    public void kingCanMoveNE() {
        // Arrange
        Board board = Board.empty();
        Piece king = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
    }

    @Test
    public void kingCanMoveSE() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
    }

    @Test
    public void kingCanMoveSW() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
    }

    @Test
    public void kingCanMoveNW() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
    }

    @Test
    public void kingCannotMoveTwoSquares() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -2)));
    }

    @Test
    public void kingCannotMoveOntoAllies() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates coordsAlly = new Coordinates(6, 5);
        board.placePiece(coordsAlly, pawn);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coordsAlly));
    }
}
