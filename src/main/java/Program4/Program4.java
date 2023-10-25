package Program4;

//***************************************************************
//  Developer:         <Jakira Dunson>
//
//  Program #:         <Program 4>
//
//  File Name:         <Program3.java>
//
//  Course:            ITSE 2317 Java Programming (Intermediate)
//
//  Due Date:          <Oct 11, 2023>
//
//  Instructor:        Prof. Fred Kumi
//
//  Description:
//     <An explanation of what the program is designed to do>
//***************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Program4 {
    //***************************************************************
    //  Method:       main
    //
    //  Description:  The main method of the program
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A
    //**************************************************************

    public static void main(String[] args) {

        ArrayList<String> winningTeamsList = new ArrayList<>();

        HashMap<Integer, String> yearMap = new HashMap<>();

        HashMap<String, Integer> winsMap = new HashMap<>();

        String fileName = "Program4.txt";

        Program4 program4 = new Program4();
        program4.developerInfo();
        program4.readFile(fileName, winningTeamsList);
        program4.mapForWinInYears(winningTeamsList, yearMap);
        program4.mapForWinsPerTeam(winningTeamsList, winsMap);
        program4.displayOutput(program4, yearMap, winsMap);
    }

    //***************************************************************
    //  Method:       readFile

    //  Description: Reads a file and stores it as an array
    //
    //  Parameters:   source file, destination of the list of teams

    //  Returns:
    //**************************************************************
    private void readFile(String fileName, ArrayList<String> winningTeamsList) {

        try {
            Scanner scan = new Scanner(new File(fileName));

            while (scan.hasNextLine()) {
                winningTeamsList.add(scan.nextLine());
            }
            System.out.println("File read successful");

        } catch (FileNotFoundException e) {

            System.out.println("File read failed. Find the root cause below " + e.getMessage());
            e.printStackTrace();
        }
    }

    //***************************************************************
    //  Method:       mapForWinInYears

    //  Description:  Creates a hashmap, where the keys are the years. Each team has saved the amount they have won the world series.
    //
    //  Parameters:   list of teams, hashmap that stores the year and teams

    //  Returns:
    //**************************************************************

    private void mapForWinInYears(ArrayList<String> winningTeamsList, HashMap<Integer, String> yearMap) {

        ArrayList<Integer> matchNotHeldYears = new ArrayList<>();
        matchNotHeldYears.add(1904);
        matchNotHeldYears.add(1994);

        Integer year = 1904;

        for (String team : winningTeamsList) {

            while (matchNotHeldYears.contains(year)) {
                year++;
            }

            yearMap.put(year, team);

            year++;
        }
    }

    //***************************************************************
    //  Method:       mapForWinsPerTeam

    //  Description:  Creates a hashmap, where the keys are the names of the teams. Each team has saved the amount they have won the world series.
    //
    //  Parameters:   list of teams, hashmap that stores the number of wins.

    //  Returns:
    //**************************************************************

    private void mapForWinsPerTeam(ArrayList<String> winningTeamsList, HashMap<String, Integer> winsMap) {

        for (String team : winningTeamsList) {

            if (!winsMap.containsKey(team)) {
                winsMap.put(team, 1);
            } else {
                winsMap.put(team, winsMap.get(team) + 1);
            }
        }

    }

    //***************************************************************
    //  Method:       collectInput

    //  Description:  Collects the user input for the year
    //
    //  Parameters:

    //  Returns:      int year
    //**************************************************************
    private int collectInput() {
        Scanner in = new Scanner(System.in);
        int year;
        System.out.print("Please enter an year between 1904 and 2022: ");
        year = in.nextInt();

        while (year != 0 && (year < 1904 || year > 2022)) {

            System.out.print("Incorrect year!! Try again: ");
            year = in.nextInt();
        }
        return year;
    }

    //***************************************************************
    //  Method:       displayOutput

    //  Description:  Year is inputted and the winning team will be displayed, 0 ends the program.
    //
    //  Parameters:   text file, year and the Hashmap of the years, the hashmap of the winning teams

    //  Returns:
    //**************************************************************
    private void displayOutput(Program4 program4, HashMap<Integer, String> yearMap, HashMap<String, Integer> winsMap) {

        while (true) {

            int year = collectInput();

            if (year == 0) {
                System.out.println("Thank you!!!");
                return;
            }

            String winningTeam = program4.getWinningTeamForYear(year, yearMap);

            if (winningTeam != null) {

                int numOfWins = program4.getNumberOfWins(winningTeam, winsMap);

                System.out.println("The winning for the Year " + year + " is: " + winningTeam);
                System.out.println("Number of Wins secured by team: " + winningTeam + " is " + numOfWins);
            }
        }
    }

    //***************************************************************
    //  Method:       getWinningTeamForYear

    //  Description:  Gets the total of the wins for each team
    //
    //  Parameters:   year and the Hashmap of the years

    //  Returns:      String winning team name
    //**************************************************************

    private String getWinningTeamForYear(int year, HashMap<Integer, String> yearMap) {

        if (!yearMap.containsKey(year)) {

            System.out.println("Match not held in year " + year);
            return null;
        }
        return yearMap.get(year);
    }

    //***************************************************************
    //  Method:       getNumberOfWins

    //  Description:  Gets the total of the wins for each team
    //
    //  Parameters:   String of winning team and the Hashmap of the amount of wins

    //  Returns:      int, the amount of wins secured by the team
    //**************************************************************

    private int getNumberOfWins(String winningTeam, HashMap<String, Integer> winsMap) {
        return winsMap.get(winningTeam);
    }

    //***************************************************************
    //
    //  Method:       developerInfo
    //
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      n/a
    //
    //**************************************************************
    public void developerInfo()
    {
        System.out.println("Name:    Jakira Dunson");
        System.out.println("Course:   ITSE 2317 Java Programming (Intermediate)");
        System.out.println("Program: Four \n");

    } // End of developerInfo
}