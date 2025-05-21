package umbcs680.ColorAdjustmentLE;

public class Images {
    public static Image transform(Image image, ColorAdjuster adjuster) {
        Image adjusted = new Image(image.getHeight(), image.getWidth());
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                Color original = image.getColor(i, j);
                Color modified = adjuster.adjust(original);
                adjusted.setColor(i, j, modified);
            }
        }
        return adjusted;
    }
}
