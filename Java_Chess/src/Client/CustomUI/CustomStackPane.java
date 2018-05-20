package Client.CustomUI;

import Control.Game;
import Data.Board;
import Data.Pieces.*;
import Data.Space;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Optional;



public class CustomStackPane extends StackPane{

    /**
     * Dialog for converting a pawn at the end of the board.
     * @param player player that is at end of board.
     * @return new Piece object of the desired type.
     */
    private Piece handleEndOfBoardPawn(int player){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select piece to replace");
        alert.setHeaderText("Select piece to replace pawn");
        ButtonType rook = new ButtonType("Rook");
        ButtonType queen = new ButtonType("Queen");
        ButtonType bishop = new ButtonType("Bishop");
        ButtonType knight = new ButtonType("Knight");
        alert.getButtonTypes().setAll(rook, queen, bishop, knight);

        Optional<ButtonType> results = alert.showAndWait();
        if (results.get() == rook){
            return new Rook(player);
        }else if(results.get() == knight){
            return new Knight(player);
        }else if(results.get() == bishop){
            return new Bishop(player);
        }else{//Otherwise queen.
            return new Queen(player);
        }


    }

    /**
     * This is the constructor for the custom stack panes I made.
     * They handle the majority of the logic for drag and drop here.  Due to handling
     * that drag and drop they also handle most of move stuff as well.
     * @param board board to which to update.
     * @param x xLocation of pane on board
     * @param y yLocation of pane on board
     */
    public CustomStackPane(Board board, int x, int y, Stage stage, BorderPane bp){
        StackPane s = this;
        s.addEventHandler(DragEvent.DRAG_OVER, (DragEvent event) ->{
            if (event.getGestureSource() != s && event.getDragboard().hasImage()){
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        //Lambda ftw
        s.addEventHandler(DragEvent.DRAG_DROPPED, (DragEvent event) ->{
            Dragboard db = event.getDragboard();
            PieceImage p = (PieceImage) event.getGestureSource();
            boolean success = false;

            //What a nasty one liner...  Next time mvc might be a good choice...
            boolean validMove = board.getBoard().get(p.getSpace()).getPossibleMoves(board, p.getSpace()).contains(new Space(x, y));


            if (db.hasImage() && p.getStackPane() != event.getGestureTarget() && validMove){
                //Update board on condition it has image already
                try{
                    //Handles removal of enemy piece if exists.
                    s.getChildren().remove(1);

                }catch (IndexOutOfBoundsException e){ //Update board if not have image already.

                }finally {
                    ImageView v = new PieceImage(db.getImage(), s, new Space(x, y));
                    s.getChildren().add(v);
                    Piece piece = board.getBoard().get(p.getSpace());
                    //Updates the board
                    board.getBoard().put(p.getSpace(), new Empty());
                    board.getBoard().put(new Space(x, y), piece);
                    v.setOnDragDetected(new DragImage(v, piece));

                    //Handles upgrade condition
                    if (piece.isUpgradeable(new Space(x, y))){
                        Piece pU = handleEndOfBoardPawn(piece.getPlayer());
                        s.getChildren().remove(1);
                        ImageView v2 = new PieceImage(pU.getImage(), s, new Space(x,y));
                        s.getChildren().add(v2);
                        board.getBoard().put(new Space(x, y), pU);
                        v2.setOnDragDetected(new DragImage(v2, pU));
                    }

                }
                p.getStackPane().getChildren().remove(1);

                success = true;
                //Tells game to change player
                Game.changePlayer();
                bp.setRight(new Label("Player "+String.valueOf(Game.PLAYER)+"'s turn"));
                int won = Game.playerWon(board);

                if (won != Game.INVALID_PLAYER){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Game Over");
                    alert.setHeaderText("Player "+String.valueOf(won)+" has won");
                    alert.showAndWait();
                    stage.close();
                }
            }
            event.setDropCompleted(success);
            event.consume();
            System.out.println(board);
        });
    }
}
