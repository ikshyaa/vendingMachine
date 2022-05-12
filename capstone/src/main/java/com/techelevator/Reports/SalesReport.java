package com.techelevator.Reports;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SalesReport {

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a");
    private static DateTimeFormatter dateFormatterForReportFile = DateTimeFormatter.ofPattern("MM.dd.yyyy");
    private static String dateTimeForReport = dateFormatterForReportFile.format(LocalDateTime.now());
    private static File salesReport = new File("salesReport_" + dateTimeForReport + ".csv");
    private static Map<String, Integer> displayReport = new TreeMap<>();


    public static void reportSale(String line) {
        String dateTimeStr = dateFormatter.format(LocalDateTime.now());
        try(FileWriter fileWriter = new FileWriter(salesReport, true);
            PrintWriter printWriter = new PrintWriter(fileWriter)
        ) {
            printWriter.println(dateTimeStr + "," + line);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void processReport() {
        double totalSales = 0;
        try(Scanner readingFile = new Scanner(salesReport);)
        {

            while(readingFile.hasNextLine())
            {
                String line = readingFile.nextLine();
                String[] lineArray = line.split(",");
                if(displayReport.containsKey(lineArray[2])) {
                    displayReport.put(lineArray[2], displayReport.get(lineArray[2]) +1);
                    totalSales += Double.parseDouble(lineArray[3]) ;
                }

                else {
                    totalSales += Double.parseDouble(lineArray[3]);
                    displayReport.put(lineArray[2], 1);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Hey that file doesn't exist! ");
        }

        for(String item: displayReport.keySet()) {
            System.out.println(item + ", "+ displayReport.get(item));
        }
        System.out.printf("\nTotal sales: $%.2f", totalSales);
    }
}
