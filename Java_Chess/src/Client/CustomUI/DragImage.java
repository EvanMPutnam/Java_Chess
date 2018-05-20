package Client.CustomUI;


import Control.Game;
import Data.Pieces.Piece;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;


public class DragImage implements EventHandler<MouseEvent> {

        private ImageView iv;
        private Piece piece;

    /**
     * Constructor for the start portion of the drag event in which an image is starting to drag.
     * @param iv imageview for which to get image.
     * @param piece piece associated with imageview.
     */
    public DragImage(ImageView iv, Piece piece){
            this.iv = iv;
            this.piece = piece;
        }


    /**
     * If the piece is the current game player then allow the drag to occur.
     * @param event
     */
    @Override
        public void handle(MouseEvent event) {
            if (this.piece.getPlayer() == Game.PLAYER) {
                Dragboard db = iv.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(iv.getImage());
                db.setContent(content);
            }
            event.consume();
        }


}
