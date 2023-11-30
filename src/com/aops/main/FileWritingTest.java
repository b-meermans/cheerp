package com.aops.main;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileWritingTest {
    public static void addTimeStamp(String fileName) {

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String time = "Timestamp: " + currentTime.format(formatter);


        String filePath = "/text/" + fileName;
        Path buildFilePath = Paths.get("build", filePath);

        try {
            // Create the build directory if it doesn't exist
            Files.createDirectories(buildFilePath.getParent());

            // Use FileWriter to write to the file in the build directory
            try (FileWriter fileWriter = new FileWriter(buildFilePath.toFile())) {
                fileWriter.write(time);
                fileWriter.close();
            }

            System.out.println("Text written to the file in the build directory successfully.");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
}
