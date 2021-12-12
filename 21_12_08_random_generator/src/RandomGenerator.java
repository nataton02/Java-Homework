import randome_rule.IRandomeRule;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private final IRandomeRule randomRule;

    public RandomGenerator(IRandomeRule randomRule) {
        this.randomRule = randomRule;
    }

    /**
     * The method must generate n random numbers according to randomeRule
     * @param n
     * @return
     */
    public List<Integer> generate(int n) {
        //TODO implement. Generate n random numbers using randomRule.nextInt()
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(randomRule.nextInt());
        }
        return numbers;
    }
}
