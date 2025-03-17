package umbcs680.observer;

public class CarsPhoneApp implements Observer<Double> {
    private double latestEvent;

    public void update(Observable<Double> sender, Double event) {
        this.latestEvent = event;
    }

    public double getLatestEvent() {
        return latestEvent;
    }
}
