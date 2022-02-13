import java.util.Comparator;

public class ComparatorModel implements Comparator<Auto> {

    @Override
    public int compare(Auto auto1, Auto auto2) {
        int flag = auto1.model.compareTo(auto2.model);
        if (flag == 0)
            flag = Integer.compare(auto1.price, auto2.price);
        return flag;
    }
}
