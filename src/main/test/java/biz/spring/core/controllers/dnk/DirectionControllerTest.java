package biz.spring.core.controllers.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.controllers.IntegratedTest;
import biz.spring.core.dto.dnk.DirectionDTO;
import biz.spring.core.utils.GridDataOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DirectionControllerTest extends IntegratedTest {

    @Test
    @Transactional
    @Rollback
    public void getListTest() throws Exception{
        GridDataOption gridDataOption = new GridDataOption.Builder()
                .setPage(1)
                .setRowCount(10)
                .setOrderBy("directionId")
                .build();
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/refbooks/direction/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"directionId\":1")))
                .andExpect(content().string(containsString("\"directionId\":2")))
                .andExpect(content().string(containsString("\"directionId\":3")))
                .andExpect(content().string(containsString("\"directionId\":4")))
                .andExpect(content().string(containsString("\"directionId\":5")));
    }

    @Test
    @Transactional
    @Rollback
    public void getTest() throws Exception{
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/refbooks/direction/get")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"directionId\":1")));
    }

    @Test
    @Transactional
    @Rollback
    public void saveTest() throws Exception{
        DirectionDTO directionDTO = new DirectionDTO(null, "Тестовое направление", null);
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/refbooks/direction/save")
                        .content(new ObjectMapper().writeValueAsString(directionDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"directionName\":\"Тестовое направление\"")));

        GridDataOption gridDataOption = new GridDataOption.Builder()
                .setPage(1)
                .setRowCount(10)
                .setOrderBy("directionId")
                .build();

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/refbooks/direction/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"directionId\":6")))
                .andExpect(content().string(containsString("\"directionName\":\"Тестовое направление\"")));
    }
}
