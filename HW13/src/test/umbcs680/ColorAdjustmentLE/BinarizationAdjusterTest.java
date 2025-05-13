package umbcs680.ColorAdjustmentLE;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BinarizationAdjusterTest {

    static ColorAdjuster binarize;

    @BeforeAll
    public static void  setupCF() {
        TestFixtureInitializer.createFixture();
        binarize = (color) -> {
            int avg = (color.getRedScale() + color.getGreenScale() + color.getBlueScale()) / 3;
            return avg <= 125 ? new Color(0, 0, 0) : new Color(255, 255, 255);
        };
    }

    @Test
    void Binarization_Pixel_One() {
        Color result = binarize.adjust(TestFixtureInitializer.original.getColor(0, 0));
        assertEquals(new Color(0, 0, 0), result);
    }

    @Test
    void Binarization_Pixel_Two() {
        Color result = binarize.adjust(TestFixtureInitializer.original.getColor(1, 0));
        assertEquals(new Color(255, 255, 255), result);
    }

    @Test
    void Binarization_Pixel_Three() {
        Color result = binarize.adjust(TestFixtureInitializer.original.getColor(2, 0));
        assertEquals(new Color(0, 0, 0), result);
    }
}
