package randome_rule;

import randome_rule.IRandomeRule;

import java.util.Random;

public class MaxRandomRule implements IRandomeRule {
    private final Random rnd = new Random();
    private final int max;

    public MaxRandomRule(int max) {
        this.max = max;
    }

    @Override
    public int nextInt() {
        return rnd.nextInt(max); // generates random numbers from 0 inclusive to max exclusive
    }
}
