package main.lesson28.comparator;

import java.util.Comparator;

public class FullComparator extends BaseComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        int res = compareObjects(o1.getChannelName(), o2.getChannelName(), Order.ASC);
        if (res != 0) {
            return res;
        }

        res = compareObjects(o1.getFingerprint(), o2.getFingerprint(), Order.ASC);
        if (res != 0) {
            return res;
        }

        DateComparator dateComparator = new DateComparator();
        return dateComparator.compare(o1, o2);
    }
}
