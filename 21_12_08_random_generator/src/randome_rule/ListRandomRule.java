package randome_rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListRandomRule implements IRandomeRule {
    private final List<Integer> numbers;
    private final Random rnd = new Random();

    public ListRandomRule(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }


    @Override
    // {10, 15, 90, -8} -> or 10, 15, 90, -8
    public int nextInt() {
        int randomIndex = rnd.nextInt(numbers.size());
        return numbers.get(randomIndex);
    }
}


