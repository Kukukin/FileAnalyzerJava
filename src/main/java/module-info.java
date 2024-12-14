module org.fileanalyzer.gradlekursach {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires org.controlsfx.controls;
    requires org.apache.logging.log4j;

    opens org.fileanalyzer.gradlekursach to javafx.fxml;
    exports org.fileanalyzer.gradlekursach;
}