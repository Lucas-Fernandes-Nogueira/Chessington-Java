package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class QueenTest {
    @Test
    public void queenCanMoveStraightUp() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0))); //Up
    }

    @Test
    public void queenCanMoveStraightDown() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(1, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(5, 0))); //Down
    }

    @Test
    public void queenCanMoveStraightLeft() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, -4))); //Left
    }

    @Test
    public void queenCanMoveStraightRight() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 3))); //Right
    }

    @Test
    public void queenCanMoveNE() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 2)));
    }

    @Test
    public void queenCanMoveSE() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
    }

    @Test
    public void queenCanMoveSW() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
    }

    @Test
    public void queenCanMoveNW() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-4, -4)));
    }


    @Test
    public void queenCannotMoveOntoAllies() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates coordsAlly = new Coordinates(2, 4);
        board.placePiece(coordsAlly, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coordsAlly));
    }

    @Test
    public void queenCannotMovePastAllies() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates coordsAlly = new Coordinates(2, 4);
        board.placePiece(coordsAlly, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coordsAlly.plus(-1,0)));
    }

}
