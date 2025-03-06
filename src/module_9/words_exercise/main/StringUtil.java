package module_9.words_exercise.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;


public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (sample == null || words == null || words.length == 0) {
            return 0;
        }

        sample = sample.trim().toLowerCase();
        int count = 0;

        for (String word : words) {
            if (word.trim().toLowerCase().equals(sample)) {
                count++;
            }
        }

        return count;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        String[] strings = text.split("[,.;: ?!]+");
        if (strings.length == 0 || (strings.length == 1 && strings[0].trim().isEmpty())) {
            return null;
        }

        List<String> filteredList = new ArrayList<>();
        for (String s : strings) {
            if (!s.isEmpty()) {
                filteredList.add(s.trim());
            }
        }

        return filteredList.isEmpty() ? null : filteredList.toArray(new String[0]);
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        StringJoiner filteredList = new StringJoiner(", ", "[", "]");
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                filteredList.add(word);
                count++;
            }
        }

        if (count == 0) {
            return null;
        }

        return filteredList.toString();
    }

    // Масив регулярних виразів для перевірки некоректних шляхів
    private static final Pattern[] ERROR_PATTERNS = {
            Pattern.compile("(?=(?:.*~){2,}).*$"), // Два або більше символів ~ у шляху
            Pattern.compile("|(?=.*~)^(?!~).+$"),  // ~ використовується не на початку
            Pattern.compile("|(?=.*~)(?=.*\\\\).+$"), // ~ використовується разом із \
            Pattern.compile("|(?=(?:.*[Cc]:){2,}).*$"), // Два або більше C: у шляху
            Pattern.compile("|(?=.*[Cc]:)^(?![Cc]:).+$"), // C: використовується не на початку
            Pattern.compile("|(?=.*[Cc]:)(?=.*/).*$"), // C: використовується разом із /
            Pattern.compile("|(?=.*\\\\)(?=.*/).*$"), // \ використовується разом із /
    };

    // Метод для конвертації Unix-шляху у Windows-шлях
    private static String convertToWindowsPath(String path) {
        switch (path) {
            case "~":
                return "C:\\User"; // Домашній каталог Unix → Windows
            case ".":
                return "."; // Поточний каталог
            case "..":
                return ".."; // Батьківський каталог
            case "/":
                return "C:\\"; // Корінь Unix → диск C:
        }

        // Замінюємо всі / на \
        String winPath = path.replace("/", "\\");

        // Якщо шлях починається з ~, змінюємо його на C:\User
        if (winPath.startsWith("~\\")) {
            return "C:\\User" + winPath.substring(1);
        }

        // Якщо шлях починається з \, додаємо диск C:
        if (winPath.startsWith("\\")) {
            return "C:\\" + winPath.substring(1);
        }

        return winPath;
    }

    // Метод для конвертації Windows-шляху у Unix-шлях
    private static String convertToUnixPath(String path) {
        switch (path) {
            case "C:\\User":
                return "~"; // Домашній каталог Windows → Unix
            case ".":
                return ".";
            case "..":
                return "..";
            case "C:\\":
                return "/"; // Диск C: → корінь Unix
        }

        // Замінюємо всі \ на /
        String unixPath = path.replace("\\", "/");

        // Якщо шлях починається з C:/User, змінюємо його на ~
        if (unixPath.startsWith("C:/User")) {
            return "~" + unixPath.substring(7);
        }

        // Якщо шлях починається з C:/, змінюємо його на /
        if (unixPath.startsWith("C:/")) {
            return "/" + unixPath.substring(3);
        }

        return unixPath;
    }

    // Основний метод для виклику конвертації (з рекурсією)
    public static String convertPath(String path, boolean toWin) {
        return convertPath(path, toWin, 0);
    }

    // Рекурсивний метод для перевірки помилкових шляхів перед конвертацією
    private static String convertPath(String path, boolean toWin, int currentIndex) {
        if (path == null || path.isEmpty()) {
            return null; // Якщо шлях порожній або null, повертаємо null
        }

        // Якщо перевірили всі патерни і помилок немає, виконуємо конвертацію
        if (currentIndex >= ERROR_PATTERNS.length) {
            return toWin ? convertToWindowsPath(path) : convertToUnixPath(path);
        }

        // Якщо шлях містить помилковий патерн, повертаємо null
        if (ERROR_PATTERNS[currentIndex].matcher(path).matches()) {
            return null;
        } else {
            return convertPath(path, toWin, currentIndex + 1); // Переходимо до наступної перевірки
        }
    }


    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);


    }
}