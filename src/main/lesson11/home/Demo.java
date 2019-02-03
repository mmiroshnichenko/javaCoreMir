package main.lesson11.home;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Room room11 = new Room(1011, 200, 3, new Date(), "Hilton", "London");
        Room room12 = new Room(1012, 210, 4, new Date(), "Hilton", "London");
        Room room13 = new Room(1013, 250, 2, new Date(), "MGK", "New York");
        Room room14 = new Room(1014, 150, 3, new Date(), "Ukraine", "Kiev");
        Room room15 = new Room(1015, 120, 2, new Date(), "Ukraine", "Kiev");
        Room room16 = new Room(1016, 100, 2, new Date(), "KNH", "Lvov");
        Room room17 = new Room(1017, 200, 3, new Date(), "FGN", "Odessa");
        Room room18 = new Room(1018, 250, 5, new Date(), "FGN", "Odessa");
        Room room19 = new Room(1019, 100, 3, new Date(), "HJK", "Kharkov");
        Room room110 = new Room(1110, 110, 4, new Date(), "HJK", "Kharkov");

        Room[] rooms1 = new Room[] {room11, room12, room13, room14, room15, room16, room17, room18, room19, room110, null, null};

        Room room21 = new Room(1021, 200, 3, new Date(), "Hilton", "London");
        Room room22 = new Room(1022, 210, 4, new Date(), "Hilton", "London");
        Room room23 = new Room(1023, 250, 2, new Date(), "MGK", "New York");
        Room room24 = new Room(1024, 150, 3, new Date(), "Ukraine", "Kiev");
        Room room25 = new Room(1025, 120, 2, new Date(), "Ukraine", "Kiev");
        Room room26 = new Room(1026, 100, 2, new Date(), "KNH", "Lvov");
        Room room27 = new Room(1027, 200, 3, new Date(), "FGN", "Odessa");
        Room room28 = new Room(1028, 250, 5, new Date(), "FGN", "Odessa");
        Room room29 = new Room(1029, 100, 3, new Date(), "HJK", "Kharkov");
        Room room210 = new Room(1210, 110, 4, new Date(), "HJK", "Kharkov");

        Room[] rooms2 = new Room[] {room21, room22, room23, room24, null, null, room25, room26, room27, room28, room29, room210};

        Room room31 = new Room(1031, 200, 3, new Date(), "Hilton", "London");
        Room room32 = new Room(1032, 210, 4, new Date(), "Hilton", "London");
        Room room33 = new Room(1033, 250, 2, new Date(), "MGK", "New York");
        Room room34 = new Room(1034, 150, 3, new Date(), "Ukraine", "Kiev");
        Room room35 = new Room(1035, 120, 2, new Date(), "Ukraine", "Kiev");
        Room room36 = new Room(1036, 100, 2, new Date(), "KNH", "Lvov");
        Room room37 = new Room(1037, 200, 3, new Date(), "FGN", "Odessa");
        Room room38 = new Room(1038, 250, 5, new Date(), "FGN", "Odessa");
        Room room39 = new Room(1039, 100, 3, new Date(), "HJK", "Kharkov");
        Room room310 = new Room(1310, 110, 4, new Date(), "HJK", "Kharkov");

        Room[] rooms3 = new Room[] {null, null, room31, room32, room33, room34, room35, room36, room37, room38, room39, room310};

        BookingComAPI bookingComAPI = new BookingComAPI(rooms1);
        GoogleAPI googleAPI = new GoogleAPI(rooms2);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms3);

        System.out.println(bookingComAPI);
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(200, 3, "London", "Hilton")));
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(105, 3, "London", "Hilton")));
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(250, 3, "London", "Hilton")));
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(250, 3, null, "Hilton")));

        System.out.println();
        System.out.println(googleAPI);
        System.out.println(Arrays.deepToString(googleAPI.findRooms(120, 2, "Kiev", "Ukraine")));
        System.out.println(Arrays.deepToString(googleAPI.findRooms(121, 2, "Kiev", "Ukraine")));

        System.out.println();
        System.out.println(tripAdvisorAPI);
        System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(200, 3, "Odessa", "FGN")));
        System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(200, 2, "Odessa", "FGN")));
        System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(200, 4, "Odessa", "FGN")));
        System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(215, 4, "Odessa", "FGN")));

        API[] apis = new API[]{bookingComAPI, googleAPI, tripAdvisorAPI};
        getAllRooms(apis);

        Controller controller = new Controller(apis);
        System.out.println();
        System.out.println(Arrays.deepToString(controller.requestRooms(200, 3, "London", "Hilton")));
        System.out.println(Arrays.deepToString(controller.requestRooms(105, 3, "London", "Hilton")));
        System.out.println(Arrays.deepToString(controller.requestRooms(250, 3, "London", "Hilton")));
        System.out.println(Arrays.deepToString(controller.requestRooms(200, 4, "London", "Hilton")));
        System.out.println(Arrays.deepToString(controller.requestRooms(200, 2, "London", "Hilton")));

        System.out.println();
        System.out.println(Arrays.deepToString(controller.check(bookingComAPI, googleAPI)));
        System.out.println(Arrays.deepToString(controller.check(googleAPI, tripAdvisorAPI)));
        System.out.println(Arrays.deepToString(controller.check(tripAdvisorAPI, bookingComAPI)));
    }

    private static void getAllRooms(API[] apis) {
        for (API api : apis) {
            if (api != null) {
                System.out.println();
                System.out.println(Arrays.deepToString(api.getAll()));
            }
        }
    }
}
