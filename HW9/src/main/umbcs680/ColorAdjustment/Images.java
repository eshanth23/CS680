package umbcs680.ColorAdjustment;

public class Images {
    public static Image transform(Image image, ColorAdjuster adjuster) {
        int height = image.getHeight();
        int width = image.getWidth();
        Image adjusted = new Image(height, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color original = image.getColor(x, y);
                Color newColor = adjuster.adjust(original);
                adjusted.setColor(x, y, newColor);
            }
        }

        return adjusted;
    }
}


