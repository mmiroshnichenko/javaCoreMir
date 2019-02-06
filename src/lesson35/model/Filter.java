package lesson35.model;

import java.util.Date;

public class Filter {
    private int numberOfGuests;
    private double price;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Date dateAvailableFrom;
    private String country;
    private String city;

    public Filter(int numberOfGuests, double price, Boolean breakfastIncluded, Boolean petsAllowed, Date dateAvailableFrom, String country, String city) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.country = country;
        this.city = city;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public Boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public Boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
