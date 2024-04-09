package connect4.models;

import java.io.File;

import connect4.models.Game.Column;

public interface VectorGame {
  boolean[] getValidMoves();

  boolean isValidMove(Column column);

  void makeMove(Column column) throws IllegalStateException;

  boolean isGameOver();

  Tile getWinner() throws IllegalStateException;

  void loadGameFile(File file) throws IllegalArgumentException;

  File saveGameFile();
}
