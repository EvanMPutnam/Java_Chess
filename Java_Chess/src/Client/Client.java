package Client;

import Client.CustomUI.CustomStackPane;
import Client.CustomUI.DragImage;
import Client.CustomUI.PieceImage;
import Control.Game;
import Data.Board;
import Data.Space;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//find . -name '*.java' -print0 | xargs -0 wc -l


/**
 * Main class that runs the Chess application
 */
public class Client extends Application{

    private static final int SQUARE_DIM = 60;
    private static final int WINDOW_DIM = 600;


    /**
     * Start function that initializes everything.
     * @param primaryStage main stage
     */
    @Override
    public void start(Stage primaryStage){

        Board board = new Board();

        GridPane gridPane = new GridPane();
        BorderPane bp = new BorderPane();

        Scene scene = new Scene(bp, WINDOW_DIM, WINDOW_DIM);


        Label labelPlayerTurn = new Label("Player "+String.valueOf(Game.PLAYER)+"'s turn");
        Label label = new Label("Welcome to Chess \n" +
                "Click and drag pieces to move them.");


        primaryStage.setTitle("Chess");
        int o = 0;//Used to help make checkerboard colors.
        for (int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){


                StackPane s = new CustomStackPane(board, x, y, primaryStage, bp);


                //Add rectangle graphics
                Rectangle r = new Rectangle();
                r.setHeight(SQUARE_DIM);
                r.setWidth(SQUARE_DIM);
                if (o % 2 == 1){
                    r.setFill(Color.GREY);
                }else{
                    r.setFill(Color.WHITE);
                }
                s.getChildren().add(r);


                if (board.getPiece(x, y).getImage() != null){
                    ImageView iv = new PieceImage(board.getPiece(x,y).getImage(), s, new Space(x, y));
                    iv.setOnDragDetected(new DragImage(iv, board.getPiece(x, y)));
                    s.getChildren().add(iv);
                }

                gridPane.add(s, x, y);
                o += 1;
            }
            o += 1;
        }

        bp.setCenter(gridPane);
        bp.setStyle("-fx-background-color: tan");


        bp.setBottom(label);
        bp.setRight(labelPlayerTurn);

        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
