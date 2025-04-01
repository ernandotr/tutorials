package br.com.devcompleto;

import java.util.Scanner;

public class TicTacToe {
    static String [] board = {"", "1", "2" ,"3", "4", "5", "6", "7", "8", "9" };

    public static void main(String[] args) {

        drawBoard();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Payer 1, enter your choice: ");
            int choice = scanner.nextInt();
            board[choice] = "X";
            drawBoard();
            if(hasWinner()){
                System.out.println(" => Pay 1, you won !!!.");
                System.out.println(" ==== END GAME ====");
                break;
            }

            if (checkIfThereIsTie()) break;

            System.out.println("Player 2, enter your choice: ");
            choice = scanner.nextInt();
            board[choice] = "O";
            drawBoard();
            if(hasWinner()){
                System.out.println(" => Pay 2 you won !!!.");
                System.out.println(" ==== END GAME ====");
                break;
            }
            if (checkIfThereIsTie()) break;
        }
    }

    private static boolean checkIfThereIsTie() {
        if(isTie()) {
            System.out.println(" => There is tie.");
            System.out.println(" ==== END GAME ====");
            return true;
        }
        return false;
    }

    private static boolean hasWinner() {

        return (board[1].equals(board[2]) && board[2].equals(board[3]))
                || (board[1].equals(board[4]) && board[4].equals(board[7]))
                || (board[4].equals(board[5]) && board[5].equals(board[6]))
                || (board[7].equals(board[8]) && board[8].equals(board[9]))
                || (board[2].equals(board[5]) && board[5].equals(board[8]))
                || (board[3].equals(board[6]) && board[6].equals(board[9]))
                || (board[1].equals(board[5]) && board[5].equals(board[9]))
                || (board[7].equals(board[5]) && board[5].equals(board[3]));
    }

    private static  void drawBoard() {
        clearScreen();
        System.out.println();
        System.out.println("  ========================");
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

    private static boolean isTie() {
        boolean tie = true;
        for(String s : board){
            if(isNumeric(s)) {
                tie = false;
                break;
            }
        }
        return tie;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}