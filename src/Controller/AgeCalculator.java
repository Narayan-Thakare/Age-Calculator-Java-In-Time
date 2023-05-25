package Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their birth date
        System.out.print("Enter your birth date (YYYY-MM-DD): ");
        String birthDateStr = scanner.nextLine();

        // Prompt the user to enter their birth time
        System.out.print("Enter your birth time (HH:MM:SS): ");
        String birthTimeStr = scanner.nextLine();

        // Parse the birth date and time
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        LocalDateTime birthDateTime = LocalDateTime.of(birthDate, LocalTime.parse(birthTimeStr));

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Calculate the difference between the birth date and current date
        Period period = Period.between(birthDate, currentDateTime.toLocalDate());

        // Calculate the total seconds between the birth date and current date
        long totalSeconds = java.time.Duration.between(birthDateTime, currentDateTime).getSeconds();

        // Calculate the remaining seconds after removing the complete years, days, hours, and minutes
        int remainingSeconds = (int) (totalSeconds % 31536000 % 86400 % 3600 % 60);

        // Print the age
        System.out.println("Age: " + period.getYears() + " years, " +
                period.getMonths() + " months, " + period.getDays() + " days, " +
                currentDateTime.getHour() + " hours, " + currentDateTime.getMinute() +
                " minutes, " + remainingSeconds + " seconds");

        // Close the scanner
        scanner.close();
    }
}
