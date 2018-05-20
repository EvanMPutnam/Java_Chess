package Data.Pieces;

import Data.Board;
import Data.Space;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class King extends Piece {

    public King(int player){
        super(player, null);
        if (player == 1){
            super.image = new Image("file:Images/lightKing.png");
        }else{
            super.image = new Image("file:Images/darkKing.png");
        }
    }


    /**
     * Check to see if move is good to go.
     * @param moves
     * @param b
     * @param lrud
     */
    private void helpMoves(ArrayList<Space> moves, Board b, Space lrud){
        if (b.getBoard().containsKey(lrud) && b.getBoard().get(lrud).getPlayer() != getPlayer()){
            moves.add(lrud);
        }
    }

    public ArrayList<Space> getPossibleMoves(Board b, Space s){
        ArrayList<Space> spaces = new ArrayList<>();

        ArrayList<Space> spacesToTest = new ArrayList<>();

        spacesToTest.add(new Space(s.getX()-1, s.getY()));
        spacesToTest.add(new Space(s.getX()+1, s.getY()));
        spacesToTest.add(new Space(s.getX(), s.getY()-1));
        spacesToTest.add(new Space(s.getX(), s.getY()+1));
        spacesToTest.add(new Space(s.getX()+1, s.getY()+1));
        spacesToTest.add(new Space(s.getX()+1, s.getY()-1));
        spacesToTest.add(new Space(s.getX()-1, s.getY()-1));
        spacesToTest.add(new Space(s.getX()-1, s.getY()+1));

        for (Space sp:spacesToTest) {
            helpMoves(spaces, b, sp);
        }

        return spaces;

    }


    @Override
    public String toString() {
        return "K";
    }

}
