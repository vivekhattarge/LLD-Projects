package com.LLD.TicTacToe.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    public int size;
    public  PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece){
        if(board[row][column] != null){
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }


    public List<Map<Integer, Integer>> getFreeSpaces() {
        List<Map<Integer,Integer>> freeSpaces = new ArrayList<>();
        for(int i=0; i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null){
                    freeSpaces.add((Map<Integer, Integer>) new HashMap<>().put(i,j));
                }
            }
        }
        return freeSpaces;
    }
}
