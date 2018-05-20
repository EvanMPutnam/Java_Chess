package Data.Pieces;

import Control.Game;
import Data.Board;
import Data.Space;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(int player){
        super(player, null);
        if (player == Game.PLAYER_ONE){
            super.image = new Image("file:Images/lightPawn.png");
        }else{
            super.image = new Image("file:Images/darkPawn.png");
        }
    }

    /**
     *
     * @param b board of pieces
     * @param s space of Pawn
     * @return
     */
    public ArrayList<Space> getPossibleMoves(Board b, Space s){
        ArrayList<Space> spaces = new ArrayList<>();
        if (b.getBoard().get(s).getPlayer() == Game.PLAYER_ONE){
            Space s2 = new Space(s.getX(), s.getY()-1);
            if (b.getBoard().containsKey(s2) && b.getBoard().get(s2).getPlayer() == -1){
                spaces.add(s2);
            }
            s2 = new Space(s.getX()-1, s.getY()-1);
            if (b.getBoard().containsKey(s2) && b.getBoard().get(s2).getPlayer() == 2){
                spaces.add(s2);
            }

            s2 = new Space(s.getX()+1, s.getY()-1);
            if (b.getBoard().containsKey(s2) && b.getBoard().get(s2).getPlayer() == 2){
                spaces.add(s2);
            }
            //Move two spaces ahead
            s2 = new Space(s.getX(), s.getY()-2);
            if (s.getY() == 6 && b.getBoard().get(s2).getPlayer() != 2){
                spaces.add(s2);
            }

        }else{
            Space s2 = new Space(s.getX(), s.getY()+1);
            if (b.getBoard().containsKey(s2) && b.getBoard().get(s2).getPlayer() == -1){
                spaces.add(s2);
            }
            s2 = new Space(s.getX()-1, s.getY()+1);
            if (b.getBoard().containsKey(s2) && b.getBoard().get(s2).getPlayer() == 1){
                spaces.add(s2);
            }

            s2 = new Space(s.getX()+1, s.getY()+1);
            if (b.getBoard().containsKey(s2) && b.getBoard().get(s2).getPlayer() == 1){
                spaces.add(s2);
            }

            //Move two spaces ahead
            s2 = new Space(s.getX(), s.getY()+2);
            if (s.getY() == 1 && b.getBoard().get(s2).getPlayer() != 1){
                spaces.add(s2);
            }

        }
        return spaces;

    }

    @Override
    public boolean isUpgradeable(Space s){
        if(this.getPlayer() == Game.PLAYER_ONE && s.getY() == 0){
            return true;
        }
        if (this.getPlayer() == Game.PLAYER_TWO && s.getY() == 7){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "P";
    }
}
