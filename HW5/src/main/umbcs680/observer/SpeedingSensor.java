package umbcs680.observer;

import java.util.LinkedList;
import java.util.List;

public class SpeedingSensor {
    private double speed;

    private List<SpeedingInterface> observers = new LinkedList<>();

    public void addObserver(SpeedingInterface observer) {
        observers.add(observer);
    }

    public void removeObserver(SpeedingInterface observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (SpeedingInterface ob : observers) {
            ob.updatingSpeedingData(this);
        }
    }

    public void settingSpeed(double speed) {
        this.speed = speed;
        notifyObservers();
    }

    public double gettingSpeed() {
        return speed;
    }

    public int countObservers() {
        return observers.size();
    }
}
