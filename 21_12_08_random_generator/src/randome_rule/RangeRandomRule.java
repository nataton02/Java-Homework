package randome_rule;

import randome_rule.IRandomeRule;

import java.util.Random;

//TODO the rule must generate random numbers between 'min' inclusive and 'max' exclusive
//min and max must be the fields of the class
public class RangeRandomRule implements IRandomeRule {
    private final int min;
    private final int max;

    public RangeRandomRule(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int nextInt() {
        Random rnd = new Random();
        int dif = max - min;
        return rnd.nextInt(dif + min);
    }
}
