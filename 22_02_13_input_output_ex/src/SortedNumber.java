import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
Задача №112396. Сортировка чисел из файла
Напишите программу, которая сортирует натуральные числа, записанные в файле input.txt , по возрастанию
последней цифры десятичной записи. Числа, у которых одинаковые последние цифры, должны располагаться в том же порядке,
в котором они были в исходном файле. Количество чисел неизвестно, гарантируется, что оно меньше 10000.
Отсортированные числа нужно записать в файл output.txt .
 */

public class SortedNumber {
    public static void main(String[] args) {

        Set<Integer> numbers = new TreeSet<>(new ComparatorInteger());

        try {
            FileReader file = new FileReader("input.txt");
            BufferedReader input = new BufferedReader(file);
            Scanner scan = new Scanner(input);

            while(scan.hasNext()) {
                numbers.add(scan.nextInt());
            }

            PrintWriter output = new PrintWriter("output.txt");
            for (int i : numbers) {
                output.printf("%d %n", i);
            }

            output.close();
            input.close();
            scan.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}
