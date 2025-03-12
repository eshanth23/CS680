package umbcs680.softwareupdate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class  CarSoftwareUpdateSystemTest {

    @Test
    void Lamborghini_Software_Updates() {
        CarBrand lambo = new CarBrand("Lamborghini");

        CarModel aventador = new CarModel("Lamborghini Aventador");
        CarModel hurricane = new CarModel("Lamborghini Hurricane");

        lambo.addObserver(aventador);
        lambo.addObserver(hurricane);


        assertEquals(2, lambo.countObservers());


        lambo.softwarereleaseUpdates("v10.22.5 - Quick Shifters Update");


        lambo.removeObserver(hurricane);
        assertEquals(1, lambo.countObservers());


        lambo.softwarereleaseUpdates("v11.0.55 - AI Powered Voice Controls");
    }

        @Test
        void Ferrari_Software_Updates () {
            CarBrand ferrari = new CarBrand("Ferrari");

            CarModel Spider = new CarModel("Ferrari Spider");
            CarModel GTB = new CarModel("Ferrari 296 GTB");

            ferrari.addObserver(Spider);
            ferrari.addObserver(GTB);


            assertEquals(2, ferrari.countObservers());


            ferrari.softwarereleaseUpdates("v10.22.5 - Quick Shifters Update");


            ferrari.removeObserver(Spider);
            assertEquals(1, ferrari.countObservers());


            ferrari.softwarereleaseUpdates("v11.0.55 - AI Powered Voice Controls");


        }
    }

