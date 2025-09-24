package app.vercel.schooltrack.controller;

import app.vercel.schooltrack.dto.GetInRoomDTO;
import app.vercel.schooltrack.model.ClassRoom;
import app.vercel.schooltrack.service.GetInRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/getInRoom")
public class GetInRoomController {

    private final GetInRoomService getInRoomService;

    public GetInRoomController(GetInRoomService getInRoomService) {
        this.getInRoomService = getInRoomService;

    }

    @PostMapping
    public ResponseEntity<?> redirectToRoom(@RequestBody GetInRoomDTO dto) {

        ClassRoom room = getInRoomService.getRoom(dto.code());

        if ( room == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "roomCode", room.getCode(),
                "roomName", room.getName()
        ));
    }
}
