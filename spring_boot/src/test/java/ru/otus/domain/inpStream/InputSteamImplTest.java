package ru.otus.domain.inpStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("Запуск теста для класса InptStream")
class InputSteamImplTest {

    @Autowired
    private InptStream inputSteam;

    @Test
    public void shouldHaveCorrectGetList() {

        List<String[]> exp = Arrays.asList(new String[]{"How many bytes does the int data type have?"},
                new String[]{"How many bytes does the double data type have?"},
                new String[]{"How many bytes does the char data type have?"},
                new String[]{"How many bytes does a short data type have?"},
                new String[]{"How many bytes does a long data type have?"});
        for (int i = 0; i < exp.size(); i++) {
            assertEquals(Arrays.toString(exp.get(i)), Arrays.toString(inputSteam.getList().get(i)));
        }
    }
}