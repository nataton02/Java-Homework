public class LoadCounter {
    public int counter = 0;

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public void print() {
        System.out.println("COUNTER:" + counter);
    }

}
