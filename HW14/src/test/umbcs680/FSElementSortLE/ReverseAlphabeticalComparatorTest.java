package umbcs680.FSElementSortLE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReverseAlphabeticalComparatorTest {
    private Directory root;

    @BeforeEach
    public void setUpFS() {
        FileSystem fs = TestFixtureInitializer.createFS();
        root = fs.getRootDirs().get(0);
    }

    @Test
    public void Root_Children_ReverseAlphabeticalSorting() {
        List<FSElement> rootChildren = new ArrayList<>(root.getChildren());
        rootChildren.sort(Comparator.comparing(FSElement::getName).reversed());

        List<String> expected = List.of("readme.md", "hw01");
        List<String> actual = new ArrayList<>();
        for (FSElement element : rootChildren) {
            actual.add(element.getName());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void hw01_Children_ReverseAlphabeticalSorting() {
        Directory hw01 = null;
        for (FSElement element : root.getChildren()) {
            if (element.getName().equals("hw01") && element instanceof Directory) {
                hw01 = (Directory) element;
                break;
            }
        }
        assertNotNull(hw01);

        List<FSElement> hw01Children = new ArrayList<>(hw01.getChildren());
        hw01Children.sort(Comparator.comparing(FSElement::getName).reversed());

        List<String> expected = List.of("src", "rm.md", "build.xml");
        List<String> actual = new ArrayList<>();
        for (FSElement element : hw01Children) {
            actual.add(element.getName());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void Src_Children_ReverseAlphabeticalSorting() {
        Directory hw01 = null;
        for (FSElement element : root.getChildren()) {
            if (element.getName().equals("hw01") && element instanceof Directory) {
                hw01 = (Directory) element;
                break;
            }
        }
        assertNotNull(hw01);

        Directory src = null;
        for (FSElement element : hw01.getChildren()) {
            if (element.getName().equals("src") && element instanceof Directory) {
                src = (Directory) element;
                break;
            }
        }
        assertNotNull(src);

        List<FSElement> srcChildren = new ArrayList<>(src.getChildren());
        srcChildren.sort(Comparator.comparing(FSElement::getName).reversed());

        List<String> expected = List.of( "B.java","A.java");
        List<String> actual = new ArrayList<>();
        for (FSElement element : srcChildren) {
            actual.add(element.getName());
        }

        assertEquals(expected, actual);
    }
}
