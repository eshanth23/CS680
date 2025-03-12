package umbcs680.softwareupdate;
import java.util.*;



    interface Observer<T> {
        void update(Observable<T> sender, T event);
    }


    class Observable<T> {
        private final List<Observer<T>> observers = new ArrayList<>();

        public void addObserver(Observer<T> o) {
            observers.add(o);
        }

        public void removeObserver(Observer<T> o) {
            observers.remove(o);
        }

        public int countObservers() {
            return observers.size();
        }

        public void clearObservers() {
            observers.clear();
        }

        public void notifyObservers(T event) {
            for (Observer<T> observer : observers) {
                observer.update(this, event);
            }
        }
    }


class CarBrand extends Observable<String> implements Observer<String> {
    private final String car;
    private String lastinstruction;

    public CarBrand(String car) {
        this.car = car;
    }

    public String getCar() {
        return car;
    }

    public String getLastInstruction() {
        return lastinstruction;
    }

    public void software_release_updates(String updatedVersion) {
        notifyObservers(updatedVersion);
    }

    @Override
    public void update(Observable<String> sender, String event) {
        this.lastinstruction = event;  // Store the feedback from CarSoftware
    }
}



class CarModel extends Observable<String> implements Observer<String> {
        private final String model;
        private String latestUpdates;

        public CarModel(String model) {
            this.model = model;
        }

        public String getLatestUpdates() {
            return latestUpdates;
        }

        @Override
        public void update(Observable<String> sender, String event) {
            this.latestUpdates = event;
            notifyObservers("Car Model " + model + " have installed update: " + event);
        }
    }


