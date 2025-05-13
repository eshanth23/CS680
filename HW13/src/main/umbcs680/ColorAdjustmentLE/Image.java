package umbcs680.ColorAdjustmentLE;

import java.util.ArrayList;

public class Image {
    private int width;
    private int height;
    private ArrayList<ArrayList<Color>> pixels;

    public Image(int height, int width) {
        this.height = height;
        this.width = width;
        pixels = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ArrayList<Color> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add(new Color(0, 0, 0)); // default black
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
        return pixels.get(x).get(y);
    }

    public void setColor(int x, int y, Color color) {
        pixels.get(x).set(y, color);
    }
}

