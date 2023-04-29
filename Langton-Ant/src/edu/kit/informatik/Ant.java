package edu.kit.informatik;

/**
 * This is the class for creating Ant objects.
 *
 * @author ujoau (Georgi Sokolov)
 * @version 1.0
 */
public class Ant {

    /*
     * This field records the x coordinate of the ant.
     */
    private int x;

    /*
     * This field records the y coordinate of the ant.
     */
    private int y;

    /*
     * This field records the orientation of the ant.
     */
    private char direction;

    /*
     * This field records the color the ant is sitting on.
     */
    private char colorUnderAnt;

    /*
     * This is the Ant constructor.
     */
    public Ant(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 'N' || arr[i][j] == 'S' || arr[i][j] == 'E' || arr[i][j] == 'W') {
                    setXY(i, j);
                    direction = arr[i][j];
                }
            }
        }
        colorUnderAnt = '1';
    }

    /**
     * This is the setter for the ant's coordinates.
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This is the getter for the x coordinate.
     *
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * This is the getter for the y coordinate.
     *
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * This is the getter for the ant's orientation.
     *
     * @return ants's direction/orientation
     */
    public char getDirection() {
        return direction;
    }

    /**
     * This is the setter for the ant's orientation.
     */
    public void setDirection(char direction) {
        this.direction = direction;
    }

    /**
     * This is the getter for color of the tile the ant is on.
     *
     * @return the color of the tile the ant is on
     */
    public char getColorUnderAnt() {
        return colorUnderAnt;
    }

    /**
     * This is the setter for the color of the tile the ant is on.
     */
    public void setColorUnderAnt(char colorUnderAnt) {
        this.colorUnderAnt = colorUnderAnt;
    }
}
