package umbcs680.ObserverLE;

import java.util.ArrayList;
import java.util.List;

public class MileageEventNotifier {
    private final List<Observer<Double>> observers = new ArrayList<>();

    public void subscribe(Observer<Double> observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer<Double> observer) {
        observers.remove(observer);
    }

    public int countObservers() {
        return observers.size();
    }

    public void notifyAll(double newMileage) {
        observers.forEach(observer -> observer.update(null, newMileage));
    }

    public List<Observer<Double>> getObservers() {
        return observers;
    }
}
