package Control;

import Data.Board;
import Data.Pieces.Piece;


/**
 * Collection of static functions and properties to help with
 * turn changing and player win conditions.
 */
public class Game {

    //Keeps track of the current player turn.
    public static int PLAYER = 1;

    //Player attributes
    public static int PLAYER_ONE = 1;
    public static int PLAYER_TWO = 2;
    public static int INVALID_PLAYER = -1;

    //Function
    public static void changePlayer(){
        if (PLAYER == PLAYER_ONE){
            PLAYER = PLAYER_TWO;
        }else{
            PLAYER = PLAYER_ONE;
        }
    }

    /**
     * Checks if the player won or not.
     * @param board board object in which to check for single kings.
     * @return ints for player who won.  -1 is nobody won.
     */
    public static int playerWon(Board board){
        int kingsFound = 0;
        Piece lastFoundKing = null;
        for (Piece p: board.getBoard().values()) {
            if (p.toString().equals("K")) {
                kingsFound += 1;
                lastFoundKing = p;
            }
        }
        if (kingsFound == 1){
            if (lastFoundKing.getPlayer() == PLAYER_ONE){
                return PLAYER_ONE;
            }else{
                return PLAYER_TWO;
            }
        }
        return INVALID_PLAYER;
    }







}
