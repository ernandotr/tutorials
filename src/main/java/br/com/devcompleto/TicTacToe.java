package br.com.devcompleto;

import java.util.Scanner;

public class TicTacToe {
    public static final String END_GAME = " ==== END GAME ====";
    public static final String PLAYER_ONE_NAME = "Player 1";
    public static final String PLAYER_2_NAME = "Player 2";
    public static final String PLAYER_ONE_MARK = "X";
    public static final String PLAYER_TWO_MARK = "O";
    private static final String RED_BOLD = " \u001b[31;1m";
    static String BLUE = "\u001b[34m";
    private static final String RESET = "\u001b[0m";
    static String [] board = {"", "1", "2" ,"3", "4", "5", "6", "7", "8", "9" };

    public static void main(String[] args) {

        drawBoard();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            int choice = readChoice(scanner, PLAYER_ONE_NAME);
            board[choice] = PLAYER_ONE_MARK;
            drawBoard();
            checkWinner(PLAYER_ONE_NAME);

            if (checkIfThereIsTie()) break;

            choice = readChoice(scanner, PLAYER_2_NAME);
            board[choice] = PLAYER_TWO_MARK;
            drawBoard();
            checkWinner(PLAYER_2_NAME);
            if (checkIfThereIsTie()) break;
        }
    }

    private static int readChoice(Scanner scanner, String player) {
        System.out.printf("%s, enter your choice: ", player);
        return scanner.nextInt();
    }

    private static void checkWinner(String player) {
        if(hasWinner()){
            System.out.printf("\u001b[32;1m => %s, you won !!!. \u001b[0m %n", player);
            System.out.println(END_GAME);
            System.exit(0);
        }
    }

    private static boolean checkIfThereIsTie() {
        if(isTie()) {
            System.out.println(" => There is tie.");
            System.out.println(END_GAME);
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
        drawBoardHeader();
        drawBoardBody();
        drawBoardFooter();
    }

    private static void drawBoardBody() {
        System.out.print("  |                      |\n");
        System.out.print("  |       |     |        |\n\r");
        System.out.printf("  |    %s  |  %s  |  %s     |\n\r", board[1], board[2], board[3]);
        System.out.print("  |  -----------------   |\n");
        System.out.printf("  |    %s  |  %s  |  %s     |\n", board[4], board[5], board[6]);
        System.out.print("  |  -----------------   |\n");
        System.out.printf("  |    %s  |  %s  |  %s     |\n", board[7], board[8], board[9]);
        System.out.print("  |       |     |        |\n");
        System.out.print("  |                      |");
    }

    private static void drawBoardFooter() {
        System.out.println(BLUE);
        System.out.println("  ========================");
        System.out.println(RESET);
    }

    private static void drawBoardHeader() {
        System.out.println(BLUE);
        System.out.println("  ========================");
        System.out.println("  |   TIC TAC TOE GAME   |");
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