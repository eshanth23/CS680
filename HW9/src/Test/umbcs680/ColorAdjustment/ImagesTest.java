package umbcs680.ColorAdjustment;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImagesTest {

    @BeforeAll
    public static void setUpCF() {
        TestFixtureInitializer.createFixture();
    }

    @Test
    public void Transform_Using_GrayScaleAdjuster() {
        Image result = Images.transform(TestFixtureInitializer.original, new GrayScaleAdjuster());
        assertEquals(new Color(70, 70, 70), result.getColor(0, 0));
        assertEquals(new Color(200, 200, 200), result.getColor(1, 0));
        assertEquals(new Color(90, 90, 90), result.getColor(2, 0));
    }

    @Test
    public void Transform_Using_BinarizationAdjuster() {
        Image result = Images.transform(TestFixtureInitializer.original, new BinarizationAdjuster());
        assertEquals(new Color(0, 0, 0), result.getColor(0, 0));
        assertEquals(new Color(255, 255, 255), result.getColor(1, 0));
        assertEquals(new Color(0, 0, 0), result.getColor(2, 0));
    }
}
