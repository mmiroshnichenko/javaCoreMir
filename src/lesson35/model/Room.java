package lesson35.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room extends BaseModel {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public Room(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (numberOfGuests != room.numberOfGuests) return false;
        if (Double.compare(room.price, price) != 0) return false;
        if (breakfastIncluded != room.breakfastIncluded) return false;
        if (petsAllowed != room.petsAllowed) return false;
        if (!dateAvailableFrom.equals(room.dateAvailableFrom)) return false;
        return hotel.equals(room.hotel);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = numberOfGuests;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (breakfastIncluded ? 1 : 0);
        result = 31 * result + (petsAllowed ? 1 : 0);
        result = 31 * result + dateAvailableFrom.hashCode();
        result = 31 * result + hotel.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return id
                + ";" + numberOfGuests
                + ";" + price
                + ";" + breakfastIncluded
                + ";" + petsAllowed
                + ";" + dateFormat.format(dateAvailableFrom)
                + ";" + hotel.getId();
    }
}
