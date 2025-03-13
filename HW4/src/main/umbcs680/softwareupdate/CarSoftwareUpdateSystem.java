package umbcs680.softwareupdate;
import java.util.ArrayList;
import java.util.List;


interface Observer<T> {
    void update(Observable<T> sender, T event);
}


class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> o) {
        observers.add(o);
    }

    public void removeObserver(Observer<T> o) {
        observers.remove(o);
    }

    public int countObservers() {
        return observers.size();
    }

    public void notifyObservers(T event) {
        for (Observer<T> observer : observers) {
            observer.update(this, event);
        }
    }
}


class CarBrand  extends Observable<String> {
    private final String car;

    public CarBrand(String car) {
        this.car = car;
    }

    public void softwarereleaseUpdates(String updatedVersion) {

        notifyObservers(updatedVersion);
    }
}


class CarModel implements Observer<String> {
    private String model;
    private final List<String> Was_Updates_Received = new ArrayList<>();

    public CarModel(String model) {
        this.model = model;
    }

    @Override
    public void update(Observable<String> sender, String event) {
        Was_Updates_Received.add(event);
    }
    public List<String> getReceivedUpdates() {
        return Was_Updates_Received;
    }
}
