package umbcs680.ColorAdjustment;

public class BinarizationAdjuster implements ColorAdjuster {
    @Override
    public Color adjust(Color color) {
        int r = color.getRedScale();
        int g = color.getGreenScale();
        int b = color.getBlueScale();
        int avg = (r + g + b) / 3;
        return (avg <= 125) ? new Color(0, 0, 0) : new Color(255, 255, 255);
    }
}
