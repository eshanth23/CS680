package umbcs680.FSEInternalIteration;


import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

class LinkTest {
    private static FileSystem Fs;
    private static LocalDateTime fixedTime;

    @BeforeAll
    public static void setUpFS() {
        Fs = TestFixtureInitializer.createFS();
        fixedTime = Fs.getRootDirs().getFirst().getCreationTime();
    }

    private String[] linkToStringArray(Link l) {
        return new String[] {
                l.getName(),
                String.valueOf(l.getSize()),
                l.getCreationTime().toString(),
                l.getParent().getName(),
                l.getTarget().getName()
        };
    }

    @Test
    public void verifyLinkEquality_rmmd() {
        Link rmLink = null;
        LinkedList<FSElement> children = (LinkedList<FSElement>) Fs.getRootDirs().getFirst()
                .getSubDirectories().getFirst().getChildren();

        for (FSElement elem : children) {
            if (elem instanceof Link && elem.getName().equals("rm.md")) {
                rmLink = (Link) elem;
                break;
            }
        }

        assertNotNull(rmLink);

        String[] expected = { "rm.md", "0", fixedTime.toString(), "hw01", "readme.md" };
        assertArrayEquals(expected, linkToStringArray(rmLink));
    }
}




