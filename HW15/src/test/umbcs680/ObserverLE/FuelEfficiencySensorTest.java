package umbcs680.ObserverLE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FuelEfficiencySensorTest {

    @Test
    void Single_Mileage_Update() {
        FuelEfficiencySensor sensor = new FuelEfficiencySensor();

        double[] dashboard = new double[1]; //for dashboard Observer.
        double[] app = new double[1]; //for app Observer.
        double[] website = new double[1]; //for website Observer.

        sensor.addObserver((sender, event) -> dashboard[0] = event.getMileage()); //Mileage Event
        sensor.addObserver((sender, event) -> app[0] = event.getMileage());
        sensor.addObserver((sender, event) -> website[0] = event.getMileage());

        sensor.setFuelMileage(25.5);

        assertEquals(25.5, dashboard[0]);// Check whether Observer is notified with Event
        assertEquals(25.5, app[0]);
        assertEquals(25.5, website[0]);
    }

    @Test
    void Multiple_Mileage_Updates() {
        FuelEfficiencySensor sensor = new FuelEfficiencySensor();

        double[] dashboard = new double[1]; //for dashboard Observer.
        double[] app = new double[1]; //for app Observer.
        double[] website = new double[1]; //for website Observer.

        sensor.addObserver((sender, event) -> dashboard[0] = event.getMileage());//Mileage Event
        sensor.addObserver((sender, event) -> app[0] = event.getMileage());
        sensor.addObserver((sender, event) -> website[0] = event.getMileage());

        sensor.setFuelMileage(10.0);
        assertEquals(10.0, dashboard[0]); // Check whether Observer is notified with Event
        assertEquals(10.0, app[0]);
        assertEquals(10.0, website[0]);

        sensor.setFuelMileage(15.0);
        assertEquals(15.0, dashboard[0]); // Check whether Observer is notified with Event
        assertEquals(15.0, app[0]);
        assertEquals(15.0, website[0]);

        sensor.setFuelMileage(30.0);
        assertEquals(30.0, dashboard[0]); // Check whether Observer is notified with Event
        assertEquals(30.0, app[0]);
        assertEquals(30.0, website[0]);
    }

    @Test
    void No_Updates() {
        FuelEfficiencySensor sensor = new FuelEfficiencySensor();
        assertEquals(0.0, sensor.getFuelMileage()); // Check whether Observer is notified with Event
    }

    @Test
    void Add_and_Remove_Observer() {
        FuelEfficiencySensor sensor = new FuelEfficiencySensor();

        double[] app = new double[1];
        Observer<MileageEventNotifier> appObserver = (sender, event) -> app[0] = event.getMileage();

        sensor.addObserver(appObserver);
        assertEquals(1, sensor.countObservers());

        sensor.removeObserver(appObserver);
        assertEquals(0, sensor.countObservers());
    }

    @Test
    void Get_All_Observers() {
        FuelEfficiencySensor sensor = new FuelEfficiencySensor();

        Observer<MileageEventNotifier> dash = (s, e) -> {};
        Observer<MileageEventNotifier> app = (s, e) -> {};

        sensor.addObserver(dash);
        sensor.addObserver(app);

        assertTrue(sensor.getObservers().contains(dash));
        assertTrue(sensor.getObservers().contains(app));
    }
}
