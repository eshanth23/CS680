package umbcs680.CollectionSortLE;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParetoComparatorTest {

    @BeforeAll
    public static void initial() {
        TestFixtureInitializer.setup();

    }


    @Test
    public void Pareto_Sort_Ascending_Order() {


        for (Car car : TestFixtureInitializer.carList) {
            car.setDominationCount(TestFixtureInitializer.carList);
        }

        Collections.sort(TestFixtureInitializer.carList, Comparator.comparing(Car::getDominationCount));

        List<String> expectedAsc = List.of("Ranger", "Aurora", "Falcon", "Fusion");

        List<String> actualAsc = new ArrayList<>();
        for (Car car : TestFixtureInitializer.carList) {
            actualAsc.add(car.getModel());
        }

        assertEquals(expectedAsc, actualAsc, "Ascending domination sort failed");

    }

        @Test
        public void Pareto_Sort_Descending_Order () {


            for (Car car : TestFixtureInitializer.carList) {
                car.setDominationCount(TestFixtureInitializer.carList);
            }

            Collections.sort(TestFixtureInitializer.carList, Comparator.comparing(Car::getDominationCount, Comparator.reverseOrder()));

            List<String> expectedDesc = List.of("Fusion", "Ranger", "Aurora", "Falcon");

            List<String> actualDesc = new ArrayList<>();
            for (Car car : TestFixtureInitializer.carList) {
                actualDesc.add(car.getModel());
            }

            assertEquals(expectedDesc, actualDesc);

        }
    }
