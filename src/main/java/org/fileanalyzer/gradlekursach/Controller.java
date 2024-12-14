package org.fileanalyzer.gradlekursach;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.DirectoryChooser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
/**
 * Контроллер для управления интерфейсом приложения,
 * отвечает за взаимодействие с пользователем.
 */
public class Controller {
    /**
     * Логгер для записи событий, возникших при работе
     * приложения.
     */
    private static final Logger logger = LogManager.getLogger(Controller.class);
    /**
     * Метод для возможности просмотра содержимого
     * каталогов в виде "дерева" с узлами.
     */
    @FXML
    private TreeView<String> fileTreeView;
    /**
     * Позволяет пользователю выбрать каталог для анализа.
     */
    @FXML
    public void onChooseDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Выберите каталог для анализа");

        File rootDirectory = directoryChooser.showDialog(fileTreeView.getScene().getWindow());
        if (rootDirectory != null) {
            logger.info("Folder chosen: {}", rootDirectory.getAbsolutePath());
            TreeItem<String> rootItem = createNodeForDirectory(rootDirectory);
            fileTreeView.setRoot(rootItem);
        } else {
            logger.warn("Каталог не был выбран пользователем.");
        }
    }

    /**
     * Создает узел для указанного каталога.
     */
    private TreeItem<String> createNodeForDirectory(File directory) {
        FileSystemAnalyzer analyzer = new FileSystemAnalyzer();
        TreeItem<String> directoryNode;

        try {
            FileInfo directoryInfo = analyzer.analyzeDirectory(directory.toPath());
            logger.info("Folder analysis: {}", directory.getAbsolutePath());

            String rootLabel = String.format("%s (Каталог, %d байт, %s дата создания, %s владелец)",
                    directoryInfo.getName(), directoryInfo.getSize(), directoryInfo.getCreationTime(), directoryInfo.getOwner());
            directoryNode = new TreeItem<>(rootLabel);

            for (FileInfo child : directoryInfo.getChildren()) {
                if (child.isDirectory()) {
                    logger.debug("Adding subfolder: {}", child.getName());
                    directoryNode.getChildren().add(createNodeForDirectory(new File(directory, child.getName())));
                } else {
                    logger.debug("Adding file: {}", child.getName());
                    String fileLabel = String.format("%s (Файл, %d байт, %s дата создания, %s владелец)",
                            child.getName(), child.getSize(), child.getCreationTime(), directoryInfo.getOwner());
                    directoryNode.getChildren().add(new TreeItem<>(fileLabel));
                }
            }
        } catch (IOException e) {
            logger.error("Error while analyzing folder: {}", directory.getAbsolutePath(), e);
            String errorLabel = String.format("Error while reading: %s", directory.getName());
            directoryNode = new TreeItem<>(errorLabel);
        }

        return directoryNode;
    }
}
