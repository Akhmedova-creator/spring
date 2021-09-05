package ru.otus.spring.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.spring.page.BookPageController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookPageController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser(
            username = "admin"
    )
    @Test
    public void testAuthenticatedOnAdmin() throws Exception {
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk());
    }

}