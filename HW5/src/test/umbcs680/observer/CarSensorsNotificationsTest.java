package umbcs680.observer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class CarSensorEventNotificationTest {

    private SpeedingSensor speedSensor;
    private FuelEfficiencySensor fuelSensor;
    private TirePressureMonitoringSensor tireSensor;

    private CarsDashboardDisplay dashboard;
    private CarsPhoneApp app;
    private CarsWebsitePage website;

    @BeforeEach
    void setUp() {
        speedSensor = new SpeedingSensor();
        fuelSensor = new FuelEfficiencySensor();
        tireSensor = new TirePressureMonitoringSensor();

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
    void Getting_Observers() {
        speedSensor.addObserver(dashboard);
        speedSensor.addObserver(app);
        speedSensor.addObserver(website);

        List<Observer<Double>> observers = speedSensor.getObservers();
        assertTrue(observers.contains(dashboard));
        assertTrue(observers.contains(app));
        assertTrue(observers.contains(website));
        assertEquals(3, observers.size());
    }

    @Test
    void Count_all_the_Observers() {
        assertEquals(0, speedSensor.countObservers());

        speedSensor.addObserver(dashboard);
        assertEquals(1, speedSensor.countObservers());

        speedSensor.addObserver(app);
        assertEquals(2, speedSensor.countObservers());

        speedSensor.removeObserver(dashboard);
        assertEquals(1, speedSensor.countObservers());
    }

    @Test
    void Speed_Sensor_Event_Notifications() {
        speedSensor.addObserver(dashboard);
        speedSensor.addObserver(app);
        speedSensor.addObserver(website);

        speedSensor.settingSpeed(90);
        assertEquals(90, dashboard.getLatestEvent());
        assertEquals(90, app.getLatestEvent());
        assertEquals(90, website.getLatestEvent());
    }

    @Test
    void Fuel_Efficiency_Sensor_Event_Notification() {
        fuelSensor.addObserver(dashboard);
        fuelSensor.addObserver(app);
        fuelSensor.addObserver(website);

        fuelSensor.settingFuelMileage(17.8);
        assertEquals(17.8, dashboard.getLatestEvent());
        assertEquals(17.8, app.getLatestEvent());
        assertEquals(17.8, website.getLatestEvent());
    }

    @Test
    void Tire_Pressure_Monitoring_Sensor_EventNotification() {
        tireSensor.addObserver(dashboard);
        tireSensor.addObserver(app);
        tireSensor.addObserver(website);

        tireSensor.settingTiresPressure(32.5);
        assertEquals(32.5, dashboard.getLatestEvent());
        assertEquals(32.5, app.getLatestEvent());
        assertEquals(32.5, website.getLatestEvent());
    }

    @Test
    void Multiple_Sensors_Event_Notification() {
        speedSensor.addObserver(dashboard);
        fuelSensor.addObserver(dashboard);
        tireSensor.addObserver(dashboard);

        speedSensor.settingSpeed(110);
        assertEquals(110, dashboard.getLatestEvent());

        fuelSensor.settingFuelMileage(20.5);
        assertEquals(20.5, dashboard.getLatestEvent());

        tireSensor.settingTiresPressure(34.2);
        assertEquals(34.2, dashboard.getLatestEvent());
    }
}