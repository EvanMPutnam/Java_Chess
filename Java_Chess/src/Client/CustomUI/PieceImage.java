package Client.CustomUI;

import Data.Space;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class PieceImage extends ImageView{


    private StackPane stackPane;
    private Space space;

    /**
     * Constructor for the imageview that has the pieces in it.
     * @param image image to set
     * @param stackPane stack-pane its associated with
     * @param space the space coordinate location.
     */
    public PieceImage(Image image, StackPane stackPane, Space space){
        super();
        super.setImage(image);
        this.stackPane = stackPane;
        this.space = space;
    }

    /**
     * @return the associated stack pane
     */
    public StackPane getStackPane() {
        return stackPane;
    }

    /**
     * @return the associated space
     */
    public Space getSpace() {
        return space;
    }
}
