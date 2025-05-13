package umbcs680.FSElementSortLE;



import java.time.LocalDateTime;
import java.util.*;

public class Directory extends FSElement {
    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        this.children = new LinkedList<>();
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);

    }

    public int countChildren() {
        return this.children.size();
    }

    public LinkedList<FSElement> getChildren() {
        return new LinkedList<>(children);
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator) {
        LinkedList<FSElement> sorted = new LinkedList<>(children);
        sorted.sort(comparator);
        return sorted;
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> dirs = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof Directory)
                dirs.add((Directory) e);
        }
        return dirs;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        LinkedList<Directory> dirs = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof Directory)
                dirs.add((Directory) e);
        }
        dirs.sort(comparator);
        return dirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof File)
                files.add((File) e);
        }
        return files;  // Default: no sorting
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator) {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof File)
                files.add((File) e);
        }
        files.sort(comparator);
        return files;
    }

    public LinkedList<Link> getLinks() {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof Link)
                links.add((Link) e);
        }
        return links;
    }

    public LinkedList<Link> getLinks(Comparator<FSElement> comparator) {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof Link)
                links.add((Link) e);
        }
        links.sort(comparator);
        return links;
    }
}

