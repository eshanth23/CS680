package umbcs680.CollectionSort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MileageComparatorTest  {

    @BeforeAll
    public static void initial() {
        TestFixtureInitializer.setup();
    }

    @Test
    public void Mileage_Sorting_By_Model_Order() {

        Collections.sort(TestFixtureInitializer.carList,new MileageComparator());


        List<String> expectedOrder = List.of("Ranger", "Falcon", "Fusion", "Aurora");


        List<String> actualOrder = new ArrayList<>();
        for (Car car : TestFixtureInitializer.carList) {
            actualOrder.add(car.getModel());
        }

        assertEquals(expectedOrder, actualOrder);


        assertTrue(expectedOrder.equals(actualOrder));
    }
}
