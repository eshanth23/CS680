package umbcs680.FSComparators;


import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement a, FSElement b) {
        return a.getSize() - b.getSize();
    }
}

