package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;

import java.util.LinkedList;
import java.util.List;

public class FileSearchVisitor implements FSVisitor {
    private String fileName;
    private List<File> foundFiles = new LinkedList<>();

    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void visit(Link link) {
        FSElement target = link.getTarget();
        if (target instanceof File file && file.getName().equals(fileName) && !foundFiles.contains(file)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory dir) {
        for (FSElement child : dir.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(fileName) && !foundFiles.contains(file)) {
            foundFiles.add(file);
        }
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
