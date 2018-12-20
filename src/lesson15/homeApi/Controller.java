package lesson15.homeApi;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        Room[] selectedRooms;
        int length = 0;
        for (API api : apis) {
            selectedRooms = api.findRooms(price, persons, city, hotel);
            length += selectedRooms.length;
        }

        if (length == 0) {
            return new Room[0];
        }

        Room[] allRooms = new Room[length];
        int index = 0;
        for (API api : apis) {
            selectedRooms = api.findRooms(price, persons, city, hotel);
            for (Room selectedRoom : selectedRooms) {
                allRooms[index] = selectedRoom;
                index++;
            }

        }

        return allRooms;
    }

    public Room[] check(API api1, API api2) {
        int length = 0;

        Room[] api1Rooms = api1.getAll();
        Room[] api2Rooms = api2.getAll();

        for (Room api1Room : api1Rooms) {
            if (api1Room != null) {
                for (Room api2Room : api2Rooms) {
                    if (api2Room != null) {
                        if (api2Room.equals(api1Room) && api2Room.hashCode() == api1Room.hashCode())
                        {
                            length++;
                        }
                    }
                }
            }
        }

        if (length == 0) {
            return new Room[0];
        }

        Room[] matchRooms = new Room[length];
        int index = 0;

        for (Room api1Room : api1Rooms) {
            if (api1Room != null) {
                for (Room api2Room : api2Rooms) {
                    if (api2Room != null) {
                        if (api2Room.equals(api1Room) && api2Room.hashCode() == api1Room.hashCode())
                        {
                            matchRooms[index] = api1Room;
                            index++;
                        }
                    }
                }
            }
        }

        return matchRooms;
    }
}
