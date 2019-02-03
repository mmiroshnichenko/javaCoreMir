package main.lesson28.comparator;

import java.util.Comparator;

public class DateComparator extends BaseComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        return compareObjects(o1.getDateCreated(), o2.getDateCreated(), Order.DESC);
    }
}
