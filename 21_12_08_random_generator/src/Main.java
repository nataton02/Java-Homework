import randome_rule.IRandomeRule;
import randome_rule.ListRandomRule;
import randome_rule.MaxRandomRule;
import randome_rule.RangeRandomRule;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        IRandomeRule maxRandomRule = new MaxRandomRule(11);
        RandomGenerator maxRandomGenerator = new RandomGenerator(maxRandomRule);

        IRandomeRule rangeRandomRule = new RangeRandomRule(5, 20);
        RandomGenerator rangeRandomGenerator = new RandomGenerator(rangeRandomRule);

        List<Integer> numbers = new ArrayList<>() ;
        numbers.add(1);
        numbers.add(20);
        numbers.add(-18);
        numbers.add(7);
        IRandomeRule listRandomRule = new ListRandomRule(numbers);
        RandomGenerator listRandomGenerator = new RandomGenerator(listRandomRule);

        System.out.println(maxRandomGenerator.generate(10));
        System.out.println(rangeRandomGenerator.generate(10));
        System.out.println(listRandomGenerator.generate(10));
    }
}
