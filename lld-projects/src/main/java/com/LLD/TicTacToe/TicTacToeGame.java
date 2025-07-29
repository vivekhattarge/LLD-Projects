package com.LLD.TicTacToe;

import com.LLD.TicTacToe.model.*;

import java.util.*;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    public void initialize() {
        players = new LinkedList<>();

        PlayingPieceX playingPieceX = new PlayingPieceX(PieceType.X);
        Player player1 = new Player("Player1",playingPieceX);

        PlayingPieceO playingPieceO = new PlayingPieceO(PieceType.O);
        Player player2 = new Player("Player2",playingPieceO);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner= true;
        while (noWinner){
            //print game board
           gameBoard.print();
           //get free Spaces
           List<Map<Integer,Integer>> freeSpaces = gameBoard.getFreeSpaces();
           if(freeSpaces.isEmpty()){
               noWinner = false;
               continue;
           }
           Player playerTurn = players.removeFirst();
           //Get User Inputs
            System.out.println("PLayer : "+playerTurn.getName()+" Enter row,column: ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String [] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            boolean addPieceStatus = gameBoard.addPiece(inputRow,inputColumn,playerTurn.getPlayingPiece());
            if(!addPieceStatus){
                System.out.println("Wrong Position Entered!!!");
                continue;
            }
            players.add(playerTurn);
            boolean winner = isThereWinner(inputRow,inputColumn,playerTurn.getPlayingPiece());
            if(winner){
                return playerTurn.getName();
            }

        }
        return "No Winner of the game!";
    }

    private boolean isThereWinner(int row, int column, PlayingPiece playingPiece) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i=0; i< gameBoard.size; i++){
            if(gameBoard.board[row][i] == null || playingPiece.getPieceType() != gameBoard.board[row][i].getPieceType()){
                    rowMatch = false;
                    break;
            }
        }
        for(int i=0; i< gameBoard.size; i++){
            if(gameBoard.board[i][column] == null || playingPiece.getPieceType() != gameBoard.board[i][column].getPieceType()){
                columnMatch = false;
                break;
            }
        }

        for(int i=0,j=0; i<gameBoard.size;i++,j++){
             if(gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != playingPiece.getPieceType()){
                 diagonalMatch = false;
                 break;
             }
        }

        for(int i=0,j= gameBoard.size-1; i<gameBoard.size;i++,j--){
              if(gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != playingPiece.getPieceType()){
                  antiDiagonalMatch = false;
                  break;
              }
        }
        return rowMatch | columnMatch | diagonalMatch | antiDiagonalMatch;
    }
}
