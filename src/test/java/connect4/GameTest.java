package connect4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connect4.models.Game;
import connect4.models.Tile;
import connect4.models.Game.Column;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        this.game = new Game();
    }

    @Test
    public void testFileHandling() {
        this.game.makeMove(Column.D);
    }

    @Test
    public void testIsValidMove() {
        assertTrue(this.game.isValidMove(Column.A));
        assertTrue(this.game.isValidMove(Column.B));
        assertTrue(this.game.isValidMove(Column.C));
        assertTrue(this.game.isValidMove(Column.D));
        assertTrue(this.game.isValidMove(Column.E));
        assertTrue(this.game.isValidMove(Column.F));
        assertTrue(this.game.isValidMove(Column.G));
    }

    @Test
    public void testGetCurrentPlayer() {
        assertEquals(Tile.Player, this.game.getCurrentPlayer());
    }
}