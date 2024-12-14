package org.fileanalyzer.gradlekursach;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Главный класс приложения, отвечающий за загрузку интерфейса JavaFX.
 */
public class MainApp extends Application {
    /**
     * Метод для запуска приложения.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fileanalyzer/gradlekursach/file_analyzer.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Анализатор файлов");
        primaryStage.setScene(new Scene(root, 1080, 920));
        primaryStage.show();
    }
    /**
     * Главный метод для запуска JavaFX-приложения.
     */
    public static void main(String[] args) {
        launch(args);
    }
}