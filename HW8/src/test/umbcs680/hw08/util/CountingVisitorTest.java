package umbcs680.hw08.util;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.FileSystem;
import umbcs680.hw08.fs.TestFixtureInitializer;

public class CountingVisitorTest {
    private static FileSystem fs;
    private static Directory root;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        root = fs.getRootDirs().getFirst();
    }

    @Test
    public void Counting_Visitor_Counts_Correctly() {
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);

        assertEquals(3, visitor.getDirCount());
        assertEquals(4, visitor.getFileCount());
        assertEquals(1, visitor.getLinkCount());
    }
}
