package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;

import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class FileCrawlingVisitor implements FSVisitor {
    private List<File> files = new LinkedList<>();
    private Set<FSElement> visited = new HashSet<>();

    @Override
    public void visit(Link link) {
        if (visited.contains(link)) return;
        visited.add(link);

        FSElement target = link.getTarget();
        if (target != null && !visited.contains(target)) {
            target.accept(this);
        }
    }

    @Override
    public void visit(Directory dir) {
        if (visited.contains(dir)) return;
        visited.add(dir);


        for (FSElement child : dir.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(File file) {

        if (visited.contains(file)) return;
        visited.add(file);

        files.add(file);
    }

    public List<File> getFiles() {
        return files;
    }
}
