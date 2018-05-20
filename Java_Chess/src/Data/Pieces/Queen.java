package Data.Pieces;

import Data.Board;
import Data.Space;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Queen extends Piece {


    public Queen(int player){
        super(player, null);
        if (player == 1){
            super.image = new Image("file:Images/lightQueen.png");
        }else{
            super.image = new Image("file:Images/darkQueen.png");
        }
    }

    /**
     * Get the possible moves of a queen player.
     * Uses the rook and bishop move calcs from the given position.
     * @param b
     * @param s
     * @return
     */
    public ArrayList<Space> getPossibleMoves(Board b, Space s){
        Piece rook = new Rook(this.getPlayer());
        Piece bishop = new Bishop(this.getPlayer());
        ArrayList<Space> rookMoves = rook.getPossibleMoves(b, s);
        ArrayList<Space> bishopMoves = bishop.getPossibleMoves(b, s);
        rookMoves.addAll(bishopMoves);
        return rookMoves;

    }


    @Override
    public String toString() {
        return "Q";
    }
}
