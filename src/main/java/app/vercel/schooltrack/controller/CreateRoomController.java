package app.vercel.schooltrack.controller;

import app.vercel.schooltrack.model.ClassRoom;
import app.vercel.schooltrack.service.CreateRoomService;
import app.vercel.schooltrack.utils.DbUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/createRoom")
public class CreateRoomController {

    private final CreateRoomService createRoomService;
    private final DbUtils dbUtils;

    public CreateRoomController(CreateRoomService createRoomService, DbUtils dbUtils) {
        this.createRoomService = createRoomService;
        this.dbUtils = dbUtils;
    }

    @GetMapping
    public ResponseEntity<?> newRoom() {
        ClassRoom classRoom = createRoomService.saveNewRoom();

        if (dbUtils.verifyRoom(classRoom.getCode())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "roomCode", classRoom.getCode(),
                    "roomName", classRoom.getName()
            ));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

