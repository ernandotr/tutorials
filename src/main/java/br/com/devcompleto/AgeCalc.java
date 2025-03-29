package br.com.devcompleto;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a birth date to calc the age: ");
        String birthDate =  sc.nextLine();
        LocalDate birth =  LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

//        LocalDate birth = LocalDate.of(1979, 6, 29);
        LocalDate today = LocalDate.now();
        Period period = Period.between(birth, today);
        System.out.println(period.getYears());
    }
}
