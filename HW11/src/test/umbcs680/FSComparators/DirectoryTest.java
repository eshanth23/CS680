package umbcs680.FSComparators;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class DirectoryTest {
    private static FileSystem Fs;
    private static LocalDateTime fixedTime;

    @BeforeAll
    public static void setUpFS() {
        Fs = TestFixtureInitializer.createFS();
        fixedTime = Fs.getRootDirs().getFirst().getCreationTime();
    }

    private String[] dir_To_StringArray(Directory d) {
        return new String[]{
                d.getName(),
                String.valueOf(d.getSize()),
                d.getCreationTime().toString(),
                (d.getParent() != null) ? d.getParent().getName() : "null"
        };
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        Directory root = Fs.getRootDirs().getFirst();

        String[] expected = {
                "umbcs680", "0", fixedTime.toString(), "null"
        };

        assertArrayEquals(expected, dir_To_StringArray(root));
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        Directory home = Fs.getRootDirs().getFirst().getSubDirectories().getFirst();

        String[] expected = {
                "hw01", "0", fixedTime.toString(), "umbcs680"
        };

        assertArrayEquals(expected, dir_To_StringArray(home));
    }

    @Test
    public void verifyDirectoryEqualitySrc() {
        Directory src = Fs.getRootDirs().getFirst()
                .getSubDirectories().getFirst()
                .getSubDirectories().getFirst();

        String[] expected = {
                "src", "0", fixedTime.toString(), "hw01"
        };

        assertArrayEquals(expected, dir_To_StringArray(src));
    }
}
