import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/*
В файле input.txt записаны данные о собаках, привезённых на выставку: кличка, возраст и порода каждой собаки.
Нужно записать в файл output.txt данные о всех собаках, которым меньше K лет.
 */

public class DogExhibition {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        try {
            FileReader file = new FileReader("input2.txt");
            BufferedReader input = new BufferedReader(file);
            Scanner in = new Scanner(input);

            PrintWriter output = new PrintWriter("output2.txt");

            while(in.hasNext()) {
                String str = in.nextLine();
                String[] words = str.split("\\s");
                int current = Integer.valueOf(words[1]);
                if (current < number)
                output.printf(str + "%n");
            }

            output.close();
            input.close();
            in.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}
