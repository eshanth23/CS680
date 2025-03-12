package umbcs680.softwareupdate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CarSoftwareUpdateSystemTest {
    @Test
    void Software_Updated_Notifications() {
        CarBrand lambo = new CarBrand("Lamborghini");
        CarModel aventador = new CarModel("aventador");
        CarModel hurricane = new CarModel("hurricane");

        lambo.addObserver(aventador);
        lambo.addObserver(hurricane);

        lambo.software_release_updates("Version 11.2");

        assertEquals("Version 11.2", aventador.getLatestUpdates());
        assertEquals("Version 11.2", hurricane.getLatestUpdates());
    }

    @Test
    void CarModel_Updates_To_Brand() {
        CarBrand lambo = new CarBrand("Lamborghini");
        CarModel aventador = new CarModel("aventador");
        lambo.addObserver(aventador);
        aventador.addObserver(lambo); // Model Y can send feedback

        lambo.software_release_updates("Version 11.22.0");

        assertEquals("Version 11.22.0", aventador.getLatestUpdates());
    }

    @Test
    void Remove_Observers() {
        CarBrand lambo = new CarBrand("Lamborghini");
        CarModel hurricane = new CarModel("hurricane");
        lambo.addObserver(hurricane);

       lambo.software_release_updates("Version 12.55.0");
        assertEquals("Version 12.55.0", hurricane.getLatestUpdates());

        lambo.removeObserver(hurricane);
        lambo.software_release_updates("Version 12.55.0");
        assertEquals("Version 12.55.0", hurricane.getLatestUpdates()); // Should not change
    }

    @Test
    void Clear_Observers() {
        CarBrand lambo = new CarBrand("Lamborghini");
        CarModel hurricane = new CarModel("hurricane");
        lambo.addObserver(hurricane);

        lambo.clearObservers();
        assertEquals(0, lambo.countObservers());
    }
}