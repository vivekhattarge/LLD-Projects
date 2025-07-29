package com.LLD.TicTacToe;

public class Main {
    public static void main(String[] args) {

        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.initialize();
        System.out.println("Game Winner is : "+ticTacToeGame.startGame());

    }
}
