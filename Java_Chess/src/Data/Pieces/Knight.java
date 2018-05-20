package Data.Pieces;

import Data.Board;
import Data.Space;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(int player){
        super(player, null);
        if (player == 1){
            super.image = new Image("file:Images/lightKnight.png");
        }else{
            super.image = new Image("file:Images/darkKnight.png");
        }
    }

    private void getPossibleMovesHelper(Board b, Space s, ArrayList<Space> moves, int xAdd, int yAdd){
        Space sN = new Space(s.getX()+xAdd, s.getY()+yAdd);
        if (b.getBoard().containsKey(sN)){
            Piece p = b.getBoard().get(sN);
            if (p.getPlayer() != getPlayer()){
                moves.add(sN);
            }
        }
    }
    public ArrayList<Space> getPossibleMoves(Board b, Space s){
        ArrayList<Space> moves = new ArrayList<>();

        //Up moves
        getPossibleMovesHelper(b, s, moves, -1, -2);
        getPossibleMovesHelper(b, s, moves, 1, -2);
        getPossibleMovesHelper(b, s, moves, -2, -1);
        getPossibleMovesHelper(b, s, moves, 2, -1);
        //Down moves
        getPossibleMovesHelper(b, s, moves, 1, 2);
        getPossibleMovesHelper(b, s, moves, -1, 2);
        getPossibleMovesHelper(b, s, moves, -2, 1);
        getPossibleMovesHelper(b, s, moves, 2, 1);

        return moves;
    }

    @Override
    public String toString() {
        return "k";
    }
}
