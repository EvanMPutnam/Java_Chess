package Data;

import Control.Game;
import Data.Pieces.*;

import java.util.HashMap;


public class Board {

    HashMap<Space, Piece> board = new HashMap<Space, Piece>();

    public Board(){
        for (int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                board.put(new Space(x,y), new Empty());
            }
        }

        board.put(new Space(0, 0), new Rook(Game.PLAYER_TWO));
        board.put(new Space(7, 0), new Rook(Game.PLAYER_TWO));
        board.put(new Space(6, 0), new Knight(Game.PLAYER_TWO));
        board.put(new Space(1, 0), new Knight(Game.PLAYER_TWO));
        board.put(new Space(5, 0), new Bishop(Game.PLAYER_TWO));
        board.put(new Space(2, 0), new Bishop(Game.PLAYER_TWO));
        board.put(new Space(3, 0), new Queen(Game.PLAYER_TWO));
        board.put(new Space(4, 0), new King(Game.PLAYER_TWO));
        for(int i = 0; i < 8; i++){
            board.put(new Space(i, 1), new Pawn(Game.PLAYER_TWO));
        }


        board.put(new Space(0, 7), new Rook(Game.PLAYER_ONE));
        board.put(new Space(7, 7), new Rook(Game.PLAYER_ONE));
        board.put(new Space(6, 7), new Knight(Game.PLAYER_ONE));
        board.put(new Space(1, 7), new Knight(Game.PLAYER_ONE));
        board.put(new Space(5, 7), new Bishop(Game.PLAYER_ONE));
        board.put(new Space(2, 7), new Bishop(Game.PLAYER_ONE));
        board.put(new Space(3, 7), new Queen(Game.PLAYER_ONE));
        board.put(new Space(4, 7), new King(Game.PLAYER_ONE));
        for (int i =0; i < 8; i++){
            board.put(new Space(i, 6), new Pawn(Game.PLAYER_ONE));
        }
    }


    public Piece getPiece(int x, int y){
       return board.get(new Space(x, y));
    }

    public HashMap<Space, Piece> getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
               b.append(board.get(new Space(x,y)).toString());
            }
            b.append('\n');
        }
        return b.toString();
    }

}