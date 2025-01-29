// 672115045 Virawit Kongthong ADT Programming Assignment 2

import java.io.*;
import java.util.*;

public class main2 {
    public static void main(String[] args) throws IOException{
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter file path:  ");
        String filePath = userInput.nextLine();
        File f = new File(filePath);
        BufferedReader readFile = new BufferedReader(new FileReader(f));

        String line = "";
        int palindrome = 0, totalCharCount = 0, emoticons = 0, tokens = 0, longestTok = 0, lines = 0, tokenSize = 0;
        HashSet<String> listOfEmoticons = new HashSet<>();
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
        while ((line = readFile.readLine()) != null) {
            totalCharCount += line.length();
            lines++;
            String[] words = line.split("\\s+");
            for (String word : words) {
                tokens++;
                palindrome += isPalindrome(word);
                emoticons += isEmoticon(listOfEmoticons, word);
                tokenSize += word.length();
                longestTok = Math.max(longestTok, word.length());
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
        System.out.println("The longest token was " + longestTok + " The average token size is " + (tokenSize / tokens));
        System.out.println("Total time to execute the program: " + second + " secs");
        System.out.println("Program terminated!");
        
        readFile.close();
        System.exit(0);
        
    }

    public static int isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }

    public static int isEmoticon(HashSet<String> emoticon, String phrase) {
        return emoticon.contains(phrase) ? 1 : 0;
    }
}


