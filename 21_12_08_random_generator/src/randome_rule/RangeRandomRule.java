package randome_rule;

import randome_rule.IRandomeRule;

import java.util.Random;

public class RangeRandomRule implements IRandomeRule {
    private final int min;
    private final int max;
    private final Random rnd = new Random();

    public RangeRandomRule(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int nextInt() {
        Random rnd = new Random();
        int dif = max - min;
        return rnd.nextInt(dif) + min;
    }
}
