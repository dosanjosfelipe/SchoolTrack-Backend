package app.vercel.schooltrack.service;

import app.vercel.schooltrack.model.ClassRoom;
import app.vercel.schooltrack.repository.RoomRepository;
import app.vercel.schooltrack.utils.DbUtils;
import org.springframework.stereotype.Service;
import java.util.Random;


@Service
public class CreateRoomService {

    private final RoomRepository roomRepository;
    private final DbUtils dbUtils;

    public CreateRoomService(RoomRepository roomRepository, DbUtils dbUtils) {
        this.roomRepository = roomRepository;
        this.dbUtils = dbUtils;
    }

    public ClassRoom saveNewRoom() {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setCode(createNewCode());
        classRoom.setName("Nova sala");
        roomRepository.save(classRoom);
        return classRoom;
    }

    private String createNewCode() {
        Random random = new Random();
        for (int attempt = 0; attempt < 1_000_000; attempt++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(random.nextInt(10));
            }
            String code = sb.toString();
            if (!dbUtils.verifyRoom(code)) {
                return code;
            }
        }
        throw new IllegalStateException("Não foi possível gerar um novo código único.");
    }
}
