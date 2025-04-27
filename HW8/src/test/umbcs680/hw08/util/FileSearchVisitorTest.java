package umbcs680.hw08.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.FileSystem;
import umbcs680.hw08.fs.TestFixtureInitializer;


import java.util.List;

public class FileSearchVisitorTest {
    static FileSystem fs;
    static Directory root;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        root = fs.getRootDirs().getFirst();
    }

    @Test
    public void File_Search_Visitor_Found() {
        FileSearchVisitor visitor = new FileSearchVisitor("build.xml");
        root.accept(visitor);

        List<File> found = visitor.getFoundFiles();
        assertEquals(1, found.size(), "It has to find 1 file named 'build.xml'");
        assertEquals("build.xml", found.get(0).getName());
    }

    @Test
    public void File_Search_Visitor_NotFound() {
        FileSearchVisitor visitor = new FileSearchVisitor("notfound.txt");
        root.accept(visitor);

        List<File> found = visitor.getFoundFiles();
        assertTrue(found.isEmpty(), "Should not find any files named 'notfound.txt'");
    }
}
