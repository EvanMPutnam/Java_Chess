package Data.Pieces;

import Control.Game;
import Data.Board;
import Data.Space;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(int player){
        super(player, null);
        if (player == 1){
            super.image = new Image("file:Images/lightBishop.png");
        }else{
            super.image = new Image("file:Images/darkBishop.png");
        }
    }


    private void getPossibleHelper(Board b, Space s, ArrayList<Space> moves, int addX, int addY){
        int plusX = addX;
        int plusY = addY;
        while(b.getBoard().containsKey(new Space(s.getX()+plusX, s.getY()+plusY))){
            Piece s2 = b.getBoard().get(new Space(s.getX()+plusX, s.getY()+plusY));
            if (s2.getPlayer() != getPlayer() && s2.getPlayer() != Game.INVALID_PLAYER){
                moves.add(new Space(s.getX()+plusX, s.getY()+plusY));
                break;
            }
            if (s2.getPlayer() == getPlayer()){
                break;
            }

            moves.add(new Space(s.getX()+plusX, s.getY()+plusY));
            plusX += addX;
            plusY += addY;
        }
    }

    public ArrayList<Space> getPossibleMoves(Board b, Space s){

        ArrayList<Space> moves = new ArrayList<>();
        getPossibleHelper(b, s, moves, 1, 1);
        getPossibleHelper(b, s, moves, 1, -1);
        getPossibleHelper(b, s, moves, -1, 1);
        getPossibleHelper(b, s, moves, -1, -1);
        return moves;
    }

    @Override
    public String toString() {
        return "B";
    }

}
