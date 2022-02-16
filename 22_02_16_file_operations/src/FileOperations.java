import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    /**
     * Writes the strings into the file, one string as one line
     * @param strings
     * @param filename
     */
    public void writeToFile(List<String> strings, String filename) throws IOException {
        try (PrintStream ps = new PrintStream(new FileOutputStream(filename))) {
            for (String str : strings) {
               ps.println(str);
            }
        }
    }

    /**
     * Creates a list of strings based on the file
     * @param filename
     * @return
     */
    public List<String> readFromFile (String  filename) throws IOException {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line;
            while ((line = bf.readLine()) != null) {
                strings.add(line);
            }
        }
        return strings;
    }

    /**
     * Write the numbers into the file so that the file has one string composed from the numbers written one by
     * one with the delimiter " ".
     * {4, 15, -9} -> "4 15 -9"
     * @param numbers
     * @param filename
     */
    public void writeNumbers (List<Integer> numbers, String filename) throws IOException {
        try (PrintStream ps = new PrintStream(new FileOutputStream(filename))) {
            for (int n : numbers) {
                ps.print(n + " ");
            }
        }
    }

    /**
     * "4 15 -9" -> {4, 15, -9}
     * @param filename
     * @return
     */
    public List<Integer> readNumbers (String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line = bf.readLine();
            String[] strings = line.split(" ");
            for (String str : strings) {
                numbers.add(Integer.valueOf(str));
            }
        }
        return numbers;
    }
}
