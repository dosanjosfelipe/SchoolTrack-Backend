package app.vercel.schooltrack.service;

import org.springframework.stereotype.Service;
import java.util.Random;


@Service
public class CreateNewCodeService {

    public String createNewCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int[] code = new int[6];

        for (int i = 0; i < code.length; i++) {
            code[i] = random.nextInt(10);
        }

        // Faz o Array virar uma String sem espaços
        for (int num : code) {
            sb.append(num);
        }

        return sb.toString();
    }
}
