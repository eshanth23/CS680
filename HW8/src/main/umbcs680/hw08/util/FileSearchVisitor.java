package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;

import java.util.LinkedList;
import java.util.List;

public class FileSearchVisitor implements FSVisitor {
    private String fileName;
    private List<File> foundFiles;

    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
        this.foundFiles = new LinkedList<>();
    }

    @Override
    public void visit(Link link) {
        return ;
    }

    @Override
    public void visit(Directory dir) {
        return ;
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(fileName)) {
            foundFiles.add(file);
        }
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
