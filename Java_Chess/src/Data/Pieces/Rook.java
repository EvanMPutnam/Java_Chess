package Data.Pieces;

import Data.Board;
import Data.Space;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(int player){
        super(player, null);
        if (player == 1){
            super.image = new Image("file:Images/lightRook.png");
        }else{
            super.image = new Image("file:Images/darkRook.png");
        }
    }

    public ArrayList<Space> getPossibleMoves(Board b, Space s){
        ArrayList<Space> moves = new ArrayList<>();

        //Right
        for (int i = s.getX(); i < 8; i++){
            if (i == s.getX()){
                continue;
            }
            if (b.getBoard().get(new Space(i, s.getY())).getPlayer() == getPlayer()){
                break;
            }
            if (b.getBoard().get(new Space(i, s.getY())).getPlayer() != -1){
                moves.add(new Space(i, s.getY()));
                break;
            }
            moves.add(new Space(i, s.getY()));

        }
        //Left
        for (int i = s.getX(); i >= 0; i--){
            if (i == s.getX()){
                continue;
            }
            if (b.getBoard().get(new Space(i, s.getY())).getPlayer() == getPlayer()){
                break;
            }
            if (b.getBoard().get(new Space(i, s.getY())).getPlayer() != -1){
                moves.add(new Space(i, s.getY()));
                break;
            }
            moves.add(new Space(i, s.getY()));
        }

        //Up
        for (int i = s.getY(); i >= 0; i--){
            if (i == s.getY()){
                continue;
            }
            if (b.getBoard().get(new Space(s.getX(), i)).getPlayer() == getPlayer()){
                break;
            }
            if (b.getBoard().get(new Space(s.getX(), i)).getPlayer() != -1){
                moves.add(new Space(s.getX(), i));
                break;
            }
            moves.add(new Space(s.getX(), i));
        }

        //Down
        for (int i = s.getY(); i < 8; i++){
            if (i == s.getY()){
                continue;
            }
            if (b.getBoard().get(new Space(s.getX(), i)).getPlayer() == getPlayer()){
                break;
            }
            if (b.getBoard().get(new Space(s.getX(), i)).getPlayer() != -1){
                moves.add(new Space(s.getX(), i));
                break;
            }
            moves.add(new Space(s.getX(), i));
        }

        return moves;
    }



    @Override
    public String toString() {
        return "R";
    }
}
