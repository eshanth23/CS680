package umbcs680.ColorAdjustment;

import java.util.ArrayList;

public class Image {
    private int width;
    private int height;
    private ArrayList<ArrayList<Color>> pixels;

    public Image(int height, int width) {
        this.height = height;
        this.width = width;
        pixels = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            ArrayList<Color> row = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                row.add(new Color(0, 0, 0)); // black by default
            }
            pixels.add(row);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor(int x, int y) {
        return pixels.get(y).get(x);
    }

    public void setColor(int x, int y, Color color) {
        pixels.get(y).set(x, color);
    }
}
