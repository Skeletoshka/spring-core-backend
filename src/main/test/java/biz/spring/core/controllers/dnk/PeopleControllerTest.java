package biz.spring.core.controllers.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.controllers.IntegratedTest;
import biz.spring.core.utils.GridDataOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PeopleControllerTest extends IntegratedTest {
    @Test
    @Rollback
    @Transactional
    public void getListTest() throws Exception{
        GridDataOption gridDataOption = new GridDataOption.Builder()
                .setOrderBy("peopleId")
                .setPage(1)
                .setRowCount(10)
                .build();
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/people/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"peopleId\":1")))
                .andExpect(content().string(containsString("\"peopleId\":2")))
                .andExpect(content().string(containsString("\"peopleId\":3")));

        gridDataOption = new GridDataOption.Builder()
                .setOrderBy("peopleId")
                .setPage(1)
                .setRowCount(10)
                .setParam("capClassId", 2)
                .build();
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/people/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(not(containsString("\"peopleId\":1"))))
                .andExpect(content().string(containsString("\"peopleId\":2")))
                .andExpect(content().string(not(containsString("\"peopleId\":3"))));
    }
    @Test
    @Rollback
    @Transactional
    public void getTest() throws Exception{
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/people/get")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"peopleId\":1")));
    }
}
