package app.vercel.schooltrack.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CreateNewCodeServiceTest {

    int[] createNewCode() {
        Random random = new Random();
        int[] code = new int[6];

        for (int i = 0; i < code.length; i++) {
            code[i] = random.nextInt(10);
        }
        return code;
    }

    @Test
    void testCreateNewCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int[] code = createNewCode();
        for (int i = 0; i < code.length; i++) {
            code[i] = random.nextInt(10);
        }

        for (int num : code) {
            sb.append(num);
        }

        String codeString = sb.toString();

        assertTrue(codeString.chars().allMatch(Character::isDigit));
    }
}
