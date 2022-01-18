import java.util.Comparator;

public class CarsComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        if(car1.year > car2.year)
            return -1;
        if(car1.year < car2.year)
            return 1;

        return car1.km - car2.km;

    }
}
