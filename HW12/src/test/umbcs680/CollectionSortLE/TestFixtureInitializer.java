package umbcs680.CollectionSortLE;

import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

public class TestFixtureInitializer {
    protected static Car car1, car2, car3, car4;
    protected static List<Car> carList;

    @BeforeAll
    public static void setup() {
        car1 = new Car("Fusion",35000, 2020, 19000);
        car2 = new Car("Ranger",18000, 2022, 37000);
        car3 = new Car("Aurora",42000, 2019, 16000);
        car4 = new Car("Falcon",26000, 2021, 17000);

        carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
    }
}

