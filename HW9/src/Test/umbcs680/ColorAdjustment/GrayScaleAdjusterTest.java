package umbcs680.ColorAdjustment;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrayScaleAdjusterTest extends TestFixtureInitializer {

    @BeforeAll
    public static void setUpCF() {
        createFixture();
    }

    @Test
    public void GrayScale_Conversion() {
        GrayScaleAdjuster adjuster = new GrayScaleAdjuster();
        Image grayImage = Images.transform(original, adjuster);

        assertEquals(new Color(70, 70, 70), grayImage.getColor(0, 0));
        assertEquals(new Color(200, 200, 200), grayImage.getColor(1, 0));
        assertEquals(new Color(90, 90, 90), grayImage.getColor(2, 0));
    }
}
