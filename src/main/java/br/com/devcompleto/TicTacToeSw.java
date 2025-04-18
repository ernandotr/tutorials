package br.com.devcompleto;

import javax.swing.*;
import java.awt.*;

public class TicTacToeSw {

    private final int boadWidth = 600;
    private final int boardHeight = 650;

    JFrame frame = new JFrame("Tic Tac Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton [][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver;
    int turns = 0;

    TicTacToeSw() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Look and Feel not set: " + e.getMessage());
        }
        frame.setVisible(true);
        frame.setSize(boadWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setOpaque(true);
        textLabel.setFont(new Font("Helvetica", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");

        textPanel.setLayout( new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for( int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setOpaque(true);
                tile.setForeground(Color.blue);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Helvetica", Font.BOLD, 120));
                tile.setFocusable(false);
//                tile.setText(currentPlayer);

                tile.addActionListener(e -> {
                    if(gameOver) return;

                    JButton tile1 = (JButton) e.getSource();
                    if("".equals(tile1.getText())){
                        tile1.setText(currentPlayer);

                        turns++;
                        checkWinner();
                        if(!gameOver) {
                            currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                            textLabel.setText(currentPlayer + "'s turn.");
                        }
                    }


                });
            }
        }

    }

    private void checkWinner() {

        for(int r = 0; r < 3; r++) {
            if ("".equals(board[r][0].getText())) continue;

            if(board[r][0].getText().equals(board[r][1].getText()) && board[r][1].getText().equals(board[r][2].getText())) {
                for(int i = 0; i < 3; i++) {
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }

        for(int c = 0; c < 3; c++) {
            if ("".equals(board[0][c].getText())) continue;

            if(board[0][c].getText().equals(board[1][c].getText()) && board[1][c].getText().equals(board[2][c].getText())) {
                for(int i = 0; i < 3; i++) {
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }

        if(!"".equals(board[0][0].getText())
                && board[0][0].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][2].getText())){
            for(int i = 0; i < 3; i++ ) {
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
        }

        if(!"".equals(board[0][2].getText())
                && board[0][2].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][0].getText())){
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            gameOver = true;
            return;
        }

        if(turns == 9) {
            for(int r = 0; r < 3; r++) {
                for(int c = 0; c < 3; c++) {
                    setTie(board[r][c]);
                }
            }
            gameOver = true;
        }

    }

    private void setTie(JButton tile) {
        tile.setForeground(Color.red);
        tile.setBackground(Color.gray);
        textLabel.setText("Tie");
    }

    private void setWinner(JButton tile) {
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
        textLabel.setText(currentPlayer + " is the winner.");
    }


    public static void main(String[] args) {
        TicTacToeSw game = new TicTacToeSw();
    }
}
