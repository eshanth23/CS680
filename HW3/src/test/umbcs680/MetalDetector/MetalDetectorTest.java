package umbcs680.MetalDetector;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MetalDetectorTest {

    @Test
    public void IdleToScanningTransition() {
        MetalDetector detector = new MetalDetector();
        detector.detectMotion();

        // Expected: ScanningState.class, Actual: detector.getState().getClass()
        assertEquals(ScanningState.class, detector.getState().getClass(),
                "Expected: ScanningState, Actual: " + detector.getState().getClass().getSimpleName());
    }

    @Test
    public void ScanningToAlarmTransition() {
        MetalDetector detector = new MetalDetector();
        detector.detectMotion(); // Move to scanning state
        detector.scanForMetal(true); // Metal detected

        // Expected: AlarmState.class, Actual: detector.getState().getClass()
        assertEquals(AlarmState.class, detector.getState().getClass(),
                "Expected: AlarmState, Actual: " + detector.getState().getClass().getSimpleName());
    }

    @Test
    public void ScanningToIdleTransition() {
        MetalDetector detector = new MetalDetector();
        detector.detectMotion(); // Move to scanning state
        detector.scanForMetal(false); // No metal detected

        // Expected: IdleState.class, Actual: detector.getState().getClass()
        assertEquals(IdleState.class, detector.getState().getClass(),
                "Expected: IdleState, Actual: " + detector.getState().getClass().getSimpleName());
    }

    @Test
    public void AlarmToIdleTransition() {
        MetalDetector detector = new MetalDetector();
        detector.detectMotion();
        detector.scanForMetal(true); // Metal detected, goes to alarm state
        detector.reset(); // Reset to idle

        // Expected: IdleState.class, Actual: detector.getState().getClass()
        assertEquals(IdleState.class, detector.getState().getClass(),
                "Expected: IdleState, Actual: " + detector.getState().getClass().getSimpleName());
    }
}
