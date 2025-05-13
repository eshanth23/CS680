package umbcs680.FSEInternalIteration;

import java.time.LocalDateTime;

public class TestFixtureInitializer {
    public static FileSystem createFS() {
        FileSystem Fs = FileSystem.getFileSystem();
        Fs.getRootDirs().clear();
        LocalDateTime fixedTime = LocalDateTime.now();

        Directory root = new Directory(null, "umbcs680", 0, fixedTime);
        Directory hw01 = new Directory(root, "hw01", 0, fixedTime);
        Directory src = new Directory(hw01, "src", 0, fixedTime);

        File aJava = new File(src, "A.java", 30, fixedTime);
        File bJava = new File(src, "B.java", 40, fixedTime);
        File buildXml = new File(hw01, "build.xml", 2, fixedTime);
        File readme = new File(root, "readme.md", 3, fixedTime);

        Link rmLink = new Link(hw01, "rm.md", 0, fixedTime, readme);

        root.appendChild(hw01);
        root.appendChild(readme);
        hw01.appendChild(src);
        hw01.appendChild(buildXml);
        hw01.appendChild(rmLink);
        src.appendChild(aJava);
        src.appendChild(bJava);

        Fs.appendRootDir(root);
        return Fs;
    }
}

