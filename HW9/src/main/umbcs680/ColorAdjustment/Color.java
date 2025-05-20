package umbcs680.ColorAdjustment;

public class Color {
    private int redScale;
    private int greenScale;
    private int blueScale;

    public Color(int r, int g, int b) {
        this.redScale = r;
        this.greenScale = g;
        this.blueScale = b;
    }

    public int getRedScale() {
        return redScale;
    }

    public int getGreenScale() {
        return greenScale;
    }

    public int getBlueScale() {
        return blueScale;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Color)) return false;
        Color other = (Color) obj;
        return this.redScale == other.redScale &&
                this.greenScale == other.greenScale &&
                this.blueScale == other.blueScale;
    }

    @Override
    public String toString() {
        return "(" + redScale + ", " + greenScale + ", " + blueScale + ")";
    }
}
