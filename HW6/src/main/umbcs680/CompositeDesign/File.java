package umbcs680.CompositeDesign;

import java.time.LocalDateTime;

class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public String[] toStringArray() {
        return new String[] { this.name, Integer.toString(this.size) };
    }
}

