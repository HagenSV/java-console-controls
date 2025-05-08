package edu.hagensv.io;

public class StyledPrinter {

    public enum Color {
        BLACK(30),
        RED(31),
        GREEN(32),
        YELLOW(33),
        BLUE(34),
        MAGENTA(35),
        CYAN(36),
        WHITE(37),
        GRAY(90),
        BRIGHT_RED(91),
        BRIGHT_GREEN(92),
        BRIGHT_YELLOW(93),
        BRIGHT_BLUE(94),
        BRIGHT_MAGENTA(95),
        BRIGHT_CYAN(96),
        BRIGHT_WHITE(97);

        private final int value;

        Color(int value){
            this.value = value;
        }
    }

    private boolean bold = false;
    private boolean italic = false;
    private boolean underline = false;
    private boolean strikethrough = false;
    private boolean hidden = false;
    private String foregroundColor = "";
    private String backgroundColor = "";

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public void setUnderline(boolean underline) {
        this.underline = underline;
    }

    public void setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    public void setHidden(boolean hidden){
        this.hidden = true;
    }

    private void resetFormat(){
        System.out.print("\033[39m");
        System.out.print("\033[49m");
    }

    private void format(){
        resetFormat();
        StringBuilder sb = new StringBuilder();
        if (bold) sb.append("\033[1m");
        if (italic) sb.append("\033[3m");
        if (underline) sb.append("\033[4m");
        if (strikethrough) sb.append("\033[9m");
        if (hidden) sb.append("\033[8m");

        sb.append(foregroundColor);
        sb.append(backgroundColor);
        System.out.print(sb);
    }

    /**
     * Sets the text color to a predefined system color.
     * @param color the color to set
     */
    public void setTextColor(Color color) {
        foregroundColor = String.format("\033[%dm", color.value);
    }

    /**
     * Set the text color to the specified RGB value.
     * @param r the red component (0-255)
     * @param g the green component (0-255)
     * @param b the blue component (0-255)
     */
    public void setTextColor(int r, int g, int b) {
        foregroundColor = String.format("\033[38;2;%d;%d;%dm",r,g,b);
    }


    /**
     * Sets the background color to a predefined system color.
     * @param color the color to set
     */
    public void setBackgroundColor(Color color) {
        backgroundColor = String.format("\033[%dm", color.value + 10);
    }

    /**
     * Set the background color to the specified RGB value.
     * @param r the red component (0-255)
     * @param g the green component (0-255)
     * @param b the blue component (0-255)
     */
    public void setBackgroundColor(int r, int g, int b) {
        backgroundColor = String.format("\033[48;2;%d;%d;%dm",r,g,b);
    }

    /**
     * Clear the text color to the default color.
     */
    public void clearTextColor() {
        foregroundColor = "";
    }

    /**
     * Clear the background color to the default color.
     */
    public void clearBackgroundColor(){
        backgroundColor = "";
    }

    public void print(boolean b){
        format();
        System.out.print(b);
        resetFormat();
    }

    public void print(char c){
        format();
        System.out.print(c);
        resetFormat();
    }

    public void print(char[] s){
        format();
        System.out.print(s);
        resetFormat();
    }

    public void print(double d){
        format();
        System.out.print(d);
        resetFormat();
    }

    public void print(float f){
        format();
        System.out.print(f);
        resetFormat();
    }

    public void print(int i){
        format();
        System.out.print(i);
        resetFormat();
    }

    public void print(long l){
        format();
        System.out.print(l);
        resetFormat();
    }

    public void print(Object o){
        format();
        System.out.print(o);
        resetFormat();
    }

    public void print(String message) {
        format();
        System.out.print(message);
        resetFormat();
    }

    public void println(boolean b){
        format();
        System.out.println(b);
        resetFormat();
    }

    public void println(char c){
        format();
        System.out.println(c);
        resetFormat();
    }

    public void println(char[] s){
        format();
        System.out.println(s);
        resetFormat();
    }

    public void println(double d){
        format();
        System.out.println(d);
        resetFormat();
    }

    public void println(float f){
        format();
        System.out.println(f);
        resetFormat();
    }

    public void println(int i){
        format();
        System.out.println(i);
        resetFormat();
    }

    public void println(long l){
        format();
        System.out.print(l);
        resetFormat();
    }

    public void println(Object o){
        format();
        System.out.println(o);
        resetFormat();
    }

    public void println(String message) {
        format();
        System.out.println(message);
        resetFormat();
    }

    public void printf(String message, Object... args) {
        System.out.printf(message, args);
    }

    public void printf(java.util.Locale l, String message, Object... args) {
        System.out.printf(l, message, args);
    }

}
