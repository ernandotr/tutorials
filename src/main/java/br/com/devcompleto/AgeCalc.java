package br.com.devcompleto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        LocalDate birth = LocalDate.of(1979, 6, 29);
        LocalDate today = LocalDate.now();
        Period period = Period.between(birth, today);
        System.out.println(period.getYears());
    }
}
