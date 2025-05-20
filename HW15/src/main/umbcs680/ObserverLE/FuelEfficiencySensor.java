package umbcs680.ObserverLE;

public class FuelEfficiencySensor extends Observable<MileageEventNotifier> {
    private double mileage_per_mile;


    public void setFuelMileage(double mileage_per_mile) {
        this.mileage_per_mile = mileage_per_mile;
        notifyObservers(new MileageEventNotifier(this.mileage_per_mile));
    }

    public double getFuelMileage() {
        return mileage_per_mile;
    }

}