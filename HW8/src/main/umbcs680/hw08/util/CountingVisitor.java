package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;

import java.util.HashSet;
import java.util.Set;

public class CountingVisitor implements FSVisitor {

    private int dirCount = 0;
    private int fileCount = 0;
    private int linkCount = 0;

    private Set<FSElement> visited = new HashSet<>();

    public int getDirCount() {
        return dirCount;
    }

    public int getFileCount() {
        return fileCount;
    }

    public int getLinkCount() {
        return linkCount;
    }

    @Override
    public void visit(Link link) {
        if (visited.contains(link)) return;
        visited.add(link);

        linkCount++;

        FSElement target = link.getTarget();
        if (target != null && !visited.contains(target)) {
            target.accept(this);
        }
    }

    @Override
    public void visit(Directory dir) {
        if (visited.contains(dir)) return;
        visited.add(dir);

       dirCount++;

        for (FSElement child : dir.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(File file) {
        if (visited.contains(file)) return;
        visited.add(file);

        fileCount++;
    }
}
