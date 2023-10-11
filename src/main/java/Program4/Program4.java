package Program4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Program4 {

    public static void main(String[] args) {

        ArrayList<String> winningTeamsList = new ArrayList<>();
        // Array list to store winning teams from 1903 to 2022.
        HashMap<Integer, String> yearMap = new HashMap<>();
        // hashmap to store year and winners.
        HashMap<String, Integer> winsMap = new HashMap<>();
        // hashmap to store winners and number of wins.
        String fileName = "Program4.txt";
        // file name where the data is stored.
        // You can also use full path of file Ex. E:\\InputFiles\\Program4.txt (\\ delimiter slash indicating \)
        Program4 program4 = new Program4(); // Instantiate the class Program4
        program4.readFile(fileName, winningTeamsList); // non static method to read the input file.
        program4.mapForWinInYears(winningTeamsList, yearMap); // non static method to process year and winners.
        program4.mapForWinsPerTeam(winningTeamsList, winsMap); // non static method to process winners and number of wins.
        program4.displayOutput(program4, yearMap, winsMap); // non static method to collect user input and display output.
    }

    /*
    readFile - method to read the input file and store the values in an array list
    @param fileName - source file
    @param winningTeamsList - destination list of teams
     */
    private void readFile(String fileName, ArrayList<String> winningTeamsList) {
        // read the file using Scanner object inside try block to handle FileNotFoundException

        try {
            Scanner scan = new Scanner(new File(fileName));

            while (scan.hasNextLine()) {
                // if the file has a line, read it
                // store the name in the list for future processing.

                winningTeamsList.add(scan.nextLine());
            }
            // display message on successful completion of the read operation
            System.out.println("File read successful");


        } catch (FileNotFoundException e) {
            // display the error message occurred while reading file.
            System.out.println("File read failed. Find the root cause below " + e.getMessage());
            e.printStackTrace();
        }
    }

    /*
    mapForWinInYears - method to creates a HashMap in which the keys are the years
    and each key's associated value is the name of the team that won that year
    @param winningTeamsList - list of teams
    @param yearMap - map which stores year and team
     */


    private void mapForWinInYears(ArrayList<String> winningTeamsList, HashMap<Integer, String> yearMap) {
        // add Years when the match is not held to exclude from the HashMap.
        ArrayList<Integer> matchNotHeldYears = new ArrayList<>();
        matchNotHeldYears.add(1904);
        matchNotHeldYears.add(1994);

        Integer year = 1903;

        // initialize start year
        // for each team in the winning list
        for (String team : winningTeamsList) {
            // if the year is present in the excluded list of years.. add one year and verify again..
            while (matchNotHeldYears.contains(year)) {
                year++;
            }
            // start inserting into the hash map
            yearMap.put(year, team);
            // add one year
            year++;
        }
    }

    /*
    mapForWinsPerTeam - method to creates a HashMap in which the keys are the names of the teams
    and each key's associated value is the number of times the team has won the World Series.
    @param winningTeamsList - list of teams
    @param winsMap - map which stores team and number of wins
     */


    private void mapForWinsPerTeam(ArrayList<String> winningTeamsList, HashMap<String, Integer> winsMap) {
        // for each team in the winning list
        for (String team : winningTeamsList) {
            // if the team is new to win map
            if (!winsMap.containsKey(team)) {
                winsMap.put(team, 1);
                // add the team with number of wins 1
            } else {
                // if the team is already in the wins map
                winsMap.put(team, winsMap.get(team) + 1);
                // get the number of wins of the team and add 1 to it.
            }
        }

    }

    /*
    collectInput - method to collect user input for the year.
     */
    private int collectInput() {
        Scanner in = new Scanner(System.in); // Scanner object to read user input.
        int year; // declare year
        System.out.print("Please enter an year between 1903 and 2022: ");
        year = in.nextInt(); // collect the user input
        // check the year is either 0(sentinel value) or within range 1903 and 2022.
        while (year != 0 && (year < 1903 || year > 2022)) {
            // otherwise collect a valid year.
            System.out.print("Incorrect year!! Try again: ");
            year = in.nextInt();
        }
        return year; // return the year.
    }

    /*
    displayOutput - method gets the user input and displays the output.
    @param program4 - class instance
    @param yearMap - map which stores year and team
    @param winsMap - map which stores team and number of wins
     */
    private void displayOutput(Program4 program4, HashMap<Integer, String> yearMap, HashMap<String, Integer> winsMap) {
        // loop the input until sentinel value is entered
        while (true) {
            // call the method to collect input from user
            int year = collectInput();
            // validate for sentinel value
            if (year == 0) {
                System.out.println("Thank you!!!");
                return; // end program
            }
            // get the winning team for the given year.
            String winningTeam = program4.getWinningTeamForYear(year, yearMap);

            // if there is winning team for the given year..
            if (winningTeam != null) {
                // get the number of wins of that team between 1903 and 2022.
                int numOfWins = program4.getNumberOfWins(winningTeam, winsMap);
                // display the winning team and number of wins.
                System.out.println("The winning for the Year " + year + " is: " + winningTeam);
                System.out.println("Number of Wins secured by team: " + winningTeam + " is " + numOfWins);
            }
        }
    }

    // pass the year and get the winning team
    private String getWinningTeamForYear(int year, HashMap<Integer, String> yearMap) {
        // if there is an entry for the given year.. to validate excluded years
        if (!yearMap.containsKey(year)) { // if not
            // display the message and return null.
            System.out.println("Match not held in year " + year);
            return null;
        }
        return yearMap.get(year); // return the winning team
    }

    // pass the team name in the hashmap and get the number of wins
    private int getNumberOfWins(String winningTeam, HashMap<String, Integer> winsMap) {
        return winsMap.get(winningTeam);
    }

}