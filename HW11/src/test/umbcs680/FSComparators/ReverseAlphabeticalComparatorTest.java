package umbcs680.FSComparators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseAlphabeticalComparatorTest {

    static FileSystem fs;
    static Directory root;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        root = fs.getRootDirs().getFirst();
    }

    @Test
    public void Root_Children_Reverse_Order() {
        List<FSElement> sorted = root.getChildren(new ReverseAlphabeticalComparator());
        assertEquals("readme.md", sorted.get(0).getName());
        assertEquals("hw01", sorted.get(1).getName());
    }

    @Test
    public void HW01_Children_Reverse_Order() {
        Directory hw01 = null;
        for (FSElement child : root.getChildren()) {
            if (child instanceof Directory && child.getName().equals("hw01")) {
                hw01 = (Directory) child;
                break;
            }
        }
        assertNotNull(hw01);

        List<FSElement> sorted = hw01.getChildren(new ReverseAlphabeticalComparator());
        assertEquals("src", sorted.get(0).getName());
        assertEquals("rm.md", sorted.get(1).getName());
        assertEquals("build.xml", sorted.get(2).getName());
    }

    @Test
    public void Src_Children_Reverse_Order() {
        Directory hw01 = null, src = null;
        for (FSElement child : root.getChildren()) {
            if (child instanceof Directory && child.getName().equals("hw01")) {
                hw01 = (Directory) child;
                break;
            }
        }
        assertNotNull(hw01);

        for (FSElement child : hw01.getChildren()) {
            if (child instanceof Directory && child.getName().equals("src")) {
                src = (Directory) child;
                break;
            }
        }
        assertNotNull(src);

        List<FSElement> sorted = src.getChildren(new ReverseAlphabeticalComparator());
        assertEquals("B.java", sorted.get(0).getName());
        assertEquals("A.java", sorted.get(1).getName());
    }
}
