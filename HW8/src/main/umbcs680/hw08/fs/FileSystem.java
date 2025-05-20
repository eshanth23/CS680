package umbcs680.hw08.fs;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs = new LinkedList<>();

    private FileSystem() {}

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public void appendRootDir(Directory root) {
        this.rootDirs.add(root);
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }

}
