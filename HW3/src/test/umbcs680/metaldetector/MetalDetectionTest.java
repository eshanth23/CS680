package umbcs680.metaldetector;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MetalDetectionTest {

    @Test
    public void Standby_To_Scanning_Transformation() {
        MetalDetection detector = new MetalDetection();
        detector.DetectForMotion();

        assertEquals(ScanningState.class, detector.getState().getClass(),
                "Expected: ScanningState, Actual: " + detector.getState().getClass().getSimpleName());
    }

    @Test
    public void Scanning_To_Alarm_Transformation() {
        MetalDetection detector = new MetalDetection();
        detector.DetectForMotion(); // Move to scanning state
        detector.ScanForMetal(true); // Metal detected


        assertEquals(AlarmState.class, detector.getState().getClass(),
                "Expected: AlarmState, Actual: " + detector.getState().getClass().getSimpleName());
    }

    @Test
    public void Alarm_To_Standby_Transformation() {
        MetalDetection detector = new MetalDetection();
        detector.DetectForMotion();
        detector.ScanForMetal(true); // Metal detected, goes to alarm state
        detector.Reset(); // Reset to Standby


        assertEquals(StandbyState.class, detector.getState().getClass(),
                "Expected: Standby, Actual: " + detector.getState().getClass().getSimpleName());
    }

    @Test
    public void Scanning_To_Standby_Transformation() {
        MetalDetection detector = new MetalDetection();
        detector.DetectForMotion(); // Move to scanning state
        detector.ScanForMetal(false); // No metal detected


        assertEquals(StandbyState.class, detector.getState().getClass(),
                "Expected: Standby, Actual: " + detector.getState().getClass().getSimpleName());
    }


}
