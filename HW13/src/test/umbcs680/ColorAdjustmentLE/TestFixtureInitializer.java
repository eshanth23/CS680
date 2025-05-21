package umbcs680.ColorAdjustmentLE;



public class TestFixtureInitializer {
    protected static Image original;

    public static void createFixture() {
        original = new Image(3, 1);
        original.setColor(0, 0, new Color(120, 60, 30));
        original.setColor(1, 0, new Color(200, 200, 200));
        original.setColor(2, 0, new Color(30, 90, 150));
    }
}

