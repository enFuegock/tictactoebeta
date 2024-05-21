package com.kodilla.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;
    private int pointLimit;
    private int playerXpoints = 0;
    private int playerOpoints = 0;

    public char currentPlayer = 'X';
    public char[][] getboard() {
        return board;
    }
    private boolean gameOver;
    public int gameType;
    private boolean vsComputer = false;
    void startGame() {
        intro();
        while (!gameOver) {
            displayScores();
            displayBoard();
            if (currentPlayer == 'X' || !vsComputer) {
                playerMove();
            } else {
                computerMove();
            }
            if (gameType == 1) {
                checkWin3x3();
            } else if (gameType == 2) {
                checkWin10x10();
            } else {
                System.out.println("Wrong input. Please try again.");
                return;
            }
            switchPlayer();
        }
    }
    public void intro() {
        Scanner scanner = new Scanner(System.in);
        int playerOrComputer;
        System.out.println("Welcome Circle&Cross Game!");
        System.out.println("1. vs Player");
        System.out.println("2. vs Computer");
        playerOrComputer = scanner.nextInt();
        if(playerOrComputer == 2) {
            vsComputer = true;
        }
        System.out.println("Choose mode:");
        System.out.println("1. Classic (3x3)");
        System.out.println("2. To Five (10x10)");
        gameType = scanner.nextInt();
        System.out.println("Input the number of points you will play for: ");
        int pointLimit = scanner.nextInt();
        if (gameType == 1) {
            createBoard(3, pointLimit);
        } else if (gameType == 2) {
            createBoard(10, pointLimit);
        } else {
            System.out.println("Wrong input. Please try again.");
        }
    }
    public void createBoard(int rozmiar, int pointLimit) {
        this.pointLimit = pointLimit;
        board = new char[rozmiar][rozmiar];
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int k = 0; k < board.length; k++) {
                System.out.print("---|");
            }
            System.out.println();
            for (int j = 0; j < board.length; j++) {
                System.out.print("| ");
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.print("|");
        for (int k = 0; k < board.length; k++) {
            System.out.print("---|");
        }
        System.out.println("");
        System.out.println();
    }
    public void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.println("Now it's " + currentPlayer + " turn, input row (0-" + (board.length - 1) + ") and column (0-" + (board.length - 1) + "): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isMoveCorrect(row, col));
        board[row][col] = currentPlayer;
    }
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    private void addScore() {
        if (currentPlayer == 'X') {
            playerXpoints++;
        } else {
            playerOpoints++;
        }
        System.out.println("Player " + currentPlayer + " wins!");
        displayScores();
        createBoard(board.length, pointLimit);
        if (playerXpoints >= pointLimit || playerOpoints >= pointLimit) {
            gameOver = true;
        }
    }
    public void displayScores() {
        System.out.println("Points:");
        System.out.println("Player X has: " + playerXpoints + " points");
        System.out.println("Player O has: " + playerOpoints + " points");
    }
    public boolean checkWin3x3() {
        for (int i = 0; i < 3; i++) {
            if (checkWinLine3x3(i, 0, 0, 1) || checkWinLine3x3(0, i, 1, 0)) {
                addScore();
                return true;
            }
        }
        if (checkWinLine3x3(0, 0, 1, 1) || checkWinLine3x3(0, 2, 1, -1)) {
            addScore();
            return true;
        }
        return false;
    }
    private boolean checkWinLine3x3(int row, int col, int dRow, int dCol) {
        char target = board[row][col];
        for (int i = 0; i < 3; i++) {
            if (board[row][col] != target || board[row][col] == ' ') {
                return false;
            }
            row += dRow;
            col += dCol;
        }
        return true;
    }
    public boolean checkWin10x10() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                if (checkWinLine10x10(i, j, 0, 1)) {
                    addScore();
                    return true;
                }
            }
        }
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                if (checkWinLine10x10(j, i, 1, 0)) {
                    addScore();
                    return true;
                }
            }
        }
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                if (checkWinLine10x10(i, j, 1, 1) || checkWinLine10x10(i, 9 - j, 1, -1)) {
                    addScore();
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkWinLine10x10(int row, int col, int dRow, int dCol) {
        char target = board[row][col];
        for (int i = 0; i < 5; i++) {
            if (board[row][col] != target || board[row][col] == ' ') {
                return false;
            }
            row += dRow;
            col += dCol;
        }
        return true;
    }
    public boolean isDraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isMoveCorrect(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board.length) {
            System.out.println("Incorrect move! Please input cooridnates from range 0-" + (board.length-1) + ".");
            return false;
        }
        if (board[row][col] != ' ') {
            System.out.println("This field is taken, please choose another one!");
            return false;
        }
        return true;
    }
    public void computerMove() {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(board.length);
            col = rand.nextInt(board.length);
        } while (board[row][col] != ' ');
        board[row][col] = currentPlayer;
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}
