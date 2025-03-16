package umbcs680.observer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class FuelEfficiencySensorNotificationTest {

    private FuelEfficiencySensor fuelSensor;
    private CarsDashboardDisplay dashboard;
    private CarsPhoneApp app;
    private CarsWebsitePage website;


    @Test
    void Single_Mileage_Update() {

        fuelSensor = new FuelEfficiencySensor();

        dashboard = new CarsDashboardDisplay();
        app = new CarsPhoneApp();
        website = new CarsWebsitePage();

        // Adding observers to fuel sensor
        fuelSensor.addObserver(dashboard);
        fuelSensor.addObserver(app);
        fuelSensor.addObserver(website);

        fuelSensor.setFuelMileage(25.8);

        assertEquals(25.8, dashboard.getLatestEvent());
        assertEquals(25.8, app.getLatestEvent());
        assertEquals(25.8, website.getLatestEvent());
    }

    @Test
    void Multiple_Mileage_Updates() {

        fuelSensor = new FuelEfficiencySensor();

        dashboard = new CarsDashboardDisplay();
        app = new CarsPhoneApp();
        website = new CarsWebsitePage();

        // Adding observers to fuel sensor
        fuelSensor.addObserver(dashboard);
        fuelSensor.addObserver(app);
        fuelSensor.addObserver(website);

        fuelSensor.setFuelMileage(10.6);
        fuelSensor.setFuelMileage(21.8);
        fuelSensor.setFuelMileage(25.8);

        // Latest update should be reflected in all observers
        assertEquals(25.8, dashboard.getLatestEvent());
        assertEquals(25.8, app.getLatestEvent());
        assertEquals(25.8, website.getLatestEvent());
    }

    @Test
    void No_Updates() {
        // Before any update, mileage should be 0.0 by default

        fuelSensor = new FuelEfficiencySensor();

        dashboard = new CarsDashboardDisplay();
        app = new CarsPhoneApp();
        website = new CarsWebsitePage();

        // Adding observers to fuel sensor
        fuelSensor.addObserver(dashboard);
        fuelSensor.addObserver(app);
        fuelSensor.addObserver(website);

        assertEquals(0.0, dashboard.getLatestEvent());
        assertEquals(0.0, app.getLatestEvent());
        assertEquals(0.0, website.getLatestEvent());
    }

    @Test
    void Adding_a_new_Observer() {

        fuelSensor = new FuelEfficiencySensor();

        dashboard = new CarsDashboardDisplay();
        app = new CarsPhoneApp();
        website = new CarsWebsitePage();

        // Adding observers to fuel sensor
        fuelSensor.addObserver(dashboard);
        fuelSensor.addObserver(app);
        fuelSensor.addObserver(website);

        CarsPhoneApp newObserver = new CarsPhoneApp();
        fuelSensor.addObserver(newObserver);

        assertEquals(4, fuelSensor.countObservers()); // 3 initial + 1 new observer
    }

    @Test
    void Removing_an_Observer() {

        fuelSensor = new FuelEfficiencySensor();

        dashboard = new CarsDashboardDisplay();
        app = new CarsPhoneApp();
        website = new CarsWebsitePage();


        fuelSensor.addObserver(dashboard);
        fuelSensor.addObserver(app);
        fuelSensor.addObserver(website);

        fuelSensor.removeObserver(app);
        assertEquals(2, fuelSensor.countObservers()); // Removed App, 2 remaining
    }

    @Test
    void Counting_Observers() {

        fuelSensor = new FuelEfficiencySensor();

        dashboard = new CarsDashboardDisplay();
        app = new CarsPhoneApp();
        website = new CarsWebsitePage();


        fuelSensor.addObserver(dashboard);
        fuelSensor.addObserver(app);
        fuelSensor.addObserver(website);

        assertEquals(3, fuelSensor.countObservers()); // 3 Observers Added
    }

    @Test
    void Getting_all_Observers() {

        fuelSensor = new FuelEfficiencySensor();

        dashboard = new CarsDashboardDisplay();
        app = new CarsPhoneApp();
        website = new CarsWebsitePage();


        fuelSensor.addObserver(dashboard);
        fuelSensor.addObserver(app);
        fuelSensor.addObserver(website);

        List<Observer<Double>> observers = fuelSensor.getObservers();
        assertTrue(observers.contains(dashboard));
        assertTrue(observers.contains(app));
        assertTrue(observers.contains(website));
    }
}
