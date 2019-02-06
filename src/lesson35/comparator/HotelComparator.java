package lesson35.comparator;

import lesson35.model.Hotel;

import java.util.Comparator;

public class HotelComparator implements Comparator<Hotel> {
    @Override
    public int compare(Hotel hotel1, Hotel hotel2) {
        if (!hotel1.getName().equals(hotel2.getName())) {
            return hotel1.getName().compareTo(hotel2.getName());
        }
        if (!hotel1.getCountry().equals(hotel2.getCountry())) {
            return hotel1.getCountry().compareTo(hotel2.getCountry());
        }

        return hotel1.getCity().compareTo(hotel2.getCity());
    }
}
