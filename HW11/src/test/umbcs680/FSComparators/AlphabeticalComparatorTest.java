package umbcs680.FSComparators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlphabeticalComparatorTest {

    static FileSystem fs;
    static Directory root;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
       root = fs.getRootDirs().getFirst();
    }


    @Test
    public void Root_Children_Alphabetical_Order() {
        List<FSElement> sorted = root.getChildren(new AlphabeticalComparator());
        assertEquals("hw01", sorted.get(0).getName());
        assertEquals("readme.md", sorted.get(1).getName());
    }

    @Test
    public void HW01_Children_Alphabetical_Order() {
        Directory hw01 = null;
        for (FSElement child : root.getChildren()) {
            if (child instanceof Directory && child.getName().equals("hw01")) {
                hw01 = (Directory) child;
                break;
            }
        }
        assertNotNull(hw01);

        List<FSElement> children = hw01.getChildren(new AlphabeticalComparator());
        assertEquals("build.xml", children.get(0).getName());
        assertEquals("rm.md", children.get(1).getName());
        assertEquals("src", children.get(2).getName());
    }

    @Test
    public void Src_Children_Alphabetical_Order() {
        Directory hw01 = null;
        for (FSElement child : root.getChildren()) {
            if (child instanceof Directory && child.getName().equals("hw01")) {
                hw01 = (Directory) child;
                break;
            }
        }
        assertNotNull(hw01);

        Directory src = null;
        for (FSElement child : hw01.getChildren()) {
            if (child instanceof Directory && child.getName().equals("src")) {
                src = (Directory) child;
                break;
            }
        }
        assertNotNull(src);

        List<FSElement> children = src.getChildren(new AlphabeticalComparator());
        assertEquals("A.java", children.get(0).getName());
        assertEquals("B.java", children.get(1).getName());
    }
    @Test
    public void HW01_SubDirs_Sorting() {
        Directory hw01 = null;
        for (FSElement e : root.getChildren()) {
            if (e instanceof Directory && e.getName().equals("hw01")) {
                hw01 = (Directory) e;
                break;
            }
        }
        assertNotNull(hw01);
        List<Directory> dirs = hw01.getSubDirectories(new AlphabeticalComparator());
        assertEquals("src", dirs.get(0).getName());
    }

    @Test
    public void HW01_Link_Sorting() {
        Directory hw01 = null;
        for (FSElement e : root.getChildren()) {
            if (e instanceof Directory && e.getName().equals("hw01")) {
                hw01 = (Directory) e;
                break;
            }
        }
        assertNotNull(hw01);
        List<Link> links = hw01.getLinks(new AlphabeticalComparator());
        assertEquals("rm.md", links.get(0).getName());
    }

}
