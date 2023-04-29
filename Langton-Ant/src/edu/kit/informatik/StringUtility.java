package edu.kit.informatik;

/**
 * This is a helper class.
 *
 * @author ujoau (Georgi Sokolov)
 * @version 1.0
 */
public final class StringUtility {

    /**
     * This method turns a text file into a 2D char array.
     *
     * @return a 2D array
     */
    public static char[][] fileToArray(String filePath) {
        String[] fileRows = Terminal.readFile(filePath);
        char[][] array = new char[fileRows.length][];
        for (int i = 0; i < fileRows.length; i++) {
            array[i] = fileRows[i].toCharArray();
        }
        return array;
    }

    /**
     * This method turns 2D char array into a board with borders named 'B'.
     *
     * @return a new 2D array
     */
    public static char[][] arrayToBoard(char[][] array) {
        char[][] board = new char[array.length + 2][array[0].length + 2];
        for (int i = 0; i < array[0].length + 2; i++) {
            board[0][i] = 'B';
            board[array.length + 1][i] = 'B';
        }
        for (int i = 1; i < array.length + 2; i++) {
            board[i][0] = 'B';
            board[i][array[0].length + 1] = 'B';
        }
        for (int i = 1; i < array.length + 1; i++) {
            for (int j = 1; j < array[0].length + 1; j++) {
                board[i][j] = array[i - 1][j - 1];
            }
        }
        return board;
    }

    /**
     * This method turns a string into an array by splitting it by space.
     *
     * @return a string array
     */
    public static String[] spiltBySpace(String string) {
        return string.split(" ");
    }

    /**
     * This method turns a string into an array by splitting it by coma.
     *
     * @return a string array
     */
    public static String[] spiltByComma(String string) {
        return string.split(",");
    }
}


