package umbcs680.ObserverLE;

public class FuelEfficiencySensor {
    private double mileage;
    private final MileageEventNotifier notifier = new MileageEventNotifier();

    public void setFuelMileage(double mileage) {
        this.mileage = mileage;
        notifier.notifyAll(mileage);
    }

    public double getFuelMileage() {
        return mileage;
    }

    public void addObserver(Observer<Double> observer) {
        notifier.subscribe(observer);
    }

    public void removeObserver(Observer<Double> observer) {
        notifier.unsubscribe(observer);
    }

    public int countObservers() {
        return notifier.countObservers();
    }

    public MileageEventNotifier getNotifier() {
        return notifier;
    }
}


