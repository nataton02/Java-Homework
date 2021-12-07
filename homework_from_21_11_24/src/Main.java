public class Main {

    public static void main(String[] args) {
	/* 1. Написать метод, который принимает строку, а возвразает boolean - является ли строка палиндромом
	    (игнорируя регистр). Пример: Алла. "А роза упала на лапу Азора" - не палиндром в рамках указанной задачи.
	     Пробелы не игнорируются. (Использовать метод с урока по развороту строки)
        2. (*) Дана строка, состоящая только из слов и пробелов, и число N. Вернуть новую строку максимальной длины,
        состоящую из начала исходной строки, содержащую ТОЛЬКО слова целиком, при этом длины не больше чем N.
        Пример: (Hello world guys, 8 ) -> Hello. (Hello world guys, 12 ) -> Hello world. (Hello world guys, 16+ ) ->
        Hello world guys.
        3. Написать метод, который принимает строку и паттерн, и возвращает количество вхождений паттерна в строку.
        Пример: ("Hello world", "l") -> 3 */

        String string = "Алла";
        String newString = reverse(string);
        String string2 = "Hello world";

        System.out.println(newString); // аллА
        System.out.println(isPalindrome(newString)); // true
        System.out.println(countPattern(string2, "l")); // 3


    }

    /* 1. Написать метод, который принимает строку, а возвразает boolean - является ли строка палиндромом
	    (игнорируя регистр). Пример: Алла. "А роза упала на лапу Азора" - не палиндром в рамках указанной задачи.
	     Пробелы не игнорируются. (Использовать метод с урока по развороту строки) */

    static String reverse(String str) {
        char[] chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(chars.length - 1 - i);
        }
        return new String(chars);
    }

    static boolean isPalindrome(String str) {
        String newString = reverse(str);
        if(str.equalsIgnoreCase(newString))
            return true;
        return false;
    }

    /* 3. Написать метод, который принимает строку и паттерн, и возвращает количество вхождений паттерна в строку.
        Пример: ("Hello world", "l") -> 3 */

    static int countPattern(String str1, String pattern) {
        int count = 0;
        int index = 0;
        while(index < str1.length()) {
            index = str1.indexOf(pattern, index);
            if(index == -1)
                break;
            index++;
            count++;
        }
        return count;
    }

    /*2. (*) Дана строка, состоящая только из слов и пробелов, и число N. Вернуть новую строку максимальной длины,
        состоящую из начала исходной строки, содержащую ТОЛЬКО слова целиком, при этом длины не больше чем N.
        Пример: (Hello world guys, 8 ) -> Hello. (Hello world guys, 12 ) -> Hello world. (Hello world guys, 16+ ) ->
        Hello world guys. */

    static String cutString(String str, int n) {
        if (n >= str.length())
            return str;

        String cut = str.substring(0, n + 1);

        int lastSpaceIndex = cut.lastIndexOf(" ");
        if (lastSpaceIndex < 0)
            return "";

        return cut.substring(0, lastSpaceIndex);
    }
}
