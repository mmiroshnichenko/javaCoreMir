package main.lesson8.ads;

public class CarAd extends Ad {
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;

    public CarAd(long id, int price) {
        super(id, price);
    }

    void confirmAd() {
        //some logic
    }

    @Override
    public String toString() {
        return "CarAd{" +
                "yearOfManufacturing=" + yearOfManufacturing +
                ", color='" + color + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", weight=" + weight +
                ", horsePower=" + horsePower +
                ", price=" + price +
                ", dateCreated=" + dateCreated +
                ", id=" + id +
                '}';
    }
}
