package umbcs680.observer;

public class CarsDashboardDisplay implements FuelEfficiencyInterface, SpeedingInterface {
    private double fuelMileage;
    private double speed;

    @Override
    public void updatingSpeedingData(SpeedingSensor event) {
        this.speed = event.gettingSpeed();
        updateDashboardUI("Speed Updated on Dashboard: " + speed);
    }

    @Override
    public void updatingFuelMileageData(FuelEfficiencySensor event) {
        this.fuelMileage = event.gettingFuelMileage();
        updateDashboardUI("Fuel Efficiency Updated on Dashboard: " + fuelMileage);
    }

    private void updateDashboardUI(String message) {
        // Simulates Dashboard Display Update
    }

    public double getFuelMileage() {
        return fuelMileage;
    }

    public double getSpeed() {
        return speed;
    }
}
