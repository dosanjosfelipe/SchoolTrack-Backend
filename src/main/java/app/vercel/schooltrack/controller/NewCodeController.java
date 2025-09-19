package app.vercel.schooltrack.controller;

import app.vercel.schooltrack.service.CreateNewCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/newCode")
public class NewCodeController {

    private final CreateNewCodeService createNewCodeService;

    public NewCodeController(CreateNewCodeService createNewCodeService) {
        this.createNewCodeService = createNewCodeService;
    }


    @GetMapping
    public ResponseEntity<?> sendNewCode() {
        String newCode = createNewCodeService.createNewCode();

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "newCode", newCode
        ));
    }
}
