package umbcs680.FSComparators;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

