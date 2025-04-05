package br.com.devcompleto;

public class Ticker {
    public static void main(String... args) throws InterruptedException {
        String str = "<| Welcome to java text mode animation! |> ";
        int width = 60;
        int spaces = width - str.length();
        String line="";

        // Replace ⋖ by the actual angle brackets as YT doesn't allow angle brackets in description.
        for(int i = 1; i <= spaces; i++) {
            line+=" ";
        }

        line += str;
        System.out.print("\033[H\033[2J");
        System.out.println("\u001b[35;1m");
        while(true){
            System.out.print("\r"+line);
            Thread.sleep(500);
            line = line.substring(1)+line.charAt(0);
        }
    }
}
