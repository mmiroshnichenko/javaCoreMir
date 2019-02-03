package main.lesson28.comparator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DemoComparator {
    public static void main(String[] args) throws Exception {

        Capability capability2 = new Capability(1005, "test2", "rrrr", false, null);
        Capability capability4 = new Capability(900, "test3", "rrrr", false, new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-19"));
        Capability capability3 = new Capability(900, "test", "rrrr1", true, new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-18"));
        Capability capability1 = new Capability(1001, null, "rrrr2", true, new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-14"));

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        System.out.println(capabilities);

        capabilities.sort(new IsActiveComparator());

        System.out.println(capabilities);

        capabilities.sort(new DateComparator());
        System.out.println("By date:");
        System.out.println(capabilities);

        capabilities.sort(new FullComparator());

        System.out.println(capabilities);
    }
}
