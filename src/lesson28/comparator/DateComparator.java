package lesson28.comparator;

import java.util.Comparator;

public class DateComparator extends BaseComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        Integer res = compareObjectsWithNull(o1.getDateCreated(), o2.getDateCreated());
        if (res == null) {
            res = o2.getDateCreated().compareTo(o1.getDateCreated());
        }
        return res;
    }
}
