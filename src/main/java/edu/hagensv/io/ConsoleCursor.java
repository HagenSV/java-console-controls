package edu.hagensv.io;

public class ConsoleCursor {

    public enum Mode {
        AFTER(0),
        BEFORE(1),
        ALL(2);

        private final int value;

        Mode(int value){
            this.value = value;
        }
    }

    /**
     * Move the cursor up 1 line.
     */
    public static void cursorUp() { cursorUp(1); }

    /**
     * Move the cursor up n lines.
     * @param n the number of lines to move up
     */
    public static void cursorUp(int n) {
        System.out.printf("\033[%dA", n);
    }

    /**
     * Move the cursor down 1 line.
     */
    public static void cursorDown() { cursorDown(1); }

    /**
     * Move the cursor down n lines.
     * @param n the number of lines to move down
     */
    public static void cursorDown(int n) {
        System.out.printf("\033[%dB", n);
    }

    /**
     * Move the cursor forward 1 character.
     */
    public static void cursorForward() { cursorForward(1); }

    /**
     * Move the cursor forward n characters.
     * @param n the number of characters to move forward
     */
    public static void cursorForward(int n) {
        System.out.printf("\033[%dC", n);
    }

    /**
     * Move the cursor backward 1 character.
     */
    public static void cursorBackward() { cursorBackward(1); }

    /**
     * Move the cursor backward n characters.
     * @param n the number of characters to move backward
     */
    public static void cursorBackward(int n) {
        System.out.printf("\033[%dD", n);
    }

    /**
     * Clear the screen and move the cursor to the top left corner.
     */
    public static void clear() {
        setCursorPos(1,1);
        System.out.print("\033[2J\033[3J");
        System.out.flush();
    }

    public static void clear(Mode mode){
        System.out.printf("\033[%dJ",mode.value);
        System.out.flush();
    }

    public static void clearLine(){
        clearLine(Mode.ALL);
    }

    public static void clearLine(Mode mode){
        System.out.printf("\033[%dK",mode.value);
        System.out.flush();
    }

    /**
     * Clear the screen and move the cursor to the top left corner.
     * @param x the x coordinate of the cursor
     * @param y the y coordinate of the cursor
     */
    public static void setCursorPos(int x, int y){
        System.out.printf("\033[%d;%dH", y, x);
    }
}
