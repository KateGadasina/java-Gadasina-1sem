package ru.spbu.arts.java.exam;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FilesCollector{
    public static void main(String[] args) throws IOException {
        Path file = Path.of("C:\\Users\\79218\\OneDrive\\Документы\\example");
        FilesVisitor fc = new FilesVisitor();
        Files.walkFileTree(file, fc);

        List<Path> allFiles = fc.getAllFiles();
        System.out.println(allFiles);

        Map<String, List<Path>> allFilesByExtension = fc.getFilesByExtension();
        System.out.println(allFilesByExtension);
    }

}
