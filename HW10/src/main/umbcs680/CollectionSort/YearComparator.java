package umbcs680.CollectionSort;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return c2.getYear() - c1.getYear();
    }
}

