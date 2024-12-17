# FileAnalyzerJava
# RU
Приложение для анализа файловой системы на языке Java. Выполнено в ходе университетской курсовой работы.
## Особенности
- Анализ выбранного каталога с выведением размера в байтах, даты создания, владельца и названия каталогов, подкаталогов, файлов.
- Базовый графический интерфейс с использованием библиотеки JavaFX.
- Функционал логгирования, реализованный посредством библиотеки log4j (Логи выводятся в консоль и .log файл в том же каталоге, где была запущена программа).
- Реализована основная документация при помощи JavaDoc, приложена в соответствующей папке в структуре проекта.
## Информация
- Создано с использованием JDK 21 версии.
- .jar файл создан при помощи ShadowJar, уже содержит внутри все необходимые зависимости, при запуске не требуется указывать на компоненты JavaFX. Находится в /build/libs.
- Использован JavaFX версии 21.0.5 для Windows. Для запуска с других систем придется вручную указывать --module-path для JavaFX с --add-modules javafx.controls,javafx.fxml
# EN
An application for basic analysis of a file system created in Java programming language. Developed as part of a university course project.
## Features
- Analysis of a chosen directory, showing it's size in bytes, creation time, it's owner and names of directories, subdirectories and files in it.
- A basic GUI using JavaFX library.
- Logging realised through log4j library (logs are displayed in CLI and in a .log file that is created in the same directory where you launch an app).
- Basic documentation made with JavaDoc, located in the folder in project structure.
## Information
- Made using JDK version 21.
- .jar file was made using ShadowJar, so it already has the necessary dependencies, when launching you do not need to enter any VM options showing the path to JavaFX module. .jar file is located in /build/libs folder.
- Used JavaFX version 21.0.5 for Windows. To launch from other operating systems you need to manually enter --module-path to JavaFX and also type --add-modules javafx.controls,javafx.fxml 
