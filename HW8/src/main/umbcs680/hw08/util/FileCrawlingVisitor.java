package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;

import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class FileCrawlingVisitor implements FSVisitor {
    private List<File> files = new LinkedList<>();

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
        files.add(file);
    }

    public List<File> getFiles() {
        return files;
    }
}
