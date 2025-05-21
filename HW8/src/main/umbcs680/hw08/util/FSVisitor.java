package umbcs680.hw08.util;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.Link;

public interface FSVisitor {
    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);
}
