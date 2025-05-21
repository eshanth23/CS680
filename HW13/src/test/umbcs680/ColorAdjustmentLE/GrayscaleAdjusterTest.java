package umbcs680.ColorAdjustmentLE;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrayscaleAdjusterTest {

    private static ColorAdjuster grayscale;

    @BeforeAll
    public  static void setupCF() {
        TestFixtureInitializer.createFixture();
        grayscale = (color) -> {
            int avg = (color.getRedScale() + color.getGreenScale() + color.getBlueScale()) / 3;
            return new Color(avg, avg, avg);
        };
    }

    @Test
    void Grayscale_Pixel_One() {
        Color result = grayscale.adjust(TestFixtureInitializer.original.getColor(0, 0));
        assertEquals(new Color(70, 70, 70), result);
    }

    @Test
    void Grayscale_Pixel_Two() {
        Color result = grayscale.adjust(TestFixtureInitializer.original.getColor(1, 0));
        assertEquals(new Color(200, 200, 200), result);
    }

    @Test
    void Grayscale_Pixel_Three() {
        Color result = grayscale.adjust(TestFixtureInitializer.original.getColor(2, 0));
        assertEquals(new Color(90, 90, 90), result);
    }
}
