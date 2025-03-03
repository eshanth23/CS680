package umbcs680.MetalDetector;

// State Interface
interface MetalDetectorState {
    void detectMotion(MetalDetector detector);
    void scanForMetal(MetalDetector detector, boolean metalDetected);
    void reset(MetalDetector detector);
}

// Idle State
class IdleState implements MetalDetectorState {
    public void detectMotion(MetalDetector detector) {
        System.out.println("Motion has been detected! System transitioning to Scanning State...");
        detector.setState(new ScanningState());
    }

    public void scanForMetal(MetalDetector detector, boolean metalDetected) {
        System.out.println("Idle: No scanning happening.");
    }

    public void reset(MetalDetector detector) {
        System.out.println("Already in Idle State.");
    }
}

// Scanning State
class ScanningState implements MetalDetectorState {
    public void detectMotion(MetalDetector detector) {
        System.out.println("Already scanning...");
    }

    public void scanForMetal(MetalDetector detector, boolean metalDetected) {
        if (metalDetected) {
            System.out.println("Alert! Metal has been detected! Transitioning to Alarm State...");
            detector.setState(new AlarmState());
        } else {
            System.out.println("No metal was detected. Returning to Idle State...");
            detector.setState(new IdleState());
        }
    }

    public void reset(MetalDetector detector) {
        System.out.println("Resetting to Idle State...");
        detector.setState(new IdleState());
    }
}

// Alarm State
class AlarmState implements MetalDetectorState {
    public void detectMotion(MetalDetector detector) {
        System.out.println("Alarm sounding! Please wait for security check.");
    }

    public void scanForMetal(MetalDetector detector, boolean metalDetected) {
        System.out.println("Already in Alarm State.");
    }

    public void reset(MetalDetector detector) {
        System.out.println("Security check completed. Resetting to Idle State...");
        detector.setState(new IdleState());
    }
}

// Context Class: Metal Detector
class MetalDetector {
    private MetalDetectorState state;

    public MetalDetector() {
        state = new IdleState(); // Initial state is Idle
    }

    public void setState(MetalDetectorState state) {
        this.state = state;
    }

    public MetalDetectorState getState() {
        return this.state;  // To retrieve the current state (for testing purposes)
    }

    public void detectMotion() {
        state.detectMotion(this);
    }

    public void scanForMetal(boolean metalDetected) {
        state.scanForMetal(this, metalDetected);
    }

    public void reset() {
        state.reset(this);
    }


// Usage

    public static void main(String[] args) {
        MetalDetector detector = new MetalDetector();

        // Simulating a person walking through
        detector.detectMotion();
        detector.scanForMetal(true); // Metal detected

        // Reset after security check
        detector.reset();

        // Another person walks through
        detector.detectMotion();
        detector.scanForMetal(false); // No metal detected
    }

}