package org.fileanalyzer.gradlekursach;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
/**
 * Класс DateFormatter нужен для форматирования даты
 * в понятный формат.
 */
public class DateFormatter {
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * Метод возвращающий время переведенное из ISO формата в LocalDateTime формат.
     */
    public static String format(String inputDate) {
        try {
            LocalDateTime dateTime = LocalDateTime.ofInstant(
                    java.time.Instant.parse(inputDate),
                    ZoneId.systemDefault()
            );
            return dateTime.format(OUTPUT_FORMATTER);
        } catch (DateTimeParseException e) {
            return inputDate;
        }
    }

}
