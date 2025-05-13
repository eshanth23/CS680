package umbcs680.ColorAdjustmentLE;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImagesTest {

    @BeforeAll
    public static void setUpCF() {
        TestFixtureInitializer.createFixture();
    }

    @Test
    public void Transform_Using_GrayScale_Lambda() {
        Image result = Images.transform(TestFixtureInitializer.original, (color) -> {
            int avg = (color.getRedScale() + color.getGreenScale() + color.getBlueScale()) / 3;
            return new Color(avg, avg, avg);
        });

        assertEquals(new Color(70, 70, 70), result.getColor(0, 0));
        assertEquals(new Color(200, 200, 200), result.getColor(1, 0));
        assertEquals(new Color(90, 90, 90), result.getColor(2, 0));
    }

    @Test
    public void Transform_Using_Binarization_Lambda() {
        Image result = Images.transform(TestFixtureInitializer.original, (color) -> {
            int avg = (color.getRedScale() + color.getGreenScale() + color.getBlueScale()) / 3;
            return avg <= 125 ? new Color(0, 0, 0) : new Color(255, 255, 255);
        });

        assertEquals(new Color(0, 0, 0), result.getColor(0, 0));
        assertEquals(new Color(255, 255, 255), result.getColor(1, 0));
        assertEquals(new Color(0, 0, 0), result.getColor(2, 0));
    }
}
