package umbcs680.FSElementSortLE;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class FileTest {
    private static FileSystem fs;
    private static LocalDateTime fixedTime;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        fixedTime = fs.getRootDirs().getFirst().getCreationTime();
    }

    private String[] fileToStringArray(File f) {
        return new String[]{
                f.getName(),
                String.valueOf(f.getSize()),
                f.getCreationTime().toString(),
                f.getParent().getName()
        };
    }

    @Test
    public void verifyFileEqualityAjava() {
        File aJava = fs.getRootDirs().getFirst()
                .getSubDirectories().getFirst()
                .getSubDirectories().getFirst()
                .getFiles().get(0);

        String[] expected = { "A.java", "30", fixedTime.toString(), "src" };
        assertArrayEquals(expected, fileToStringArray(aJava));
    }

    @Test
    public void verifyFileEqualityBjava() {
        File bJava = fs.getRootDirs().getFirst()
                .getSubDirectories().getFirst()
                .getSubDirectories().getFirst()
                .getFiles().get(1);

        String[] expected = { "B.java", "40", fixedTime.toString(), "src" };
        assertArrayEquals(expected, fileToStringArray(bJava));
    }

    @Test
    public void verifyFileEqualityBuildXml() {
        File build = fs.getRootDirs().getFirst()
                .getSubDirectories().getFirst()
                .getFiles().getFirst();

        String[] expected = { "build.xml", "2", fixedTime.toString(), "hw01" };
        assertArrayEquals(expected, fileToStringArray(build));
    }

    @Test
    public void verifyFileEqualityReadme() {
        File readme = fs.getRootDirs().getFirst().getFiles().getFirst();

        String[] expected = { "readme.md", "3", fixedTime.toString(), "umbcs680" };
        assertArrayEquals(expected, fileToStringArray(readme));
    }
}

