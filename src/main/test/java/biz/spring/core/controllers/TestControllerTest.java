package biz.spring.core.controllers;

import biz.spring.core.dto.dnk.TestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class TestControllerTest extends IntegratedTest{

    @Test
    @Rollback
    @Transactional
    public void getListTest() throws Exception{

        this.mockMvc.perform(post("/api/test/getlist")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"testId\":1")));
    }

    @Test
    @Rollback
    @Transactional
    public void getTest() throws Exception{
        this.mockMvc.perform(post("/api/test/get")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"testId\":1")));
    }
    @Test
    @Rollback
    @Transactional
    public void save() throws Exception{
        TestDTO testDTO = new TestDTO(null,"Тест","тест для проверки");
        this.mockMvc.perform(post("/api/test/save")
                        .content(new ObjectMapper().writeValueAsString(testDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"testId\":4")));
    }
}
