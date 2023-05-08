package com.urise.webapp;

import java.io.File;
import java.io.IOException;

public class ListOfFilesInFolder {
    private final String fullFilePath;
    private final File dir;

    public static void main(String[] args) throws IOException {
        ListOfFilesInFolder files = new ListOfFilesInFolder(null);
        files.printFilesInDirectoryDeeply();
    }

    ListOfFilesInFolder(String filePath) throws IOException {
        dir = new File(filePath == null ? "." : filePath);
        this.fullFilePath = dir.getCanonicalPath();
        if (dir.isFile() || !dir.exists()) {
            throw new IOException("Path is not directory or does not exist");
        }
    }

    ListOfFilesInFolder() throws IOException {
        this(null);
    }

    private void printFilesInDirectoryDeeply() {
        System.out.println("The contents of directory " + fullFilePath);
        printFilesInDirectoryDeeply(dir, "");
    }

    private void printFilesInDirectoryDeeply(File dir, String padding) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(padding + "File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(padding + "Directory: " + file.getName());
                    printFilesInDirectoryDeeply(file, padding + " ");
                }
            }
        }
    }
}
