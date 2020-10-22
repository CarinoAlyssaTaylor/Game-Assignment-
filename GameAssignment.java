/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameassignment;

/**
 *
 * @author alyssataylorcarino
 */
import java.util.*;
import java.io.*;

public class GameAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // Open file of words to read from
        File myFile = new File("wordBank.txt");
        Scanner inputFile = new Scanner(myFile);

        //point keeper
        int points = 0;

        //Read entire file
        while (inputFile.hasNext()) {
            //Read a word, 1 line at a time
            String word = inputFile.nextLine();
            // Scrambles word
            Random r = new Random();
            String scrambledWord = scramble(r, word);
            // Displays word
            System.out.println(scrambledWord);

            // Allow user to guess what the word is
            Scanner keyboard = new Scanner(System.in);
            String guess = keyboard.nextLine();

            //Check if user is correct 
            if (Objects.equals(word, new String(guess))) {
                points++;
                System.out.println("Correct! Points = " + points);
            } else {
                System.out.println("Sorry, that was incorrect. The word is: " + word);
            }
        }
        // Close File
        inputFile.close();

    }

    /**
     * scramble method randomly scrambles a string
     * @param random
     * @param inputString= word from file
     * @return 
     */
    public static String scramble(Random random, String inputString) {
        // Convert your string into a simple char array:
        char a[] = inputString.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle, 
        for (int i = 0; i < a.length; i++) {
            int j = random.nextInt(a.length);
            // Swap letters
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return new String(a);
    }

}
