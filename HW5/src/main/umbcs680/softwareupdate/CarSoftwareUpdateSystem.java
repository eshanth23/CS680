package umbcs680.softwareupdate;
import java.util.*;



class SoftwareUpdateEvent {
    private final String version;

    public SoftwareUpdateEvent(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}

class BugFixEvent {
    private final String bugDetails;

    public BugFixEvent(String bugDetails) {
        this.bugDetails = bugDetails;
    }

    public String getBugDetails() {
        return bugDetails;
    }
}

// Observer Interfaces
interface SoftwareUpdateObserver {
    void updateSoftware(SoftwareUpdateEvent event);
}

interface BugFixObserver {
    void updateBugFix(BugFixEvent event);
}

// Observable Class
class CarBrand {
    private final List<SoftwareUpdateObserver> softwareObservers = new ArrayList<>();
    private final List<BugFixObserver> bugFixObservers = new ArrayList<>();

    public void addSoftwareObserver(SoftwareUpdateObserver observer) {
        softwareObservers.add(observer);
    }

    public void removeSoftwareObserver(SoftwareUpdateObserver observer) {
        softwareObservers.remove(observer);
    }

    public void addBugFixObserver(BugFixObserver observer) {
        bugFixObservers.add(observer);
    }

    public void removeBugFixObserver(BugFixObserver observer) {
        bugFixObservers.remove(observer);
    }

    public void notifySoftwareUpdate(SoftwareUpdateEvent event) {
        softwareObservers.forEach(observer -> observer.updateSoftware(event));
    }

    public void notifyBugFix(BugFixEvent event) {
        bugFixObservers.forEach(observer -> observer.updateBugFix(event));
    }
}

// CarModel as Observer
class CarModel implements SoftwareUpdateObserver, BugFixObserver {
    private final String model;
    private String latestSoftwareVersion;
    private String latestBugFix;

    public CarModel(String model) {
        this.model = model;
    }

    public String getLatestSoftwareVersion() {
        return latestSoftwareVersion;
    }

    public String getLatestBugFix() {
        return latestBugFix;
    }

    @Override
    public void updateSoftware(SoftwareUpdateEvent event) {
        this.latestSoftwareVersion = event.getVersion();
    }

    @Override
    public void updateBugFix(BugFixEvent event) {
        this.latestBugFix = event.getBugDetails();
    }
}