package umbcs680.ColorAdjustment;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarizationAdjusterTest  {

    @BeforeAll
    public static void setUpCF() {
        TestFixtureInitializer.createFixture();
    }

    @Test
    public void Binarization_Conversion() {
        BinarizationAdjuster adjuster = new BinarizationAdjuster();
        Image binImage = Images.transform(TestFixtureInitializer.original, adjuster);

        assertEquals(new Color(0, 0, 0), binImage.getColor(0, 0));
        assertEquals(new Color(255, 255, 255), binImage.getColor(1, 0));
        assertEquals(new Color(0, 0, 0), binImage.getColor(2, 0));
    }
}
