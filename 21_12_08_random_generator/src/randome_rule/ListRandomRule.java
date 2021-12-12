package randome_rule;
// TODO an object of the class must receive a list of integers through the constructor while created
// The method nextInt() must pick a number from this list randomly

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListRandomRule implements IRandomeRule {
    List<Integer> numbers = new ArrayList<>();

    public ListRandomRule(List<Integer> numbers) {
        this.numbers = numbers;
    }


    @Override
    // {10, 15, 90, -8} -> or 10, 15, 90, -8
    public int nextInt() {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(numbers.size());
        return numbers.get(randomIndex);
    }
}


