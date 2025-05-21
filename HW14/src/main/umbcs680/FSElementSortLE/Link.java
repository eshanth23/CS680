package umbcs680.FSElementSortLE;

import java.time.LocalDateTime;

class Link extends FSElement {
    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, 0, creationTime);
        this.target = target;
    }

    public FSElement getTarget() {
        return this.target;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }


}
