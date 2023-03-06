package biz.spring.core.controllers;

import biz.spring.core.config.Config;
import biz.spring.core.payload.request.LoginRequest;
import biz.spring.core.payload.response.JwtResponse;
import biz.spring.core.utils.GridDataOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PostControllerTest extends IntegratedTest{

    @Test
    @Rollback
    @Transactional
    public void getListTest() throws Exception{

        GridDataOption gridDataOption = new GridDataOption.Builder()
                .setOrderBy("postId")
                .setParam("postId", 1)
                .setRowCount(10)
                .build();

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/post/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"postId\":1")));
    }

    @Test
    @Rollback
    @Transactional
    public void getTest() throws Exception{
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/post/get")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"postId\":1")));

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/post/get")
                        .content("100")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Запись с id = 100 не найдена")));
    }
}
