package br.com.devcompleto;

public class TicTacToe {
    static String [] board = {"1", "2" ,"3", "4", "5", "6", "7", "8", "9" };

    public static void main(String[] args) {

       printBoard();



    }

    private static  void printBoard() {
        System.out.println("\n\tTIC TAC TOE GAME");
        System.out.println("========================");
        System.out.print("\t     |     |\n");
        System.out.printf("\t  %s  |  %s  |  %s  \n", board[0], board[1], board[2]);
        System.out.printf("\t--------------------\n");
        System.out.printf("\t  %s  |  %s  |  %s  \n", board[3], board[4], board[5]);
        System.out.printf("\t--------------------\n");
        System.out.printf("\t  %s  |  %s  |  %s  \n", board[6], board[7], board[8]);
        System.out.print("\t     |     |\n");
    }
}