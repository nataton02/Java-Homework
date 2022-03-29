import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        // 1.Используя замыкание, написать Function<Double, Double>, которая считает ax^2 + bx + c

        int a = 5;
        int b = 3;
        int c = 10;
        Function<Double, Double> fc = (Double x) -> a * x * x + b * x + c;
        System.out.println(fc.apply(2.0));//36

        // 2. Есть класс Account, у него есть поля int id, double balance, bool isLocked.
        // Написать два лямбда выражения Function<List<Account>, List<Account>>,
        // 1. отфильтровывает аккаунты таким образом, что остаются только аккаунты с положительным баллансом;
        // 2. все незаблокированные аккаунты с балансом более 100000.

        List<Account> accounts = Arrays.asList(
                new Account(1, 20000, true),
                new Account(2, 500000, false),
                new Account(3, -5000, false),
                new Account(4, 150000, false),
                new Account(5, -200000, true),
                new Account(6, 300000, false));

        Function<List<Account>, List<Account>> positive = (List<Account> list) -> {
            List<Account> result = new ArrayList<>();
            for (Account acc : list) {
                if (acc.balance > 0)
                    result.add(acc);
            }
            return result;
        };

        Function<List<Account>, List<Account>> nonLocked = (List<Account> list) -> {
            List<Account> result = new ArrayList<>();
            for (Account acc : list) {
                if (!acc.isLocked && acc.balance > 100000)
                    result.add(acc);
            }
            return result;
        };

        System.out.println(positive.apply(accounts));
        System.out.println(nonLocked.apply(accounts));

        // 3. Написать интерфейс TernaryIntPredicate с методом bool test(int a, int b, int c).
        // Написать лямбда выражение, которое вернет true, если все аргументы различны.

        TernaryIntPredicate allDifferent = (a1, b1, c1) -> a1 != b1 && a1 != c1 && b1 != c1;
        System.out.println(allDifferent.test(3, 3, 10));//false

        // 4. Написать функцию, которая считает <2x> и функцию, которая считает <x + 3>.
        // Написать функцию, которая будет композицией первых двух.

        Function<Integer, Integer> f = x -> 2 * x;
        Function<Integer, Integer> g = x -> x + 3;
        Function<Integer, Integer> h = f.compose(g);
        System.out.println(h.apply(5));//16

        // 5. Написать класс PredicateService и методы в нем intersect и union, которые принимают лист предикатов,
        // а возвращают их пересечение и объединение соответственно. Протестировать

        PredicateService predicateService = new PredicateService();
        List<Predicate<Integer>> predicates = Arrays.asList(
                x -> x > 0,
                y -> y < 100,
                z -> z < 50
        );
        Predicate<Integer> pr1 = predicateService.intersect(predicates);
        Predicate<Integer> pr2 = predicateService.union(predicates);

        System.out.println(pr1.test(10));//true
        System.out.println(pr1.test(100));// false
        System.out.println(pr2.test(100));//true


        
    }
}

