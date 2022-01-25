import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//Есть лист целых чисел. Известно, что все элементы из листа можно разбить на пары с равными элементами,
// кроме одного ( {5, 1, 5, 1, 7, 7, 5, 5, 7} ). Необходимо найти этот элемент (у которого не нашлось пары)

public class NoPair {

    public int elementWithoutPair(List<Integer> numbers) {
        Map<Integer, Integer> pairs = new HashMap<>();

        for (int number : numbers) {
            if (pairs.containsKey(number)) {
                int value = pairs.get(number);
                pairs.put(number, value + 1);
            } else
                pairs.put(number, 1);
        }

        Iterator<Integer> iterator = pairs.keySet().iterator();

        int res = iterator.next();

        while (iterator.hasNext()) {
            int currentNumber = iterator.next();
            if (pairs.get(currentNumber) % 2 == 1)
                res = currentNumber;
        }
        return res;
    }

}
