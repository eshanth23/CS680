package umbcs680.metaldetector;

interface MetalDetectionState {
    void DetectForMotion(MetalDetection detector);
    void ScanForMetal(MetalDetection detector, boolean metalDetected);
    void Reset(MetalDetection detector);
}

// Standby State
class StandbyState implements MetalDetectionState {
    public void DetectForMotion(MetalDetection detector) {
        System.out.println("BEEP! BEEP! There was a Motion Detected! System transforming to Scanning State...");
        detector.setState(new ScanningState());
    }

    public void ScanForMetal(MetalDetection detector, boolean metalDetected) {
        System.out.println("'Zzz' Iam in Standby: No scanning happening.");
    }

    public void Reset(MetalDetection detector) {
        System.out.println("Already in Standby State.");
    }
}

// Scanning State
class ScanningState implements MetalDetectionState {
    public void DetectForMotion(MetalDetection detector) {
        System.out.println("BEEP! BEEP! Iam Already in scanning state...");
    }

    public void ScanForMetal(MetalDetection detector, boolean metalDetected) {
        if (metalDetected) {
            System.out.println("Alert! Alert! Metal has been detected! Iam Changing to Alarm State 'woo-woo' ...");
            detector.setState(new AlarmState());
        } else {
            System.out.println("All Good! No metal was detected. Returning to Standby State...");
            detector.setState(new StandbyState());
        }
    }

    public void Reset(MetalDetection detector) {
        System.out.println("BYE BYE Iam going back to Standby State 'Zzz'...");
        detector.setState(new StandbyState());
    }
}

// Alarm State
class AlarmState implements MetalDetectionState {
    public void DetectForMotion(MetalDetection detector) {
        System.out.println("BEEP! BEEP! Alarm sounding! Please wait for the security check.");
        System.out.println();
    }

    public void ScanForMetal(MetalDetection detector, boolean metalDetected) {
        System.out.println("Iam already in Alarm State.");
    }

    public void Reset(MetalDetection detector) {
        System.out.println("Security check completed. Iam going back to Standby State 'Zzz'...");
        detector.setState(new StandbyState());
    }
}


class MetalDetection {
    private MetalDetectionState state;

    public MetalDetection() {
        state = new StandbyState(); // Initial state is Standby
    }

    public void setState(MetalDetectionState state) {
        this.state = state;
    }

    public MetalDetectionState getState() {
        return this.state;  // To retrieve the current state (for testing purposes)
    }

    public void DetectForMotion() {
        state.DetectForMotion(this);
    }

    public void ScanForMetal(boolean metalDetected) {
        state.ScanForMetal(this, metalDetected);
    }

    public void Reset() {
        state.Reset(this);
    }


// Usage

    public static void main(String[] args) {
        MetalDetection detector = new MetalDetection();

        // Simulating a person walking through
        detector.DetectForMotion();
        detector.ScanForMetal(true); // Metal detected

        // Reset after security check
        detector.Reset();

        // Another person walks through
        detector.DetectForMotion();
        detector.ScanForMetal(false); // No metal detected
    }

}