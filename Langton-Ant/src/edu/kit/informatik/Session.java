package edu.kit.informatik;

/**
 * This is the main class containing the main() method,
 * responsible for the user interaction with the program.
 *
 * @author ujoau (Georgi Sokolov)
 * @version 1.0
 */
public class Session {

    /**
     * This is the main  method,
     * used for user interaction.
     */
    public static void main(String[] args) {
        MoveLooper looper = new MoveLooper(StringUtility.arrayToBoard(StringUtility.fileToArray(args[0])));
        while (true) {
            String userCommand = Terminal.readLine();
            String[] splitCommand = StringUtility.spiltBySpace(userCommand);
            if (splitCommand[0].equals("quit")) {
                break;
            }
            if (splitCommand[0].equals("move")) {
                int n = Integer.parseInt(splitCommand[1]);
                if (!looper.loop(n)) {
                    break;
                }
            }
            if (splitCommand[0].equals("position")) {
                Terminal.printLine((looper.getAnt().getX() - 1) + "," + (looper.getAnt().getY() - 1));
            }
            if (splitCommand[0].equals("field")) {
                String[] commandParameters = StringUtility.spiltByComma(splitCommand[1]);
                int commandX = Integer.parseInt(commandParameters[0]);
                int commandY = Integer.parseInt(commandParameters[1]);
                char[][] b = looper.getBoard();
                Terminal.printLine(b[commandX + 1][commandY + 1]);
            }
            if (splitCommand[0].equals("print")) {
                char[][] b = looper.getBoard();
                for (int i = 1; i < b.length - 1; i++) {
                    StringBuilder line = new StringBuilder();
                    for (int j = 1; j < b[0].length - 1; j++) {
                        line.append(b[i][j]);
                    }
                    Terminal.printLine(line.toString());
                }
            }
        }
    }
}
