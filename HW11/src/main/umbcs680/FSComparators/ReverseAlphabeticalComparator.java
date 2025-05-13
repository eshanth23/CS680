package umbcs680.FSComparators;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o2.getName().compareToIgnoreCase(o1.getName());
    }
}

