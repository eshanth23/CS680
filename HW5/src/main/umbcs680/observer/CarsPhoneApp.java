package umbcs680.observer;

public class CarsPhoneApp implements FuelEfficiencyInterface, SpeedingInterface {
    private double fuelMileage;
    private double speed;

    @Override
    public void updatingSpeedingData(SpeedingSensor event) {
        this.speed = event.gettingSpeed();
        updatePhoneAppUI("Speed Updated: " + speed);
    }

    @Override
    public void updatingFuelMileageData(FuelEfficiencySensor event) {
        this.fuelMileage = event.gettingFuelMileage();
        updatePhoneAppUI("The Fuel Efficiency is Updated: " + fuelMileage);
    }

    private void updatePhoneAppUI(String message) {
        // Simulates Phone App UI Update
    }

    public double gettingFuelMileage() {
        return fuelMileage;
    }

    public double gettingSpeed() {
        return speed;
    }
}
