package co.hotwax.netsuite.helper;
import java.util.*;
import java.util.stream.Collectors;

public class CsvHelper {
    /**
     * Formats a list of headers from camelCase or PascalCase to readable headers.
     *
     * @param headers A list of header names in camelCase or PascalCase.
     * @return A list of formatted header names.
     */
    public static List<String> formatHeaders(List<String> headers) {
        return headers.stream()
                .map(CsvHelper::splitCamelCase)
                .collect(Collectors.toList());
    }

    /**
     * Splits camelCase or PascalCase into readable words.
     *
     * @param header The header name in camelCase or PascalCase.
     * @return A formatted header with words separated by spaces.
     */
    private static String splitCamelCase(String header) {
        String result = header.replaceAll("([a-z])([A-Z])", "$1 $2");
        return capitalizeWords(result.trim());
    }

    /**
     * Capitalizes the first letter of each word in a string.
     *
     * @param input The string to capitalize.
     * @return The capitalized string.
     */
    private static String capitalizeWords(String input) {
        return Arrays.stream(input.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}
