package umbcs680.FSComparators;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class FileSystemTest {
    static FileSystem Fs;

    @BeforeAll
    public static void setUpFS() {
        Fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void Root_Of_FileSystem() {

        assertEquals("umbcs680", Fs.getRootDirs().getFirst().getName());

    }

    @Test
    public void Children_Of_Root() {
        Directory root = Fs.getRootDirs().getFirst();
        assertEquals(2, root.countChildren());
    }

    @Test
    public void FileSystem_Hierarchy() {
        Directory root = Fs.getRootDirs().getFirst();
        Directory home = root.getSubDirectories().getFirst();
        Directory src = home.getSubDirectories().getFirst();

        assertEquals("hw01", home.getName());
        assertEquals("src", src.getName());

        File aJava = src.getFiles().get(0);
        File bJava = src.getFiles().get(1);

        assertEquals("A.java", aJava.getName());
        assertEquals("B.java", bJava.getName());
    }
}

