package Data.Pieces;

import Data.Board;
import Data.Space;
import javafx.scene.image.Image;

import java.util.ArrayList;


public abstract class Piece{

    private int player;
    protected Image image;

    public Piece(int player, Image image){
        this.player = player;
        this.image = image;
    }

    public abstract ArrayList<Space> getPossibleMoves(Board b, Space s);

    public boolean isUpgradeable(Space s){
        return false;
    }

    public int getPlayer(){
        return this.player;
    }

    public Image getImage(){
        return this.image;
    }






}
