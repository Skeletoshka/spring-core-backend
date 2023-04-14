package biz.spring.core.controllers;

import biz.spring.core.config.Config;
import biz.spring.core.utils.GridDataOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CapClassControllerTest extends IntegratedTest{

    @Test
    @Transactional
    @Rollback
    public void getListTest() throws Exception{
        GridDataOption gridDataOption = new GridDataOption.Builder()
                .setOrderBy("capClassId")
                .setRowCount(10)
                .build();

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/capclass/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"capClassId\":1")))
                .andExpect(content().string(containsString("\"capClassId\":5")));

        gridDataOption = new GridDataOption.Builder()
                .setOrderBy("capClassId")
                .setParam("capClassTypeId", 2)
                .setRowCount(10)
                .build();

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/capclass/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(not(containsString("\"capClassId\":1"))))
                .andExpect(content().string(containsString("\"capClassId\":5")));
    }

}
