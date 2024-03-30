package tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class Controller {
  @FXML
  private FlowPane board;
  @FXML
  private Text output;
  @FXML
  private TextField input;

  @FXML
  private void initialize() {
    Button[] tiles = new Button[BoardState.BOARD_SIZE];
    for (int i = 0; i < tiles.length; i++) {
      Button tile = new Button();
      tiles[i] = tile;

      tile.setText("[   ]");
      tile.setPrefSize(
          board.getPrefWidth() / BoardState.SIDE_SIZE,
          board.getPrefWidth() / BoardState.SIDE_SIZE);

      tile.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          fireClick(tile);
          tile.setOnAction(null);
        }
      });
    }
    this.board.getChildren().setAll(tiles);
  }

  void fireClick(Button tile) {
    tile.setText("null");
  }

  @FXML
  void handleSubmit(ActionEvent event) {
    this.output.setText(input.getText());
  }

  @FXML
  void handleTilePress(ActionEvent event) {
    EventTarget target = event.getTarget();
    this.output.setText(target.toString());
  }
}
