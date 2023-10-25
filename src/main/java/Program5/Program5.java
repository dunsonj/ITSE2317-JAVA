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
        obj.readFile();
//        obj.invoices.stream().forEach(System.out::println);
//        for (Invoice inv : obj.invoices) {
//            System.out.println(inv);
//        }
//        Syst
        obj.partDescription();
        obj.pricePerItem();
        obj.quantMap();
        obj.priceMap();
        obj.selectInvoice();
    }

    //***************************************************************
    //  Method:
    //
    //  Description:
    //
    //  Parameters:
    //
    //  Returns:
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
    //  Method:
    //
    //  Description:
    //
    //  Parameters:
    //
    //  Returns:
    //**************************************************************
    public void partDescription(){
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .toList()
                .forEach(System.out::println);
    }

    //***************************************************************
    //  Method:
    //
    //  Description:
    //
    //  Parameters:
    //
    //  Returns:
    //**************************************************************
    public void pricePerItem(){
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getPrice))
                .toList()
                .forEach(System.out::println);

    }
    //***************************************************************
    //  Method:
    //
    //  Description:
    //
    //  Parameters:
    //
    //  Returns:
    //**************************************************************
    public void quantMap() {
        invoices.stream()
                .collect(Collectors.toMap(inv -> inv.getPartDescription(), inv -> inv.getQuantity()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEach(inv -> {System.out.printf("Desc: %-15s   Quant: %d%n", inv.getKey(), inv.getValue());});
    }

    //***************************************************************
    //  Method:
    //
    //  Description:
    //
    //  Parameters:
    //
    //  Returns:
    //**************************************************************
    public void priceMap() {
        Map<String, Double> invoiceValueMap = invoices.stream()
                .collect(Collectors.toMap(Invoice::getPartDescription, inv -> inv.getQuantity() * inv.getPrice()));

        invoiceValueMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue())
                .forEach(entry -> {
                    System.out.printf("Desc: %-15s   Value: %.2f%n", entry.getKey(), entry.getValue());
                });
    }

    public void selectInvoice() {
        Map<String, Double> invoiceValueMap = invoices.stream()
                .collect(Collectors.toMap(Invoice::getPartDescription, inv -> inv.getQuantity() * inv.getPrice()));

        invoiceValueMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue())
                .forEach(entry -> {

                    if (value >= 200.00 && <= 500.00){
                    System.out.printf("Desc: %-15s   Value: %.2f%n", entry.getKey(), entry.getValue());
                }});
    }

}



