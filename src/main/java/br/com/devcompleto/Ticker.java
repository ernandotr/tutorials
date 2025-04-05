package br.com.devcompleto;

public class Ticker {
    public static void main(String... args) throws InterruptedException {
        String str = "\uD83D\uDEB5\uD83C\uDFFB\u200D♀️Welcome to \uD83D\uDC7D java text mode animation!\uD83D\uDEA3\uD83C\uDFFB\u200D♂️";
        int width = 60;
        int spaces = width - str.length();

        StringBuilder line= new StringBuilder();
        line.append(" ".repeat(spaces));
        line.append(str);

        clearScreen();
        changeTextColor();

        while(true){
            System.out.print("\r"+line);
            Thread.sleep(500);
            line = new StringBuilder(line.substring(1) + line.charAt(0));
        }
    }

    private static void changeTextColor() {
        System.out.println("\u001b[35;1m");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}
