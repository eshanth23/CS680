package umbcs680.CollectionSort;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return c1.getPrice() - c2.getPrice();
    }
}


