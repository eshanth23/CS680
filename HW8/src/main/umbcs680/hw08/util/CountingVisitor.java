package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;

import java.util.HashSet;
import java.util.Set;

public class CountingVisitor implements FSVisitor {

    private int dirCount = 0;
    private int fileCount = 0;
    private int linkCount = 0;



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
        linkCount++;
    }

    @Override
    public void visit(Directory dir) {
       dirCount++;
    }

    @Override
    public void visit(File file) {
        fileCount++;
    }
}
