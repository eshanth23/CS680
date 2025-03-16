package umbcs680.observer;

public class CarsWebsitePage implements Observer<Double> {
    private double latestEvent;

    public void update(Observable<Double> sender, Double event) {
        this.latestEvent = event;
    }

    public double getLatestEvent() {
        return latestEvent;
    }
}
