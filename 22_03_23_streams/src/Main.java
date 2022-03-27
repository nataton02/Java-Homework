import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {

        // 1. Написать функцию, которая определяет, является ли число простым (bolean isPrime(int number)).
        // Простое число, это такое целое число, большее 1, которое делится только на себя и 1.
        // Например, 2, 3, 5, 7, 11, 13, 17... Использовать стримы (подсказка: метод IntStream.range)

        System.out.println(isPrime(7));
        System.out.println(isPrime(10));


        // 2.
        IntStream stream1 = IntStream.of(1, 10, 6, 90, 15, 12);
        IntStream stream2 = IntStream.of(5, 45, 30, 60, 20, 9, 34);
        composeStream(stream1, stream2).forEach(System.out::println);//45, 60, 90


        // 3.
        System.out.println(factorial(1));//1
        System.out.println(factorial(3));//6
        System.out.println(factorial(5));//120

        // 4.
        System.out.println(sumOddNumbers(2, 3)); //3
        System.out.println(sumOddNumbers(2, 6)); //8

    }

    //1
    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        return IntStream.range(2, number)
                .noneMatch(x -> number % x == 0);
    }

    // 2. Есть 2 IntStream. Сделать третий стрим, который содержит числа из обоих стримов, делящиеся на 3 и на 5.
    // Стрим должен быть отсортирован, и два первых числа должны быть пропущены

    public static IntStream composeStream (IntStream stream1, IntStream stream2) {
        return IntStream.concat(stream1, stream2)
                .filter(x -> x % 3 == 0 && x % 5 == 0)
                .sorted()
                .skip(2);
    }

    // 3. Посчитать факториал (функция, которая принимает число и возвращает число).
    // Решить с помощью стримов (метод reduce)
    public static long factorial (int number) {
        return LongStream.rangeClosed(1, number)
                .reduce(1, (res, x) -> res * x);
    }

    // 4. Посчитать сумму нечетных числе от a до b

    public static long sumOddNumbers (int min, int max) {
        return LongStream.rangeClosed(min, max)
                .filter(x -> x % 2 != 0)
                .reduce(0, (res, x) -> res + x);
    }
}
