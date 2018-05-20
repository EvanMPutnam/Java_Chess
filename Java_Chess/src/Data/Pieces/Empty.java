package Data.Pieces;

import Data.Board;
import Data.Space;

import java.util.ArrayList;

public class Empty extends Piece{

    public Empty(){
        super(-1, null);
    }

    public ArrayList<Space> getPossibleMoves(Board b, Space s){
        return null;
    }

    @Override
    public String toString() {
        return "_";
    }

}
