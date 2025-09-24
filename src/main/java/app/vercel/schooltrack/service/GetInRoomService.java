package app.vercel.schooltrack.service;

import app.vercel.schooltrack.model.ClassRoom;
import app.vercel.schooltrack.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class GetInRoomService {

    private final RoomRepository roomRepository;

    public GetInRoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public ClassRoom getRoom(String roomCode) {
        return roomRepository.findById(roomCode).orElse(null);
    }
}
