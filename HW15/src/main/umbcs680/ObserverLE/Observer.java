package umbcs680.ObserverLE;

@FunctionalInterface
public interface Observer<T> {
    void update(Observable<T> sender, T event);
}
