package bank;

import java.util.Scanner;

public class Utils {

    public static final Scanner scanner =
            new Scanner(System.in);


    public static void printLine() {

        System.out.println(
                "----------------------------------------"
        );
    }


    public static void printHeader(
            String title) {

        System.out.println();

        printLine();

        System.out.println(
                "        " + title
        );

        printLine();
    }


    public static int getInt(
            String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }


    public static double getDouble(
            String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid amount."
                );
            }
        }
    }


    public static String getString(
            String message) {

        System.out.print(message);

        return scanner.nextLine();
    }


    public static String getTransactionId() {

        return "TXN" +
                System.currentTimeMillis();
    }
}