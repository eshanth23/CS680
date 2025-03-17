package umbcs680.observer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class CarSensorsNotificationsTest {

    private SpeedingSensor speedSensor;
    private FuelEfficiencySensor fuelSensor;


    private CarsDashboardDisplay dashboard;
    private CarsPhoneApp app;
    private CarsWebsitePage website;

    @BeforeEach
    void setUp() {
        speedSensor = new SpeedingSensor();
        fuelSensor = new FuelEfficiencySensor();


        dashboard = new CarsDashboardDisplay();
        app = new CarsPhoneApp();
        website = new CarsWebsitePage();
    }

    @Test
    void Adding_Observer() {
        speedSensor.addObserver(dashboard);
        assertEquals(1, speedSensor.countObservers());

        speedSensor.addObserver(app);
        assertEquals(2, speedSensor.countObservers());

        speedSensor.addObserver(website);
        assertEquals(3, speedSensor.countObservers());
    }

    @Test
    void Removing_Observer() {
        speedSensor.addObserver(dashboard);
        speedSensor.addObserver(app);
        speedSensor.addObserver(website);

        speedSensor.removeObserver(app);
        assertEquals(2, speedSensor.countObservers());

        speedSensor.removeObserver(dashboard);
        assertEquals(1, speedSensor.countObservers());
    }



    @Test
    void Count_Observers() {
        assertEquals(0, speedSensor.countObservers());

        speedSensor.addObserver(dashboard);
        assertEquals(1, speedSensor.countObservers());

        speedSensor.addObserver(app);
        assertEquals(2, speedSensor.countObservers());

        speedSensor.removeObserver(dashboard);
        assertEquals(1, speedSensor.countObservers());
    }

    @Test
    void Speed_Sensor_Event_Notification() {
        speedSensor.addObserver(dashboard);
        speedSensor.addObserver(app);
        speedSensor.addObserver(website);

        speedSensor.settingSpeed(90);
        assertEquals(90, dashboard.getSpeed());
        assertEquals(90, app.gettingSpeed());
        assertEquals(90, website.getSpeed());
    }

    @Test
    void Fuel_Efficiency_Sensor_EventNotification() {
        fuelSensor.addObserver(dashboard);
        fuelSensor.addObserver(app);
        fuelSensor.addObserver(website);

        fuelSensor.settingFuelMileage(17.8);
        assertEquals(17.8, dashboard.getFuelMileage());
        assertEquals(17.8, app.gettingFuelMileage());
        assertEquals(17.8, website.gettingFuelMileage());
    }


    @Test
    void Multiple_Sensors_EventNotification() {
        speedSensor.addObserver(dashboard);
        fuelSensor.addObserver(dashboard);


        speedSensor.settingSpeed(110);
        assertEquals(110, dashboard.getSpeed());

        fuelSensor.settingFuelMileage(20.5);
        assertEquals(20.5, dashboard.getFuelMileage());


    }
}
