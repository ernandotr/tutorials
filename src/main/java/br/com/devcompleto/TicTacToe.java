package br.com.devcompleto;

import java.util.Scanner;

public class TicTacToe {
    static String [] board = {"", "1", "2" ,"3", "4", "5", "6", "7", "8", "9" };

    public static void main(String[] args) {
        clearScreen();
        drawBoard();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Payer 1, enter your chosen: ");
        int chosen = scanner.nextInt();
        board[chosen] = "X";

        drawBoard();

        System.out.println("Player 2, enter your chosen: ");
        chosen = scanner.nextInt();
        board[chosen] = "O";
        drawBoard();


    }

    private static  void drawBoard() {

        System.out.println("      TIC TAC TOE GAME");
        System.out.println("  ========================");
        System.out.print("         |     |\n\r");
        System.out.printf("      %s  |  %s  |  %s  \n\r", board[1], board[2], board[3]);
        System.out.print("    --------------------\n");
        System.out.printf("      %s  |  %s  |  %s  \n", board[4], board[5], board[6]);
        System.out.print("    --------------------\n");
        System.out.printf("      %s  |  %s  |  %s  \n", board[7], board[8], board[9]);
        System.out.print("         |     |\n\r");
        System.out.println("  ========================");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}