package umbcs680.CollectionSort;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return c1.getMileage() - c2.getMileage();
    }
}


