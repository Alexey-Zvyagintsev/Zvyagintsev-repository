package ru.sberbank.jd.repository;

/**
 * Создание HTML страницы для JSON.
 */

public class CreateHtmlOutput {

    /**
     * Метод для создания структуры html страницы.
     *
     * @param json для вывода
     * @return код страницы
     */
    public static String createHtml(String json) {

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<meta charset = \"UTF-8\">");
        sb.append("<title>module09</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append(json);
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
}
