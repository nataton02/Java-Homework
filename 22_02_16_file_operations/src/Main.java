import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOperations operations = new FileOperations();

        // 1.
        List<String> strings = Arrays.asList("Hello world!", "Hello!", "Hi world!", "World");
        operations.writeToFile(strings, "output.txt");

        // 2.
        System.out.println(operations.readFromFile("input.txt"));

        // 3.
        List<Integer> numbers = Arrays.asList(4, 15, -9);
        operations.writeNumbers(numbers, "output2.txt");

        // 4.
        System.out.println(operations.readNumbers("input2.txt"));

    }
}
