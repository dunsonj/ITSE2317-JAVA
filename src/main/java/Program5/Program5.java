package Program5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

//***************************************************************
//  Developer:         <Jakira Dunson>
//
//  Program #:         <Program 5>
//
//  File Name:         <Program5.java>
//
//  Course:            ITSE 2317 Java Programming (Intermediate)
//
//  Due Date:          <Oct25, 2023>
//
//  Instructor:        Prof. Fred Kumi
//
//  Description:
//     <Lambdas and Streams>
//***************************************************************
public class Program5 {
    ArrayList<Invoice> invoices = new ArrayList<>();

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
        Program5 obj = new Program5();
        obj.developerInfo();
        obj.readFile();
        obj.partDescription();
        obj.pricePerItem();
        obj.quantMap();
        obj.priceMap();
        obj.selectInvoice();
        obj.wordChoice();
    }
    //***************************************************************
    //  Method: readFile
    //
    //  Description: Creates an object of the file, to read it
    //
    //  Parameters: None
    //
    //  Returns: N/A
    //**************************************************************
    public void readFile() {
        try {
            File myObj = new File("Invoice-Data.txt");
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] arr = data.split(",");

                invoices.add(new Invoice(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3])));
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //***************************************************************
    //  Method: partDescription
    //
    //  Description: Retrieves and Sort the descriptions by order
    //
    //  Parameters: None
    //
    //  Returns: N/A
    //**************************************************************
    public void partDescription() {
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .toList()
                .forEach(System.out::println);
        System.out.println("\n");
    }
    //***************************************************************
    //  Method: pricePerItem
    //
    //  Description: Retrieves and Sort the descriptions by price
    //
    //  Parameters: None
    //
    //  Returns: N/A
    //**************************************************************
    public void pricePerItem() {
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getPrice))
                .toList()
                .forEach(System.out::println);
        System.out.println("\n");

    }
    //***************************************************************
    //  Method: quantMap
    //
    //  Description: Retrieves and Sort the descriptions by quantity
    //
    //  Parameters: None
    //
    //  Returns: N/A
    //**************************************************************
    public void quantMap() {
        invoices.stream()
                .collect(Collectors.toMap(inv -> inv.getPartDescription(), inv -> inv.getQuantity()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEach(inv -> {
                    System.out.printf("Description: %-15s   Quantity: %d%n", inv.getKey(), inv.getValue());
                });
        System.out.println("\n");
    }
    //***************************************************************
    //  Method: priceMap
    //
    //  Description: Multiplies the quantity of the item times the price to receive the value of each item
    //
    //  Parameters: None
    //
    //  Returns: N/A
    //**************************************************************
    public void priceMap() {
        Map<String, Double> invoiceValueMap = invoices.stream()
                .collect(Collectors.toMap(Invoice::getPartDescription, inv -> inv.getQuantity() * inv.getPrice()));

        invoiceValueMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue())
                .forEach(entry -> {
                    System.out.printf("Description: %-15s  Invoice Value: %.2f%n", entry.getKey(), entry.getValue());
                });
        System.out.println("\n");
    }
    //***************************************************************
    //  Method: selectInvoice
    //
    //  Description: Will only display products within the values of $200 and $500
    //
    //  Parameters: None
    //
    //  Returns: N/A
    //**************************************************************
    public void selectInvoice() {
        Map<String, Double> invoiceValueMap = invoices.stream()
                .collect(Collectors.toMap(Invoice::getPartDescription, inv -> inv.getQuantity() * inv.getPrice()));

        invoiceValueMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue())
                .forEach(entry -> {
                    if (entry.getValue() >= 200.00 && entry.getValue() <= 500.00) {
                        System.out.printf("Description: %-15s  Invoice Value: %.2f%n", entry.getKey(), entry.getValue());
                    }
                });
        System.out.println("\n");
    }
    //***************************************************************
    //  Method: wordChoice
    //
    //  Description: Display any description that contians the word Saw
    //
    //  Parameters: None
    //
    //  Returns: N/A
    //**************************************************************
    public void wordChoice() {
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
//              .collect(Collectors.toMap(inv -> inv.getPartDescription()
                .filter(str -> str.getPartDescription().contains("Saw"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
                System.out.println("\n");

    }
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
        System.out.println("Program: Five \n");

    } // End of developerInfo
}



