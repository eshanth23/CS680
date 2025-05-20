package umbcs680.ColorAdjustment;


public class GrayScaleAdjuster implements ColorAdjuster {
    @Override
    public Color adjust(Color color) {
        int r = color.getRedScale();
        int g = color.getGreenScale();
        int b = color.getBlueScale();
        int avg = (r + g + b) / 3;
        return new Color(avg, avg, avg);
    }
}
