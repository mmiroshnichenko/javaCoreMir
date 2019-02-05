package lesson35.service;

import lesson35.model.Room;
import lesson35.repository.RoomRepository;

public class RoomService {
    private RoomRepository roomRepository = RoomRepository.getInstance();

    public Room addRoom(Room room) throws Exception {
        return roomRepository.addObject(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        roomRepository.removeById(roomId);
    }
}
