package umbcs680.observer;

public class FuelEfficiencySensor extends Observable<Double> {
    private double mileage_per_mile; // This was missing

    public void settingFuelMileage(double mileage_per_mile) {
        this.mileage_per_mile = mileage_per_mile;
        notifyObservers(mileage_per_mile);
    }

    public double getFuelMileage() {
        return mileage_per_mile;
    }
}
