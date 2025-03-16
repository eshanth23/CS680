package umbcs680.observer;

public class TirePressureMonitoringSensor extends Observable<Double> {
    private double tyres_pressure;
    public void settingTiresPressure(double tyres_pressure) {
        this.tyres_pressure=tyres_pressure;
        notifyObservers(tyres_pressure);

    }
    public double getTyresPressure() {
        return tyres_pressure;
    }
}