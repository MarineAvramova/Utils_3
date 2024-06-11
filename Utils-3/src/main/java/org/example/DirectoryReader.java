package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryReader {
    public static void readFolders(File root) {
        File[] files = root.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No elements in the current folder");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (File file : files) {
                if (file.isDirectory()) {
                    readFolders(file);
                }
            }
        }
    }

    public static void generateTxtFile(File root, String outputPath) {
        try {
            FileWriter writer = new FileWriter(outputPath);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            writeToFile(root, writer, sdf);

            writer.close();
            System.out.println("File has been generated: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(File root, FileWriter writer, SimpleDateFormat sdf) throws IOException {
        File[] files = root.listFiles();
        if (files != null) {
            Arrays.sort(files, Comparator.comparing(File::getName));
            for (File file : files) {
                writer.write(String.format("%s (%s) - %s%n",
                        file.getAbsolutePath(),
                        file.isDirectory() ? "D" : "F",
                        sdf.format(file.lastModified())));

                if (file.isDirectory()) {
                    writeToFile(file, writer, sdf);
                }
            }
        }
    }
}
