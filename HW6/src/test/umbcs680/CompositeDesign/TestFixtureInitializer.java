package umbcs680.CompositeDesign;

import java.time.LocalDateTime;

class TestFixtureInitializer {
    public static FileSystem createFS() {
        FileSystem Fs = FileSystem.getFileSystem();
        Fs.getRootDirs().clear();
        LocalDateTime fixedTime = LocalDateTime.now();

        Directory root = new Directory(null, "umbcs680", 0, fixedTime);

        Directory home = new Directory(root, "hw01", 0, fixedTime);
        Directory src = new Directory(home, "src", 0, fixedTime);
        File AJava = new File(src, "A.java", 30, fixedTime);
        File BJava = new File(src, "B.java", 40, fixedTime);
        File buildXml = new File(home, "build.xml", 2, fixedTime);

        File readme = new File(root, "readme.md", 3, fixedTime);

        root.appendChild(home);
        root.appendChild(readme);
        home.appendChild(src);
        home.appendChild(buildXml);
        src.appendChild(AJava);
        src.appendChild(BJava);

        Fs.appendRootDir(root);
        return Fs;
    }
}