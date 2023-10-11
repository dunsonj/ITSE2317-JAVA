package Program3;

//***************************************************************
//
//  Developer:         <Jakira Dunson>
//
//  Program #:         <Program 3>
//
//  File Name:         <Program3.java>
//
//  Course:            ITSE 2317 Java Programming (Intermediate)
//
//  Due Date:          <Sept 30, 2023>
//
//  Instructor:        Prof. Fred Kumi
//
//  Description:
//     <An explanation of what the program is designed to do>
//
//***************************************************************

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program3
{
    //***************************************************************
    //
    //  Method:       main
    //
    //  Description:  The main method of the program
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void main(String[] args)
    {
        // Call the developer information method
        Program3 obj = new Program3();
        obj.developerInfo();
        obj.run();

    }

    //***************************************************************
    //
    //  Method:      void
    //
    //  Description:  Runs the program
    //
    //  Parameters:
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void run(){
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Enter a sentence (or 'No' to exit): ");
            input = scanner.nextLine().toLowerCase(); // Convert to lowercase

            if (!input.equalsIgnoreCase("no")) {
                Map<String, Integer> wordCountMap = countDuplicateWords(input);
                //This generates a map of words(strings) and their corresponding counts(integers)
                //which is later stored in the wordMapCount

                System.out.println("Duplicate Characters:");
                for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                    //This is a for-each loop that iterates through the entries of the wordCountMap.
                    // It uses a loop variable entry of type Map.Entry<String, Integer>, which represents a key-value pair
                    // (a word and its count) in the map.
                    //The wordCountMap.entrySet() method returns a set of map entries that can be iterated through.
                    if (entry.getValue() > 1) {
                        //if (entry.getValue() > 1): This line is an if statement that checks whether the integer value
                        // associated with the current entry (entry.getValue()) is greater than 1.
                        // This condition is checking if the count of the word is greater than 1,
                        // which implies that the word is duplicated.
                        System.out.println(entry.getKey() + " (Count: " + entry.getValue() + ")");
                    }
                }

            }

        } while (!input.equalsIgnoreCase("No") && !input.equalsIgnoreCase("no"));

        scanner.close();
    }


    //***************************************************************
    //
    //  Method:       countDuplicateWords {

    //  Description:  Counts the words repetition of the sentence.
    //
    //  Parameters:   String inputs
    //
    //  Returns:      Map of String integers
    //
    //**************************************************************
    public Map<String, Integer> countDuplicateWords(String input) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll("\\p{IsPunctuation}", "");
            //This removes punctuation from the sentence when it runs
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    //takes a string input, tokenizes it into words, removes punctuation from each word,
    // and counts the occurrences of each word, storing the results in a map.
    // It's a common operation used for text analysis and word frequency counting.

    //***************************************************************
    //
    //  Method:       developerInfo
    //
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void developerInfo()
    {
        System.out.println("Name:    Jakira Dunson");
        System.out.println("Course:   ITSE 2317 Java Programming (Intermediate)");
        System.out.println("Program: Three \n");

    } // End of developerInfo
}