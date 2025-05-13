package umbcs680.FSElementSortLE;

import java.util.LinkedList;

class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    public void appendRootDir(Directory root) {
        this.rootDirs.add(root);
    }
}
