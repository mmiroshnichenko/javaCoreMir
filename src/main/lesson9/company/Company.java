package main.lesson9.company;

public class Company {
    private String name;
    private String countryFounded;

    protected String code;

    public int someField;

    public Company(String name, String countryFounded) {
        this.name = name;
        this.countryFounded = countryFounded;
    }

    public String getName() {
        return name;
    }

    public String getCountryFounded() {
        return countryFounded;
    }

    public void setCountryFounded(String countryFounded) {
        this.countryFounded = countryFounded;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", countryFounded='" + countryFounded + '\'' +
                ", code='" + code + '\'' +
                ", someField=" + someField +
                '}';
    }
}
