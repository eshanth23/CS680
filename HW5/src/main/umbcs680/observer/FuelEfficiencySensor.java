package umbcs680.observer;

import java.util.LinkedList;
import java.util.List;

public class FuelEfficiencySensor {
    private double mileage_per_mile;

    private List<FuelEfficiencyInterface> observers = new LinkedList<>();

    public void addObserver(FuelEfficiencyInterface observer) {
        observers.add(observer);
    }

    public void removeObserver(FuelEfficiencyInterface observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (FuelEfficiencyInterface ob : observers) {
            ob.updatingFuelMileageData(this);
        }
    }

    public void settingFuelMileage(double mileage) {
        this.mileage_per_mile = mileage;
        notifyObservers();
    }

    public double gettingFuelMileage() {
        return mileage_per_mile;
    }

    public int countObservers() {
        return observers.size();
    }
}
