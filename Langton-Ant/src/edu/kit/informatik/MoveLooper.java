package edu.kit.informatik;

/**
 * This class is responsible for changing and tracking the board and moving the ant.
 *
 * @author ujoau (Georgi Sokolov)
 * @version 1.0
 */
public class MoveLooper {

    /*
     * This is the board field.
     */
    private char[][] board;

    /*
     * This is the ant field.
     */
    private Ant ant;

    /*
     * This is the class constructor.
     */
    public MoveLooper(char[][] b) {
        board = b;
        ant = new Ant(board);
    }

    /**
     * This method loops and moves the ant n times.
     *
     * @return false if the ant left the field else true
     */
    public boolean loop(int n) {
        if (n == 0) {
            return true;
        } else {
            for (int i = 0; i < n; i++) {
                if (!checkForBorder()) {
                    return false;
                }
                if (ant.getColorUnderAnt() == '0') {
                    board[ant.getX()][ant.getY()] = '1';
                } else {
                    board[ant.getX()][ant.getY()] = '0';
                }
                if (ant.getDirection() == 'N') {
                    if (board[ant.getX() - 1][ant.getY()] == '0') {
                        ant.setColorUnderAnt('0');
                        ant.setDirection('E');
                        board[ant.getX() - 1][ant.getY()] = 'E';
                    } else {
                        ant.setColorUnderAnt('1');
                        ant.setDirection('W');
                        board[ant.getX() - 1][ant.getY()] = 'W';
                    }
                    ant.setXY(ant.getX() - 1, ant.getY());
                    continue;
                }
                if (ant.getDirection() == 'S') {
                    if (board[ant.getX() + 1][ant.getY()] == '0') {
                        ant.setColorUnderAnt('0');
                        ant.setDirection('W');
                        board[ant.getX() + 1][ant.getY()] = 'W';
                    } else {
                        ant.setColorUnderAnt('1');
                        ant.setDirection('E');
                        board[ant.getX() + 1][ant.getY()] = 'E';
                    }
                    ant.setXY(ant.getX() + 1, ant.getY());
                    continue;
                }
                if (ant.getDirection() == 'W') {
                    if (board[ant.getX()][ant.getY() - 1] == '0') {
                        ant.setColorUnderAnt('0');
                        ant.setDirection('N');
                        board[ant.getX()][ant.getY() - 1] = 'N';
                    } else {
                        ant.setColorUnderAnt('1');
                        ant.setDirection('S');
                        board[ant.getX()][ant.getY() - 1] = 'S';
                    }
                    ant.setXY(ant.getX(), ant.getY() - 1);
                    continue;
                }
                if (ant.getDirection() == 'E') {
                    if (board[ant.getX()][ant.getY() + 1] == '0') {
                        ant.setColorUnderAnt('0');
                        ant.setDirection('S');
                        board[ant.getX()][ant.getY() + 1] = 'S';
                    } else {
                        ant.setColorUnderAnt('1');
                        ant.setDirection('N');
                        board[ant.getX()][ant.getY() + 1] = 'N';
                    }
                    ant.setXY(ant.getX(), ant.getY() + 1);
                }
            }
        }
        return true;
    }

    /**
     * This method checks if the ant will leave the field the coming turn
     *
     * @return false if the ant leaves the field else true
     */
    private boolean checkForBorder() {
        if (ant.getDirection() == 'N' && board[ant.getX() - 1][ant.getY()] == 'B') {
            return false;
        }
        if (ant.getDirection() == 'S' && board[ant.getX() + 1][ant.getY()] == 'B') {
            return false;
        }
        if (ant.getDirection() == 'W' && board[ant.getX()][ant.getY() - 1] == 'B') {
            return false;
        }
        return ant.getDirection() != 'E' || board[ant.getX()][ant.getY() + 1] != 'B';
    }

    /**
     * This is a getter for ant.
     *
     * @return ant
     */
    public Ant getAnt() {
        return ant;
    }

    /**
     * This is a getter for the board.
     *
     * @return board 2D array
     */
    public char[][] getBoard() {
        return board;
    }
}
