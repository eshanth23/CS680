package umbcs680.hw08.fs;

import umbcs680.hw08.util.FSVisitor;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }
}
