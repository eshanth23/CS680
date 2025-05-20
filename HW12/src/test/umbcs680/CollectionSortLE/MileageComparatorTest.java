package umbcs680.CollectionSortLE;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MileageComparatorTest {

    @BeforeAll
    public static void initial() {
        TestFixtureInitializer.setup();
    }

    @Test
    public void Mileage_Ascending_Sort() {
         Collections.sort(TestFixtureInitializer.carList, Comparator.comparing(Car::getMileage));
        List<String> expected = List.of("Ranger", "Falcon", "Fusion", "Aurora");

        List<String> actual = new ArrayList<>();
        for (Car car : TestFixtureInitializer.carList) {
            actual.add(car.getModel());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void Mileage_Descending_Sort() {
        Collections.sort(TestFixtureInitializer.carList, Comparator.comparing(Car::getMileage,Comparator.reverseOrder()));
        List<String> expected = List.of("Aurora", "Fusion", "Falcon", "Ranger");

        List<String> actual = new ArrayList<>();
        for (Car car : TestFixtureInitializer.carList) {
            actual.add(car.getModel());
        }
        assertEquals(expected, actual);
    }


    }


