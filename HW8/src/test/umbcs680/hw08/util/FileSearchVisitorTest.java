package umbcs680.hw08.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.FileSystem;
import umbcs680.hw08.fs.TestFixtureInitializer;


import java.util.LinkedList;
import java.util.List;

public class FileSearchVisitorTest {
    private static FileSystem fs;
    private static Directory root;

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
        assertEquals(1, found.size(), "It has to fond 1 file named 'build.xml'");
        List<String> expected = new LinkedList<>();
        expected.add("build.xml");

        List<String> files = new LinkedList<>();
        for(File f: found){
            files.add(f.getName());
        }

        assertIterableEquals(expected, files, "Files with same name should be there in the list");
    }

    @Test
    public void File_Search_Visitor_NotFound() {
        FileSearchVisitor visitor = new FileSearchVisitor("notfound.txt");
        root.accept(visitor);

        List<File> found = visitor.getFoundFiles();
        assertTrue(found.isEmpty(), "Should not find any files named 'notfound.txt'");
    }
}
