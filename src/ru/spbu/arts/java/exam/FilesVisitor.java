package ru.spbu.arts.java.exam;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilesVisitor implements FileVisitor{

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) {
        System.out.println("Найдена директория : " + dir.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) {
        System.out.println("Найден файл: " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) {
        System.out.println("Найден файл с ошибкой: " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) {
        System.out.println("Найдена директория: " + dir.toString());
        return FileVisitResult.CONTINUE;
    }


    public List<Path> getAllFiles() {
        File dir = new File("C:\\Users\\79218\\OneDrive\\Документы\\example\\");
        List<Path> allFile = new ArrayList<>();
        for (File x : dir.listFiles())
            if (x.isFile())
                allFile.add(Path.of(x.getName()));
        return allFile;
    }

    public Map<String, List<Path>> getFilesByExtension() {
        File dir = new File("C:\\Users\\79218\\OneDrive\\Документы\\example\\");
        Map<String, List<Path>> allFileExp = new HashMap<>();
        for (File x : dir.listFiles()){
            if (x.isFile()){
                String exp = x.getName();
                String[] words = exp.split(".");
                allFileExp.put(words[words.length - 1], (List<Path>) Path.of(x.getName()));
            }
        }
        return allFileExp;
    }
}
