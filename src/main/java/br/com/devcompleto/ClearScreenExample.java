package br.com.devcompleto;

import java.util.Scanner;

public class ClearScreenExample {
    public static void main(String[] args) {
        System.out.println("Hello!!!");
        System.out.println("================= CLS ================");
        Scanner scanner = new Scanner(System.in);
        String read =  scanner.nextLine();
        scanner.close();
//        System.out.print("\033c");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
