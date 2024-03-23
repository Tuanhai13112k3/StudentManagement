/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author acer
 */
public class Validation {

    private static final Scanner SCANNER = new Scanner(System.in);
    
    /**
     * Reads an integer input from the user within the specified range.
     *
     * @param messageInfo               the message to be printed instructing
     *                                  the user to input
     * @param messageErrorOutOfRange    the message will be printed if the string
     *                                  parse value is out of range
     * @param messageErrorInvalidNumber the message will be printed if the string
     *                                  does not contain a parsable integer
     * @param min                       the minimum limit value
     * @param max                       the maximum limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
    
    /**
     * Prompts the user with a message and reads a string input from the console.
     *
     * @param messageInfo           The message to display as the input prompt.
     * @param messageErrorInvalidRegex The message to display when the input does not match the specified regex.
     * @param TYPEREGEX              The regular expression pattern that the input should match.
     * @return The valid string input from the user that matches the specified regex.
     */
    public static String getString(
            String messageInfo,
            String messageErrorInvalidRegex,
            final String TYPEREGEX
    ) {
        do {
            System.out.print(messageInfo);
            String inputString = SCANNER.nextLine();
            if (inputString.matches(TYPEREGEX)) {
                return inputString;
            }
            System.out.println(messageErrorInvalidRegex);
        } while (true);
    }
    
    /**
    * Prompts the user with a message and reads a string input from the console.
    *
    * @param messageInfo           The message to display as the input prompt.
    * @param messageErrorInvalidRegex The message to display when the input does not match the specified regex.
    * @param TYPEREGEX              The regular expression pattern that the input should match.
    * @return The valid string input from the user that matches the specified regex.
    */
    public static boolean getYN(
            String messageInfo,
            String messageErrorInvalidRegex,
            final String TYPEREGEX
    ) {
        do {
            try {
                System.out.print(messageInfo);
                String inputString = SCANNER.nextLine();
                if (inputString.matches("Y")) {
                    return true;
                } else if (inputString.matches("N")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(messageErrorInvalidRegex);
            }
        } while (true);
    }
    /**
     * Returns the valid double value scanned from the input.
     *
     * @param messageInfo               the message to be printed instructing 
     *                                  the user to input
     * @param messageErrorOutOfRange    the message will be printed if the string
     *                                  parse value is out of range
     * @param messageErrorInvalidNumber the message will be printed if the
     *                                  string does not contain a parsable integer
     * @param min                       the minimum limit value
     * @param max                       the maximum limit value
     * @return the valid double value scanned from the input
     */
    public static double getDouble(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) {
        do {
            try {
                System.out.print(messageInfo);
                String numberString = SCANNER.nextLine().replaceAll(",", ".");
                double number = Double.parseDouble(numberString);
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
}
