package umbcs680.observer;

public class CarsWebsitePage implements FuelEfficiencyInterface, SpeedingInterface {
    private double fuelMileage;
    private double speed;

    @Override
    public void updatingSpeedingData(SpeedingSensor event) {
        this.speed = event.gettingSpeed();
        updateWebsiteUI("Speed was Updated on Website: " + speed);
    }

    @Override
    public void updatingFuelMileageData(FuelEfficiencySensor event) {
        this.fuelMileage = event.gettingFuelMileage();
        updateWebsiteUI("Fuel Efficiency was Updated on Website: " + fuelMileage);
    }

    private void updateWebsiteUI(String message) {
        // Simulates Website UI Update
    }

    public double gettingFuelMileage() {
        return fuelMileage;
    }

    public double getSpeed() {
        return speed;
    }
}
