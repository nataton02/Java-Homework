import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int[] array = {5, 1, 27};

        Iterator<Integer> forwardIterator = new ForwardArrayIterator(array);

        while (forwardIterator.hasNext()) {
            int number = forwardIterator.next();
            //System.out.println(number);
        }

        Iterator<Integer> backwardIterator = new BackwardArrayIterator(array);

        while(backwardIterator.hasNext()) {
            int number = backwardIterator.next();
           // System.out.println(number);
        }

        Iterator<Integer> incresingIterator = new IncreasingArrayIterator(array);

        while (incresingIterator.hasNext()) {
            int number = incresingIterator.next();
            System.out.println(number); // print elements by increasing order expected
        }


    }
}
