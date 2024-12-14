package org.fileanalyzer.gradlekursach;

import java.util.List;
/**
 * Класс FileInfo позволяет получать сведения о файлах и каталогах.
 */
public class FileInfo {
    private final String name;
    private final long size;
    private final String creationDate;
    private final String owner;
    private final boolean isDirectory;
    private final List<FileInfo> children;
    /**
     * Метод для назначения аттрибутов по отношению к файлу
     * в виде его названия, размера, времени создания, владельца, является ли он каталогом,
     * его подкаталогов.
     */
    public FileInfo(String name, long size, String creationDate, String owner, boolean isDirectory, List<FileInfo> children) {
        this.name = name;
        this.size = size;
        this.creationDate = creationDate;
        this.owner = owner;
        this.isDirectory = isDirectory;
        this.children = children;
    }
    /**
     * Метод, возвращающий название файла/каталога.
     */
    public String getName() {
        return name;
    }
    /**
     * Метод, возвращающий размер файла/каталога.
     */
    public long getSize() {
        return size;
    }
    /**
     * Метод, возвращающий время создания файла/каталога
     * с форматированием даты под понятный формат.
     */
    public String getCreationTime() {
        return DateFormatter.format(creationDate);
    }
    /**
     * Метод, возвращающий владельца файла/каталога.
     */
    public String getOwner() {
        return owner;
    }
    /**
     * Метод, возвращающий то, является ли выбранный файл каталогом.
     */
    public boolean isDirectory() {
        return isDirectory;
    }
    /**
     * Метод, возвращающий подкаталоги.
     */
    public List<FileInfo> getChildren() {
        return children;
    }
}
