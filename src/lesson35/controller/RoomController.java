package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.service.AuthorizationService;
import lesson35.service.RoomService;

import java.util.ArrayList;

public class RoomController {
    private RoomService roomService = new RoomService();

    public ArrayList<Room> findRooms(Filter filter) {
        return null;
    }

    public Room addRoom(Room room) throws Exception {
        AuthorizationService.checkAdminPermissions();

        return roomService.addRoom(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        AuthorizationService.checkAdminPermissions();

        roomService.deleteRoom(roomId);
    }
}
