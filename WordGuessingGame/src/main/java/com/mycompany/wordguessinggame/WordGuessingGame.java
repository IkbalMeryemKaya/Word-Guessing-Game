/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.wordguessinggame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Monster Huma H5 v4.1
 */
public class WordGuessingGame {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        words.add("ikbal");
        
        
        
        String[] letter = new String[26];
        ArrayList<Integer> points = new ArrayList<>();
        String MyWord;
        while (true) {
            System.out.println();
            System.out.println("   1- Add New Word");
            System.out.println("   2- New Game");
            System.out.println("   3- Show The Scores");
            System.out.println("   4- Exit");
            System.out.print("Please enter the transaction number: ");
            int menu = scnr.nextInt();

            if (menu == 1) {

                int ErrorNum = 0;
                System.out.print("Enter a word: ");
                String word = scnr.next().toLowerCase();
                int WordLength = word.length();

                //Check if the word has been entered before.
                for (int a = 0; a <= words.size(); a++) {
                    if (words.contains(word)) {
                        System.out.println("THE SAME WORD CANNOT BE ADDED TWICE.");
                        ErrorNum++;
                        break;
                    }
                }

                //Check if the word contains numbers.
                for (int WordIndex = 0; WordIndex < WordLength; WordIndex++) {
                    if (Character.isDigit(word.charAt(WordIndex))) {
                        System.out.println("WORD CANNOT CONTAIN NUMBERS.");
                        ErrorNum++;
                        break;
                    }
                }

                //Check the number of letters the word contains.
                if (WordLength <= 3) {
                    System.out.println("WORD CANNOT BE SHORTER THAN FOUR LETTERS.");
                    ErrorNum++;
                    continue;
                }

                //If ErrorNum is zero, everything is true. Word can be added.
                while (ErrorNum == 0) {
                    words.add(word);
                    System.out.println("THE WORD ADDED!");
                    break;
                }

            } else if (menu == 2) {

                System.out.println();
                System.out.println("*********** NEW GAME ***********");
                int x = (int) (Math.random() * words.size());
                int gamewordlength = words.get(x).length();
                String WordSpace = "";
                for (int m = 0; m < gamewordlength; m++) {
                    WordSpace += "_ ";
                }
                System.out.println();
                int rights = gamewordlength / 2;
                System.out.println(WordSpace);
                System.out.println("You have " + rights + " rights.");
                int CorrectLetter = 0;
                int letternum = 0;
                MyWord = words.get(x);
                while (rights > 0 && CorrectLetter != gamewordlength) {
                    int LetterCount = 0;
                    System.out.println();
                    System.out.print("Select one character: ");
                    String harf = scnr.next().toLowerCase();
                    letter[letternum] = harf;

                    letternum++;
                    int h;
                    for (h = 0; h < gamewordlength; h++) {
                        if (harf.equals(String.valueOf(words.get(x).charAt(h)))) {
                            String myword = "";
                            for (int t = 0; t < gamewordlength; t++) {
                                //Here I wrote t*2 to count both the letter and the space following it.
                                if (letternum >= 2 && Character.isLetter(MyWord.charAt(t * 2))) { 
                                    myword += (MyWord.charAt(t * 2)) + " ";
                                } else {
                                    if (harf.equals(String.valueOf(words.get(x).charAt(t)))) {
                                        myword += harf + " ";
                                        LetterCount++;
                                        CorrectLetter++;
                                    } else {
                                        myword += "_ ";
                                    }
                                }
                            }
                            if (LetterCount == 1) {
                                System.out.println("There is " + LetterCount + " '" + harf + "'.");
                            } else if (LetterCount == 0) {

                            } else {
                                System.out.println("There are " + LetterCount + " '" + harf + "'.");
                            }
                            System.out.println(myword);
                            MyWord = myword;
                            if (CorrectLetter == gamewordlength) {
                                System.out.println("You win!");
                                System.out.println("Your point is " + (rights * 10));
                                points.add(rights * 10);
                                break;
                            } else {
                                System.out.println("You have " + rights + " rights.");
                            }
                            break;
                        }
                        if (h == (gamewordlength - 1)) {
                            rights--;
                            if (CorrectLetter == 0) {
                                System.out.println("There is not '" + harf + "'.");
                                MyWord = WordSpace;
                                System.out.println(WordSpace);
                            } else {
                                if (LetterCount == 0) {
                                    System.out.println("There is not '" + harf + "'.");
                                    System.out.println(MyWord);
                                } else if (LetterCount == 1) {
                                    System.out.println("There is " + LetterCount + "'" + harf + "'.");
                                    System.out.println(MyWord);
                                } else {
                                    System.out.println("There are " + LetterCount + "'" + harf + "'.");
                                    System.out.println(MyWord);
                                }
                            }
                            if (rights == 0) {
                                System.out.println("Your rights are over. Correct word: " + words.get(x));
                                System.out.println("Your point is 0");
                                points.add(0);
                            } else {
                                System.out.println("You have " + rights + " rights.");
                                break;
                            }
                        }
                    }
                    if (letternum >= 2 && CorrectLetter != gamewordlength) {
                        for (int p = 0; p < letternum - 1; p++) {
                            if (harf.equals(letter[p])) {
                                System.out.println("You already wrote this letter.");
                                break;
                            }
                        }
                    }
                }

            } else if (menu == 3) {

                System.out.println();
                System.out.println("*********** SCORE LİST ***********");
                System.out.println("---------------------------");
                for (int y = 0; y < points.size(); y++) {
                    System.out.println((y + 1) + ". GAME:  " + points.get(y));
                    System.out.println("---------------------------");
                }

            } else if (menu == 4) {

                System.out.println();
                System.out.println("   THANK YOU FOR PLAYİNG THE GAME   ");
                System.exit(0);

            } else {
                System.out.println("Please enter a valid value.");
                continue;
            }
        }
    }
}
