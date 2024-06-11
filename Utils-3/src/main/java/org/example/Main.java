package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to read:");
        String path = scanner.nextLine();

        File directory = new File(path);

        System.out.println("Enter the output file path:");
        String outputPath = scanner.nextLine();

        DirectoryReader.generateTxtFile(directory, outputPath);
    }
}
