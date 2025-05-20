package umbcs680.CollectionSort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParetoComparatorTest {

    @BeforeAll
    public static void initial() {
        TestFixtureInitializer.setup();

    }

    @Test
    public void Pareto_Sort_Order() {

        for (Car car : TestFixtureInitializer.carList) {
            car.setDominationCount(TestFixtureInitializer.carList);
        }

        Collections.sort(TestFixtureInitializer.carList, new ParetoComparator());

        List<String> actualModels = new ArrayList<>();
        for (Car car : TestFixtureInitializer.carList) {
            actualModels.add(car.getModel());
        }


        List<String> expectedModels = List.of("Ranger", "Aurora", "Falcon", "Fusion");

        assertEquals(expectedModels, actualModels);

    }

}