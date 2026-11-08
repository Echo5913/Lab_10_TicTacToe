
import java.util.Scanner;

public class TicTacToe {

    // Declare board size
    private static final int ROWS = 3;
    private static final int COLS = 3;

    // Create the game board
    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        boolean playAgain = true;

        // Repeat the game while players want to play again
        while (playAgain) {

            // Clear the board and start with X
            clearBoard();

            String player = "X";
            int moveCounter = 0;
            boolean gameOver = false;

            System.out.println("Welcome to Tic Tac Toe!");

            // Continue until there is a winner or tie
            while (!gameOver) {

                // Display the current board
                display();

                System.out.println("Player " + player + "'s turn.");

                // Get the player's row and column
                int rowMove = SafeInput.getRangedInt(
                        console, "Enter row (1-3): ", 1, 3);

                int colMove = SafeInput.getRangedInt(
                        console, "Enter column (1-3): ", 1, 3);

                // Convert moves to array indexes
                int row = rowMove - 1;
                int col = colMove - 1;

                // Keep asking until the move is valid
                while (!isValidMove(row, col)) {

                    System.out.println("That space is already taken!");
                    display();

                    rowMove = SafeInput.getRangedInt(
                            console, "Enter row (1-3): ", 1, 3);

                    colMove = SafeInput.getRangedInt(
                            console, "Enter column (1-3): ", 1, 3);

                    row = rowMove - 1;
                    col = colMove - 1;
                }

                // Record the player's move
                board[row][col] = player;

                // Increase the move counter
                moveCounter++;

                // Check for a winner
                if (isWin(player)) {

                    display();
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;

                }

                // Check for a tie
                else if (isTie()) {

                    display();
                    System.out.println("The game is a tie!");
                    gameOver = true;

                }

                // Switch to the other player
                else {

                    if (player.equals("X")) {
                        player = "O";
                    } else {
                        player = "X";
                    }
                }
            }

            // Ask players if they want another game
            playAgain = SafeInput.getYNConfirm(
                    console, "Would you like to play again? ");

        }

        System.out.println("Thanks for playing!");

        console.close();
    }

    // Clear all spaces on the board
    private static void clearBoard() {

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }

    // Display the Tic Tac Toe board
    private static void display() {

        System.out.println();

        for (int row = 0; row < ROWS; row++) {

            System.out.println(" " + board[row][0] + " | "
                    + board[row][1] + " | " + board[row][2]);

            if (row < ROWS - 1) {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }

    // Check whether a move is valid
    private static boolean isValidMove(int row, int col) {

        return board[row][col].equals(" ");
    }

    // Check all possible ways to win
    private static boolean isWin(String player) {

        return isColWin(player)
                || isRowWin(player)
                || isDiagnalWin(player);
    }

    // Check for a column win
    private static boolean isColWin(String player) {

        for (int col = 0; col < COLS; col++) {

            if (board[0][col].equals(player)
                    && board[1][col].equals(player)
                    && board[2][col].equals(player)) {

                return true;
            }
        }

        return false;
    }

    // Check for a row win
    private static boolean isRowWin(String player) {

        for (int row = 0; row < ROWS; row++) {

            if (board[row][0].equals(player)
                    && board[row][1].equals(player)
                    && board[row][2].equals(player)) {

                return true;
            }
        }

        return false;
    }

    // Check for a diagonal win
    private static boolean isDiagnalWin(String player) {

        // Check diagonal from top left to bottom right
        if (board[0][0].equals(player)
                && board[1][1].equals(player)
                && board[2][2].equals(player)) {

            return true;
        }

        // Check diagonal from top right to bottom left
        if (board[0][2].equals(player)
                && board[1][1].equals(player)
                && board[2][0].equals(player)) {

            return true;
        }

        return false;
    }

    // Check whether the board is full
    private static boolean isTie() {

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {

                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }

        return true;
    }
}

