package umbcs680.CollectionSortLE;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceComparatorTest {

    @BeforeAll
    public static void initial() {
        TestFixtureInitializer.setup();

    }

    @Test
    public void Price_Ascending_Natural_Order() {
        Collections.sort(TestFixtureInitializer.carList,Comparator.comparing( Car::getPrice ));
        List<String> expected = List.of("Aurora", "Falcon", "Fusion", "Ranger");

        List<String> actual = new ArrayList<>();
        for (Car car : TestFixtureInitializer.carList) {
            actual.add(car.getModel());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void Price_Descending_Reverse_Order() {
        Collections.sort(TestFixtureInitializer.carList,Comparator.comparing( Car::getPrice,Comparator.reverseOrder() ));
        List<String> expected = List.of("Ranger","Fusion","Falcon","Aurora");

        List<String> actual = new ArrayList<>();
        for (Car car : TestFixtureInitializer.carList) {
            actual.add(car.getModel());
        }

        assertEquals(expected, actual);
    }

}

