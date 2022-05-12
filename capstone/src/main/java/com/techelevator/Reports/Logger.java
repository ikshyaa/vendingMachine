package com.techelevator.Reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Logger {
    //private static String line;
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a");
    private static File auditFile = new File("auditFile.txt");

    public static void writeAudit(String line) {
        String dateTimeStr = dateFormatter.format(LocalDateTime.now());
        try(FileWriter fileWriter = new FileWriter(auditFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter)
        ) {
            printWriter.println(dateTimeStr + " " + line);
        }
        catch(IOException e) {

        }
    }


}
