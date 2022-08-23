package biz.spring.core.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class PostControllerTest extends IntegratedTest{

    @Test
    @Rollback
    @Transactional
    public void getListTest() throws Exception{
        this.mockMvc.perform(post("/api/post/getlist")
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print());
    }

    @Test
    @Rollback
    @Transactional
    public void getTest() throws Exception{
        this.mockMvc.perform(post("/api/post/get")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print());
    }
}