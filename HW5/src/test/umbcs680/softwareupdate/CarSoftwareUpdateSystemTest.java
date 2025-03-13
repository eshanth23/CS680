package umbcs680.softwareupdate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarSoftwareUpdateSystemTest {
    @Test
    void Software_Update_Notification() {
        CarBrand lambo = new CarBrand();
        CarModel aventador = new CarModel("Aventador");
        CarModel hurricane = new CarModel("Hurricane");

        lambo.addSoftwareObserver(aventador);
        lambo.addSoftwareObserver(hurricane);

        lambo.notifySoftwareUpdate(new SoftwareUpdateEvent("Version 11.2"));

        assertEquals("Version 11.2", aventador.getLatestSoftwareVersion());
        assertEquals("Version 11.2", hurricane.getLatestSoftwareVersion());
    }

    @Test
    void Bug_Fix_Notification() {
        CarBrand lambo = new CarBrand();
        CarModel aventador = new CarModel("Aventador");

        lambo.addBugFixObserver(aventador);

        lambo.notifyBugFix(new BugFixEvent("Fixed Brake Issue"));

        assertEquals("Fixed Brake Issue", aventador.getLatestBugFix());
    }

    @Test
    void Remove_Software_Observer() {
        CarBrand lambo = new CarBrand();
        CarModel hurricane = new CarModel("Hurricane");

        lambo.addSoftwareObserver(hurricane);
        lambo.removeSoftwareObserver(hurricane);

        lambo.notifySoftwareUpdate(new SoftwareUpdateEvent("Version 12.5"));

        assertNull(hurricane.getLatestSoftwareVersion());
    }

    @Test
    void Remove_Bug_Fix_Observer() {
        CarBrand lambo = new CarBrand();
        CarModel aventador = new CarModel("Aventador");

        lambo.addBugFixObserver(aventador);
        lambo.removeBugFixObserver(aventador);

        lambo.notifyBugFix(new BugFixEvent("Engine Issue Fixed"));

        assertNull(aventador.getLatestBugFix());
    }
}
