package umbcs680.FSComparators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseAlphabeticalComparatorTest {

    private static FileSystem fs;
    private static Directory root;

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

        List<FSElement> children = hw01.getChildren(new ReverseAlphabeticalComparator());
        assertEquals("src", children.get(0).getName());
        assertEquals("rm.md", children.get(1).getName());
        assertEquals("build.xml", children.get(2).getName());
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

        List<FSElement> children = src.getChildren(new ReverseAlphabeticalComparator());
        assertEquals("B.java", children.get(0).getName());
        assertEquals("A.java", children.get(1).getName());
    }
    @Test
    public void HW01_SubDirs_Reverse_Order() {
        Directory hw01 = null;
        for (FSElement e : root.getChildren()) {
            if (e instanceof Directory && e.getName().equals("hw01")) {
                hw01 = (Directory) e;
                break;
            }
        }
        assertNotNull(hw01);
        List<Directory> dirs = hw01.getSubDirectories(new ReverseAlphabeticalComparator());
        assertEquals("src", dirs.get(0).getName());
    }

    @Test
    public void HW01_Link_Reverse_Order() {
        Directory hw01 = null;
        for (FSElement e : root.getChildren()) {
            if (e instanceof Directory && e.getName().equals("hw01")) {
                hw01 = (Directory) e;
                break;
            }
        }
        assertNotNull(hw01);
        List<Link> links = hw01.getLinks(new ReverseAlphabeticalComparator());
        assertEquals("rm.md", links.get(0).getName());
    }
}
