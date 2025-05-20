package umbcs680.hw08.fs;

import umbcs680.hw08.util.FSVisitor;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> dirs = new LinkedList<>();
        for (FSElement e : children)
            if (e instanceof Directory) dirs.add((Directory)e);
        return dirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement e : children)
            if (e instanceof File) files.add((File)e);
        return files;
    }

    public int countChildren() {
        return this.children.size();
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
        for (FSElement e : children) {
            e.accept(visitor);
        }
    }
}
