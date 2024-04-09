package connect4.models;

import java.util.Arrays;

public class Game implements VectorGame {
  public enum Column {
    A, B, C, D, E, F, G;
  }

  public static final int COLUMN_COUNT = Column.values().length;
  public static final int COLUMN_SIZE = 6;
  public static final int BOARD_SIZE = COLUMN_COUNT * COLUMN_SIZE;
  private Tile[] board = new Tile[COLUMN_COUNT * COLUMN_SIZE];
  private Tile currentPlayer = Tile.Player;

  public Game() {
    Arrays.fill(this.board, Tile.Empty);
  }

  public Tile getCurrentPlayer() {
    return this.currentPlayer;
  }

  @Override
  public boolean isValidMove(Column column) {
    BoardHelper boardHelper = new BoardHelper(COLUMN_COUNT, COLUMN_SIZE, this.board);
    System.out.println(COLUMN_COUNT);
    Tile[] highestRow = boardHelper.getRow(0);

    return highestRow[column.ordinal()] == Tile.Empty;
  }

  @Override
  public void makeMove(Column column) throws IllegalStateException {
    if (!this.isValidMove(column)) {
      throw new IllegalStateException("Invalid move to column " + column);
    }

    BoardHelper boardHelper = new BoardHelper(COLUMN_COUNT, COLUMN_SIZE, this.board);
    Tile[] selectedColumn = boardHelper.getColumn(column.ordinal());

    for (int row = COLUMN_SIZE - 1; row >= 0; row--) {
      if (selectedColumn[row] == Tile.Empty) {
        this.board[boardHelper.translate(row, column.ordinal())] = this.currentPlayer;
        break;
      }
    }
  }

  @Override
  public Tile getWinner() throws IllegalStateException {
    if (!this.isGameOver()) {
      throw new IllegalStateException("Can't get winner when game isn't over");
    }
    // TODO
    /*
     * if (...) {
     * return Tile.Player;
     * } else if (...) {
     * return Tile.Opponent;
     * } else {
     * return Tile.Empty;
     * }
     */
  }
}
