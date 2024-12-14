package org.fileanalyzer.gradlekursach;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс FileSystemAnalyzer создан для анализа выбранного каталога
 * и его подкаталогов.
 */
public class FileSystemAnalyzer {
    /**
     * Метод для получения данных о каталоге и его подкаталогах
     * под данными подразумевается название, размер, время создания
     * владелец и то, является ли выбранный объект файлом или каталогом,
     * если каталогом, то получаются его подкаталоги.
     */
    public FileInfo analyzeDirectory(Path directory) throws IOException {
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException("Указанный путь не является каталогом: " + directory);
        }

        long totalSize = 0;
        List<FileInfo> children = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path entry : stream) {
                BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                long size = attrs.isDirectory() ? calculateDirectorySize(entry) : Files.size(entry);

                FileInfo childInfo = new FileInfo(
                        entry.getFileName().toString(),
                        size,
                        attrs.creationTime().toString(),
                        Files.getOwner(entry).getName(),
                        attrs.isDirectory(),
                        null
                );

                totalSize += size;
                children.add(childInfo);
            }
        }

        return new FileInfo(
                directory.getFileName().toString(),
                totalSize,
                Files.readAttributes(directory, BasicFileAttributes.class).creationTime().toString(),
                Files.getOwner(directory).getName(),
                true,
                children
        );
    }
    /**
     * Метод для подсчета размера каталога с учетом его содержимого.
     */
    private long calculateDirectorySize(Path directory) throws IOException {
        long size = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    size += calculateDirectorySize(entry);
                } else {
                    size += Files.size(entry);
                }
            }
        }
        return size;
    }
}