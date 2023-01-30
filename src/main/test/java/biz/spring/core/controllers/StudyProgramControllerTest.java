package biz.spring.core.controllers;

import biz.spring.core.utils.GridDataOption;
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

public class StudyProgramControllerTest extends IntegratedTest{
    @Test
    @Rollback
    @Transactional
    public void getListTest() throws Exception {

        GridDataOption gridDataOption = new GridDataOption("");
        gridDataOption.getParams().put("studyProgramId", 1);
        gridDataOption.setPage(1);
        gridDataOption.setRowCount(10);

        this.mockMvc.perform(post("/api/studyprogram/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"studyProgramId\":1")));
    }

    @Test
    @Rollback
    @Transactional
    public void getTest() throws Exception {
        this.mockMvc.perform(post("/api/studyprogram/get")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"studyProgramId\":1")));
    }
}

