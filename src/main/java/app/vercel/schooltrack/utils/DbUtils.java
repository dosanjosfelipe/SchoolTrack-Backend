package app.vercel.schooltrack.utils;

import app.vercel.schooltrack.repository.RoomRepository;
import org.springframework.stereotype.Component;

@Component
public record DbUtils(RoomRepository roomRepository) {

    public boolean verifyRoom(String code) {
        return roomRepository.existsById(code);
    }
}
