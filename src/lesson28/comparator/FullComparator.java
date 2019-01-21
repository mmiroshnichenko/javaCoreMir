package lesson28.comparator;

import java.util.Comparator;

public class FullComparator extends BaseComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        int res = compareObjectsByStringField(o1.getChannelName(), o2.getChannelName());
        if (res != 0) {
            return res;
        }

        res = compareObjectsByStringField(o1.getFingerprint(), o2.getFingerprint());
        if (res != 0) {
            return res;
        }

        DateComparator dateComparator = new DateComparator();
        return dateComparator.compare(o1, o2);
    }

    private int compareObjectsByStringField(String field1, String field2) {
        Integer res = compareObjectsWithNull(field1, field2);
        if (res == null) {
            res = field1.compareTo(field2);
        }

        return res;
    }


}
