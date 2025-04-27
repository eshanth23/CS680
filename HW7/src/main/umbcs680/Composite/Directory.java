package umbcs680.Composite;

import java.time.LocalDateTime;
import java.util.LinkedList;

class Directory extends FSElement {
    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);  // Size is always 0 for directories
        this.children = new LinkedList<>();
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
    }

    public int countChildren() {
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirs = new LinkedList<>();
        for (FSElement e : children) {
            if (e.isDirectory()) {
                subDirs.add((Directory) e);
            }
        }
        return subDirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof File) {
                files.add((File) e);
            }
        }
        return files;
    }

    public LinkedList<Link> getLinks() {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof Link) {
                links.add((Link) e);
            }
        }
        return links;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement e : children) {
            if (e.isDirectory()) {
                totalSize += ((Directory) e).getTotalSize();
            } else {
                totalSize += e.getSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }


}
