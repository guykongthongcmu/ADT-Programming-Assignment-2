// 672115045 Virawit Kongthong ADT Programming Assignment 2

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Timer;

public class main2 {
    public static void main(String[] args) throws IOException{
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter file path:  ");
        String filePath = userInput.nextLine();
        File f = new File(filePath);
        Scanner readFile = new Scanner(f);
        String line = " ", word;
        int palindrome = 0, totalCharCount = 0, emoticons = 0, tokens = 0, longestTok = 0, tempLongestTok = 0, lines = 0;
        ArrayList<Integer> tokenSize = new ArrayList<Integer>();
        ArrayList<String> listOfEmoticons = new ArrayList<String>();

        listOfEmoticons.add(":(");
        listOfEmoticons.add(":)");
        listOfEmoticons.add(":D");
        listOfEmoticons.add(":P");
        listOfEmoticons.add(";)");
        listOfEmoticons.add(":O");
        listOfEmoticons.add(":3");
        listOfEmoticons.add(":|");
        listOfEmoticons.add("XD");
        listOfEmoticons.add("<3");


        Timer time = new Timer();
        long startTime = System.nanoTime();
        while (readFile.hasNextLine()) {
            line = readFile.nextLine();
            totalCharCount += line.length() ;
            lines++;
            StringTokenizer token = new StringTokenizer(line, " ");
            while (token.hasMoreTokens()) {
                word = token.nextToken();
                tokens++;
                if (isPalindrome(word)) {
                    palindrome++;
                }
                if (isEmoticon(listOfEmoticons, word)) {
                    emoticons++;
                }
                tokenSize.add(word.length());
                tempLongestTok = word.length();
                if (longestTok < tempLongestTok) {
                    longestTok = tempLongestTok;
                }
            }
        }
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        double second = totalTime / 1000.0;
        System.out.println("Total # Character Count: " + totalCharCount);
        System.out.println("Total # Palindrome found: " + palindrome);
        System.out.println("Total Number of Tokens: " + tokens);
        System.out.println("Total number of emoticons: " + emoticons);
        System.out.println("Total # of New Lines: " + lines);
        System.out.println("The longest token was " + longestTok + " The average token size is " + avgTokenSize(tokenSize));
        System.out.println("Total time to execute the program: " + second + " secs");
        System.out.println("Program terminated!");
        
        readFile.close();
        System.exit(0);
        
    }

    public static boolean isPalindrome(String word) {
        String temp = "";
        boolean isPal = false;

        for (int i = word.length(); i > 0; i--) {
            temp += word.charAt(i-1);
        }
        if (temp.equals(word)) {
            isPal = true;
            return isPal;
        } else {
            return isPal;
        }
    }

    public static double avgTokenSize(ArrayList<Integer> size) {
        double avg = 0;
        for (int i = 0; i < size.size(); i++) {
            avg += size.get(i);
        }
        avg /= size.size();
        return avg;
    }

    public static boolean isEmoticon(ArrayList<String> emoticon, String phrase) {
        boolean isEmoji = false;
        for (int i = 0; i < emoticon.size(); i++) {
            if ((emoticon.get(i)).equals(phrase)) {
                isEmoji = true;
            }
        }
        return isEmoji;
     }
}


