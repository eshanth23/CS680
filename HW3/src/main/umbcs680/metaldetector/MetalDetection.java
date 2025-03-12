package umbcs680.metaldetector;

interface MetalDetectionState {
    void DetectForMotion(MetalDetection detector);
    void ScanForMetal(MetalDetection detector, boolean metalDetected);
    void Reset(MetalDetection detector);
}

// Standby State
class StandbyState implements MetalDetectionState {
    public void DetectForMotion(MetalDetection detector) {

        detector.setState(new ScanningState());
    }

    public void ScanForMetal(MetalDetection detector, boolean metalDetected) {

    }

    public void Reset(MetalDetection detector) {

    }
}

// Scanning State
class ScanningState implements MetalDetectionState {
    public void DetectForMotion(MetalDetection detector) {

    }

    public void ScanForMetal(MetalDetection detector, boolean metalDetected) {
        if (metalDetected) {
            detector.setState(new AlarmState());
        } else {
            detector.setState(new StandbyState());
        }
    }

    public void Reset(MetalDetection detector) {

        detector.setState(new StandbyState());
    }
}

// Alarm State
class AlarmState implements MetalDetectionState {
    public void DetectForMotion(MetalDetection detector) {

    }

    public void ScanForMetal(MetalDetection detector, boolean metalDetected) {

    }

    public void Reset(MetalDetection detector) {

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
}

