package umbcs680.hw08.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.FileSystem;
import umbcs680.hw08.fs.TestFixtureInitializer;

import java.util.List;
import java.util.stream.Collectors;

public class FileCrawlingVisitorTest {
    static FileSystem fs;
    static Directory root;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        root = fs.getRootDirs().getFirst();
    }

    @Test
    public void FileCrawlingVisitor_Finds_AllFiles() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);
        List<File> files = visitor.getFiles();

        assertEquals(4, files.size(), "Should collect 4 files");

        List<String> fileNames = files.stream()
                .map(File::getName)
                .sorted()
                .collect(Collectors.toList());

        List<String> expectedNames = List.of("A.java", "B.java", "build.xml", "readme.md");

        assertIterableEquals(expectedNames, fileNames, "The files Collected names should match the expected");
    }


}
