package umbcs680.hw08.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.FileSystem;
import umbcs680.hw08.fs.TestFixtureInitializer;

import java.util.LinkedList;
import java.util.List;


public class FileCrawlingVisitorTest {
    private static FileSystem fs;
    private static Directory root;

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
        List<String> fileNames = new LinkedList<>();
        for(File f: files){
            fileNames.add(f.getName());
        }

        List<String> expectedNames = List.of("A.java", "B.java", "build.xml", "readme.md");

        assertIterableEquals(expectedNames, fileNames);
    }


}
