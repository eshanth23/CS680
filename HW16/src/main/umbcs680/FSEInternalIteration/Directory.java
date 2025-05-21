package umbcs680.FSEInternalIteration;

import java.time.LocalDateTime;
import java.util.*;

public class Directory extends FSElement {
    private List<FSElement> children;

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
        return children.size();
    }

    public List<FSElement> getChildren() {
        return new LinkedList<>(children);
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator) {
        LinkedList<FSElement> sorted = new LinkedList<>(children);
        sorted.sort(comparator);
        return sorted;
    }

    public List<Directory> getSubDirectories() {
        List<Directory> dirs = new ArrayList<>();
        children.forEach(e -> {
            if (e instanceof Directory) {
                dirs.add((Directory) e);
            }
        });
        dirs.sort(Comparator.comparing(FSElement::getName));
        return dirs;
    }

    public List<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        List<Directory> dirs = new ArrayList<>();
        children.forEach(e -> {
            if (e instanceof Directory) {
                dirs.add((Directory) e);
            }
        });
        dirs.sort(comparator);
        return dirs;
    }

    public List<File> getFiles() {
        List<File> files = new ArrayList<>();
        children.forEach(e -> {
            if (e instanceof File) {
                files.add((File) e);
            }
        });
        files.sort(Comparator.comparing(FSElement::getName));
        return files;
    }

    public List<File> getFiles(Comparator<FSElement> comparator) {
        List<File> files = new ArrayList<>();
        children.forEach(e -> {
            if (e instanceof File) {
                files.add((File) e);
            }
        });
        files.sort(comparator);
        return files;
    }

    public List<Link> getLinks() {
        List<Link> links = new ArrayList<>();
        children.forEach(e -> {
            if (e instanceof Link) {
                links.add((Link) e);
            }
        });
        links.sort(Comparator.comparing(FSElement::getName));
        return links;
    }

    public List<Link> getLinks(Comparator<FSElement> comparator) {
        List<Link> links = new ArrayList<>();
        children.forEach(e -> {
            if (e instanceof Link) {
                links.add((Link) e);
            }
        });
        links.sort(comparator);
        return links;
    }
}
