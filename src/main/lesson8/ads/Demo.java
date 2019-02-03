package main.lesson8.ads;

public class Demo {
    public static void main(String[] args) {
        CarAd carAd = new CarAd(1002, 250);
        System.out.println(carAd);

        HouseAd houseAd = new HouseAd(1002, 2500,"Pavel", "test rt", 100, 1);
        System.out.println(houseAd);
        if (houseAd.checkOwner()) {
            System.out.println("Owner is valid");
        } else {
            System.out.println("Wrong owner name");
        }
        houseAd.ownerName = "Denis";
        if (houseAd.checkOwner()) {
            System.out.println("Owner is valid");
        } else {
            System.out.println("Wrong owner name");
        }
        houseAd.ownerName = null;
        if (houseAd.checkOwner()) {
            System.out.println("Owner is valid");
        } else {
            System.out.println("Wrong owner name");
        }

        User userFrom = new User(12, "Ivan", "Kiev");
        System.out.println(userFrom);
        User userTo = new User(14, "Pavel", "Lvov");
        System.out.println(userTo);
        Message message = new Message(1006, userFrom, userTo, "Hello Pavel");
        System.out.println(message);

        message.setDateRead();
        System.out.println(message);
        if (message.isRead()) {
            System.out.println("Message is read");
        } else {
            System.out.println("Message is not read");
        }
    }
}
