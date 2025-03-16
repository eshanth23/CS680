package umbcs680.observer;

public class SpeedingSensor extends Observable<Double> {
    private double speed;

    public void settingSpeed(double speed) {
        this.speed = speed;
        notifyObservers(speed);
    }

    public double getSpeed() {
        return speed;
    }
}

