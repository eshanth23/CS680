package umbcs680.FSEInternalIteration;



import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AlphabeticalComparatorTest {
    private static Directory root;

    @BeforeAll
    public static void setUpFS() {
        FileSystem fs = TestFixtureInitializer.createFS();
        root = fs.getRootDirs().get(0);
    }

    @Test
    public void Root_Children_AlphabeticalSorting() {
        List<FSElement> rootChildren = new ArrayList<>(root.getChildren());
        Collections.sort(rootChildren, Comparator.comparing(FSElement::getName));

        List<String> expected = List.of("hw01", "readme.md");
        List<String> actual = new ArrayList<>();
        for (FSElement element : rootChildren) {
            actual.add(element.getName());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void hw01_Children_AlphabeticalSorting() {
        Directory hw01 = null;
        for (FSElement element : root.getChildren()) {
            if (element.getName().equals("hw01") && element instanceof Directory) {
                hw01 = (Directory) element;
                break;
            }
        }
        assertNotNull(hw01);

        List<FSElement> hw01Children = new ArrayList<>(hw01.getChildren());
        Collections.sort(hw01Children, Comparator.comparing(FSElement::getName));

        List<String> expected = List.of("build.xml", "rm.md", "src");
        List<String> actual = new ArrayList<>();
        for (FSElement element : hw01Children) {
            actual.add(element.getName());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void Src_Children_AlphabeticalSorting() {
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
        Collections.sort(srcChildren, Comparator.comparing(FSElement::getName));

        List<String> expected = List.of("A.java", "B.java");
        List<String> actual = new ArrayList<>();
        for (FSElement element : srcChildren) {
            actual.add(element.getName());
        }

        assertEquals(expected, actual);
    }
}
