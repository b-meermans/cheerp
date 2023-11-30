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
        
        URL resourceUrl = FileWritingTest.class.getClassLoader().getResource(filePath);

        if (resourceUrl == null) {
            System.out.println("Resource not found: " + filePath);
            return;
        }

        // Convert the URL to a Path
        Path resourcePath;
        try {
            resourcePath = Paths.get(resourceUrl.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        // Create a path for the file in the build directory

        try {
            // Create the build directory if it doesn't exist
            Files.createDirectories(resourcePath.getParent());

            // Use FileWriter to write to the file in the build directory
            try (FileWriter fileWriter = new FileWriter(resourcePath.toFile())) {
                fileWriter.write(time);
            }

            System.out.println("Text written to the file in the build directory successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
}
